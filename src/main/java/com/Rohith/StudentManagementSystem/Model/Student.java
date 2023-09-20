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
@Table(name = "student_table")
public class
Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    int age;

    String mobileNumber;

    String emailId;

    String commentOnMarks;


    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    StudentMarks studentMarks;

}