package com.yourcompany.student.attendance.management.system.service;

import com.yourcompany.student.attendance.management.system.attendance.Attendance;
import com.yourcompany.student.attendance.management.system.dto.AttendanceRequest;

public interface AttendanceService {
    /**
     * Marks attendance for a student in a subject after validating both.
     * @param request The request containing studentId and subjectId.
     * @return The saved Attendance record.
     * @throws RuntimeException if student or subject ID is invalid.
     */
    public Attendance markAttendance(AttendanceRequest request);
}