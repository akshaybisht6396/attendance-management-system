package com.yourcompany.student.attendance.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourcompany.student.attendance.management.system.attendance.Attendance;
import com.yourcompany.student.attendance.management.system.dto.AttendanceRequest;
import com.yourcompany.student.attendance.management.system.service.AttendanceService;

@RestController
// Suggestion: Add API versioning for future-proofing
@RequestMapping("/api/v1/attendance") 
public class AttendanceController {

    private final AttendanceService attendanceService;

    // Suggestion 1: Use constructor injection
    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // Suggestion 2: Use a more RESTful URL (POST /api/v1/attendance)
    @PostMapping
    public ResponseEntity<?> markAttendance(@RequestBody AttendanceRequest request) {
        try {
            Attendance savedAttendance = attendanceService.markAttendance(request);
            
            // Suggestion 3: Return a 201 Created status for successful creation
            return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
            
        } catch (RuntimeException e) {
            
            // Suggestion 4: Return the error message in the response body
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}