package com.yourcompany.student.attendance.management.system.service;

import com.yourcompany.student.attendance.management.system.repository.StudentRepository;
import com.yourcompany.student.attendance.management.system.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service marks this class as the business logic layer for Spring.
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // This is constructor injection. It's a best practice for managing dependencies.
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Finds a student by their ID. This method is crucial for the attendance validation.
     * It uses the findById method provided by JpaRepository.
     * @param id The ID of the student to find.
     * @return An Optional<Student>, which will be empty if no student is found.
     */
    @Override
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    /**
     * Saves a new student to the database.
     * @param student The student object to save.
     * @return The saved student, now with a database-generated ID.
     */
    @Override
    public Student createStudent(Student student) {
        // You could add business logic here, like checking for duplicate roll numbers.
        return studentRepository.save(student);
    }

    /**
     * Retrieves a list of all students from the database.
     * @return A List of all Student objects.
     */
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}