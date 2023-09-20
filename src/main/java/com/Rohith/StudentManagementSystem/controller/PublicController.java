package com.Rohith.StudentManagementSystem.controller;

import com.Rohith.StudentManagementSystem.dto.request.AuthRequest;
import com.Rohith.StudentManagementSystem.dto.request.MentorRequestDto;
import com.Rohith.StudentManagementSystem.dto.response.MentorResponse;
import com.Rohith.StudentManagementSystem.configuration.service.JWTService;
import com.Rohith.StudentManagementSystem.service.MentorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/public")
@Slf4j
public class PublicController {


    @Autowired
    JWTService jwtService;

    @Autowired
    MentorService mentorService;

    @Autowired
    AuthenticationManager authenticationManager;



    @PostMapping("/register-mentor")
    public ResponseEntity registerMentor(@RequestBody MentorRequestDto mentorRequestDto){
        MentorResponse mentorResponse;
        try {
            mentorResponse = mentorService.registerMentor(mentorRequestDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(mentorResponse, HttpStatus.CREATED);
    }


    @PostMapping("/authenticateAndGetToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        throw new UsernameNotFoundException("Invalid user request");
    }

}
