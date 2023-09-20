package com.Rohith.StudentManagementSystem.service;

import com.Rohith.StudentManagementSystem.Model.Student;
import com.Rohith.StudentManagementSystem.Model.StudentMarks;
import com.Rohith.StudentManagementSystem.dao.StudentRepository;
import com.Rohith.StudentManagementSystem.dto.response.StudentMarksResponse;
import com.Rohith.StudentManagementSystem.dao.StudentMarksRepository;
import com.Rohith.StudentManagementSystem.dto.request.StudentMarksRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMarksService {


    @Autowired
    StudentMarksRepository studentMarksRepository;

    @Autowired
    StudentRepository studentRepository;


    public StudentMarksResponse addOrUpdateMarks(StudentMarksRequestDto studentMarksRequestDto) throws Exception {

        StudentMarks studentMarks = studentMarksRepository.findByStudent_id(studentMarksRequestDto.getStudent_id());
        if (studentMarks == null){
            throw new Exception("Invalid ID!!!!");
        }


        studentMarks.setTelugu(studentMarksRequestDto.getTelugu());
        studentMarks.setEnglish(studentMarksRequestDto.getEnglish());
        studentMarks.setMaths(studentMarksRequestDto.getMaths());
        studentMarks.setScience(studentMarksRequestDto.getScience());
        studentMarks.setSocial(studentMarksRequestDto.getSocial());

        StudentMarks savedStudentMarks = studentMarksRepository.save(studentMarks);

        return StudentMarksResponse.builder()
                .telugu(savedStudentMarks.getTelugu())
                .english(savedStudentMarks.getEnglish())
                .maths(savedStudentMarks.getMaths())
                .science(savedStudentMarks.getScience())
                .social(savedStudentMarks.getSocial())
                .build();
    }



    public String addComment(String comment, Integer student_id) throws Exception {

        StudentMarks studentMarks = studentMarksRepository.findByStudent_id(student_id);

        Student student;
        try {
            student = studentRepository.findById(student_id).get();
        }
        catch (Exception e){
            throw new Exception("invalid id!!");
        }

        student.setCommentOnMarks(comment);
        studentRepository.save(student);


        studentMarks.setComment(comment);
        StudentMarks savedStudentMarks = studentMarksRepository.save(studentMarks);

        return "comment added : " + savedStudentMarks.getComment();
    }
}
