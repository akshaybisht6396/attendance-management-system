package com.yourcompany.student.attendance.management.system.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourcompany.student.attendance.management.system.subject.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    // This interface will automatically have methods like save(), findById(), findAll(), etc.
}