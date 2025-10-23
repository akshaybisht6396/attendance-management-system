package com.yourcompany.student.attendance.management.system.service;

import com.yourcompany.student.attendance.management.system.student.Student;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Student entities.
 * Defines the contract for the business logic related to students.
 */
public interface StudentService {

    /**
     * Retrieves a student by their unique ID.
     * @param id The ID of the student to find.
     * @return An Optional containing the student if found, otherwise empty.
     */
    Optional<Student> getStudentById(Integer id);

    /**
     * Saves a new student and returns the created student entity.
     * @param student The student object to save.
     * @return The saved student, now with a database-generated ID.
     */
    Student createStudent(Student student);

    /**
     * Returns a list of all students.
     * @return A List of all Student objects.
     */
    List<Student> getAllStudents();
}