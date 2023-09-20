package com.Rohith.StudentManagementSystem.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "student_marks_table")
public class StudentMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    int telugu;

    int english;

    int maths;

    int Science;

    int social;

    String comment;

    @OneToOne
    @JoinColumn
    Student student;
}
