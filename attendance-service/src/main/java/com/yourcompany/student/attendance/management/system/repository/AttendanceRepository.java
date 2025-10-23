package com.yourcompany.student.attendance.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourcompany.student.attendance.management.system.attendance.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    // Spring Data JPA automatically creates database methods for you
}