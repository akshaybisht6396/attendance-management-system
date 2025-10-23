package com.yourcompany.student.attendance.management.system.subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Make sure to import everything from here

import com.yourcompany.student.attendance.management.system.subject.Subject;
import com.yourcompany.student.attendance.management.system.subject.service.SubjectService;
import java.util.Optional; // Import Optional

@RestController
@RequestMapping("/subjects") // CORRECTED: Base path is now /subjects
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // NEW: Endpoint to get a single subject by ID
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Integer id) {
        Optional<Subject> subject = subjectService.findById(id); // Assuming service has findById
        return subject.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }
}