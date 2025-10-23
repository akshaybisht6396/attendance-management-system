package com.yourcompany.student.attendance.management.system.subject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "subject_name", nullable = false, unique = true)
    private String subjectName;

    // This will eventually link to a teacher in the teacher-service
    @Column(name = "teacher_id")
    private Integer teacherId; 
}