package com.yourcompany.student.attendance.management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yourcompany.student.attendance.management.system.attendance.Attendance;
import com.yourcompany.student.attendance.management.system.dto.AttendanceRequest;
import com.yourcompany.student.attendance.management.system.repository.AttendanceRepository;
import java.time.LocalDate;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Attendance markAttendance(AttendanceRequest request) {
        // 1. Validate the Student and Subject by calling their respective services
        validateEntity("STUDENT-SERVICE", "students", request.studentId(), "Student");
        validateEntity("SUBJECT-SERVICE", "api/subjects", request.subjectId(), "Subject");
        
        // The TEACHER-SERVICE validation has been removed since it doesn't exist.
        // validateEntity("TEACHER-SERVICE", "api/teachers", request.teacherId(), "Teacher");

        // 2. If all validations pass, create the new Attendance entity
        Attendance newAttendance = new Attendance();
        
        // 3. Set all the properties from the request
        newAttendance.setStudentId(request.studentId());
        newAttendance.setSubjectId(request.subjectId());
        newAttendance.setTeacherId(request.teacherId());
        newAttendance.setStatus(request.status());
        newAttendance.setAttendanceDate(LocalDate.now()); // Set the current date
        
        // 4. Save the new record to the database and return it
        return attendanceRepository.save(newAttendance);
    }

    /**
     * A private helper method to avoid duplicating the validation logic.
     * It calls an external service to check if an ID is valid.
     */
    private void validateEntity(String serviceName, String apiPath, Integer id, String entityName) {
        try {
            String url = "http://" + serviceName + "/" + apiPath + "/" + id;
            restTemplate.getForObject(url, Object.class);
        } catch (Exception e) {
            // If the call fails, throw an exception that the controller can handle
            throw new RuntimeException("Invalid " + entityName + " ID or " + entityName + " Service is unavailable: " + id);
        }
    }
}

