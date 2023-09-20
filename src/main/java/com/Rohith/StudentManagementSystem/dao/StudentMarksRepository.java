package com.Rohith.StudentManagementSystem.dao;


import com.Rohith.StudentManagementSystem.Model.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {

    StudentMarks findByStudent_id(Integer id);
}
