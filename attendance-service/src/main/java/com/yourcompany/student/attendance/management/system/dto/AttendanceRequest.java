package com.yourcompany.student.attendance.management.system.dto;

import com.yourcompany.student.attendance.management.system.attendance.Status;

// Updated to include all necessary fields for a request
public record AttendanceRequest(
    Integer studentId, 
    Integer subjectId, 
    Integer teacherId, 
    Status status
) {}