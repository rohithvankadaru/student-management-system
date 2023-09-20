package com.Rohith.StudentManagementSystem.controller;

import com.Rohith.StudentManagementSystem.dto.response.StudentMarksResponse;
import com.Rohith.StudentManagementSystem.service.StudentMarksService;
import com.Rohith.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentMarksService studentMarksService;

//    @PreAuthorize("hasRole('STUDENT')")
//    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/viewMarks/{id}")
    public ResponseEntity viewMarks(@PathVariable Integer id){
        StudentMarksResponse studentMarksResponse;
        try {
            studentMarksResponse = studentService.viewMarks(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentMarksResponse, HttpStatus.OK);
    }

    @PutMapping("/updatePassword/{id}/{password}")
    public ResponseEntity updatePassword(@PathVariable Integer id,@PathVariable String password){
        String message;
        try {
           message = studentService.updatePassword(id, password);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping("/addComment/{comment}/{id}")
    public ResponseEntity addComment(@PathVariable String comment,@PathVariable Integer id){
        String message;
        try {
            message = studentMarksService.addComment(comment, id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}

