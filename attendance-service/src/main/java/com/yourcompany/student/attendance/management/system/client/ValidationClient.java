package com.yourcompany.student.attendance.management.system.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.yourcompany.student.attendance.management.system.dto.Student;
import com.yourcompany.student.attendance.management.system.dto.Subject;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class ValidationClient {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "studentServiceBreaker", fallbackMethod = "fallbackStudentValidation")
    public Student validateStudent(Long studentId) {
        String url = "http://STUDENT-SERVICE/students/" + studentId;
        return restTemplate.getForObject(url, Student.class);
    }

    @CircuitBreaker(name = "subjectServiceBreaker", fallbackMethod = "fallbackSubjectValidation")
    public Subject validateSubject(Long subjectId) {
        String url = "http://SUBJECT-SERVICE/subjects/" + subjectId;
        return restTemplate.getForObject(url, Subject.class);
    }

    // Fallback methods that return null to indicate failure
    public Student fallbackStudentValidation(Long studentId, Throwable t) {
        return null;
    }

    public Subject fallbackSubjectValidation(Long subjectId, Throwable t) {
        return null;
    }
}