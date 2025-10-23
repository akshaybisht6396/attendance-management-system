package com.yourcompany.student.attendance.management.system.attendance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Integer attendanceId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    @Enumerated(EnumType.STRING) // Stores the enum as a string ('Present', 'Absent')
    @Column(name = "status")
    private Status status; // Assuming you have a Status Enum (Present, Absent)
}