package com.Rohith.StudentManagementSystem.dao;

import com.Rohith.StudentManagementSystem.Model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
    Optional<Mentor> findByUsername(String username);
}
