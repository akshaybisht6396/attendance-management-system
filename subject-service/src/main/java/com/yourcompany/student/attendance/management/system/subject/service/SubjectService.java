package com.yourcompany.student.attendance.management.system.subject.service;

import com.yourcompany.student.attendance.management.system.subject.Subject;
import java.util.Optional;

/**
 * Service interface for managing Subject entities.
 */
public interface SubjectService {

    /**
     * Saves a new subject to the database.
     */
    Subject save(Subject subject);

    /**
     * Finds a subject by its ID. This is crucial for validation.
     */
    Optional<Subject> findById(Integer id); // <-- This line must be present
}