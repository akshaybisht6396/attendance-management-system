package com.yourcompany.student.attendance.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourcompany.student.attendance.management.system.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Spring Data JPA automatically creates database methods for you
}