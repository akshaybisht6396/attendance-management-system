package com.yourcompany.student.attendance.management.system.dto;

// This record defines the structure of the student data
// that you expect to receive from the student-service.
public record Student(Long id, String name, String email) {
}