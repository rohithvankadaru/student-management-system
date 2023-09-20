package com.Rohith.StudentManagementSystem.controller;


import com.Rohith.StudentManagementSystem.dto.request.StudentMarksRequestDto;
import com.Rohith.StudentManagementSystem.dto.request.StudentRequestDto;
import com.Rohith.StudentManagementSystem.dto.response.StudentMarksResponse;
import com.Rohith.StudentManagementSystem.dto.response.StudentResponse;
import com.Rohith.StudentManagementSystem.service.MentorService;
import com.Rohith.StudentManagementSystem.service.StudentMarksService;
import com.Rohith.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentMarksService studentMarksService;


    @PostMapping("/register-student")
//    @PreAuthorize("hasRole('STUDENT')")
//    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public ResponseEntity registerStudent(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponse studentResponse = null;
        try {
            studentResponse = studentService.registerStudent(studentRequestDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }


    @PutMapping("/updatePassword/{id}/{password}")
    public ResponseEntity<String> updatePassword(@PathVariable Integer id, @PathVariable String password){

        String message;
        try {
            message = mentorService.updatePassword(password, id);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping("/addMarks")
    public ResponseEntity addMarks(@RequestBody StudentMarksRequestDto studentMarksRequestDto){
        StudentMarksResponse studentMarksResponse;
        try {
            studentMarksResponse = studentMarksService.addOrUpdateMarks(studentMarksRequestDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(studentMarksResponse, HttpStatus.CREATED);
    }


    @GetMapping("/testAPI")
    public String test(){
        return "iam mentor accecced";
    }
}

