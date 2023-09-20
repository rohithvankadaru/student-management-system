package com.Rohith.StudentManagementSystem.service;


import com.Rohith.StudentManagementSystem.Model.Student;
import com.Rohith.StudentManagementSystem.Model.StudentMarks;
import com.Rohith.StudentManagementSystem.dao.StudentMarksRepository;
import com.Rohith.StudentManagementSystem.dao.StudentRepository;
import com.Rohith.StudentManagementSystem.dto.request.StudentRequestDto;
import com.Rohith.StudentManagementSystem.dto.response.StudentMarksResponse;
import com.Rohith.StudentManagementSystem.dto.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMarksRepository studentMarksRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public StudentResponse registerStudent(StudentRequestDto studentRequestDto) throws Exception {

        if (studentRepository.findByUsername(studentRequestDto.getUsername()) != null){
            throw new Exception("username already exists");
        }

        StudentMarks studentMarks = new StudentMarks();
        Student student = Student.builder()
                .username(studentRequestDto.getUsername())
                .password(passwordEncoder.encode(studentRequestDto.getPassword()))
                .age(studentRequestDto.getAge())
                .emailId(studentRequestDto.getEmailId())
                .mobileNumber(studentRequestDto.getMobileNumber())
                .studentMarks(studentMarks)
                .build();
        studentMarks.setStudent(student);


        Student savedStudent = studentRepository.save(student);

        return StudentResponse.builder()
                .id(savedStudent.getId())
                .username(savedStudent.getUsername())
                .age(savedStudent.getAge())
                .mobileNumber(savedStudent.getMobileNumber())
                .emailId(savedStudent.getEmailId())
                .build();
    }

    public StudentMarksResponse viewMarks(int id) throws Exception {
        StudentMarks studentMarks = studentMarksRepository.findByStudent_id(id);

        if(studentMarks == null){
            throw new Exception("invalid id!!");
        }

        return StudentMarksResponse.builder()
                .telugu(studentMarks.getTelugu())
                .english(studentMarks.getEnglish())
                .maths(studentMarks.getMaths())
                .science(studentMarks.getScience())
                .social(studentMarks.getSocial())
                .build();
    }


    public String updatePassword(Integer id, String Password) throws Exception {
        Student student;
        try {
            student = studentRepository.findById(id).get();
        }
        catch (Exception e){
            throw new Exception("Invalid id!!");
        }

        student.setPassword(Password);
        studentRepository.save(student);

        return "Updation Successful";
    }

}
