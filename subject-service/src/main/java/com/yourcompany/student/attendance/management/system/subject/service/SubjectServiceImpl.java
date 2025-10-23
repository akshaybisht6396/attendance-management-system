package com.yourcompany.student.attendance.management.system.subject.service;

import com.yourcompany.student.attendance.management.system.subject.Subject;
import com.yourcompany.student.attendance.management.system.subject.repository.SubjectRepository; // Make sure this import is correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    // This is the new method you need to add
    @Override
    public Optional<Subject> findById(Integer id) {
        return subjectRepository.findById(id);
    }
}