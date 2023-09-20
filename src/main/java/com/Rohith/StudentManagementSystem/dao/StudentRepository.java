package com.Rohith.StudentManagementSystem.dao;

import com.Rohith.StudentManagementSystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByUsername(String username);
}
