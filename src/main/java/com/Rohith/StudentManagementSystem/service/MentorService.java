package com.Rohith.StudentManagementSystem.service;


import com.Rohith.StudentManagementSystem.Model.Mentor;
import com.Rohith.StudentManagementSystem.dao.MentorRepository;
import com.Rohith.StudentManagementSystem.dto.request.MentorRequestDto;
import com.Rohith.StudentManagementSystem.dto.response.MentorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public MentorResponse registerMentor(MentorRequestDto mentorRequestDto) throws Exception {

        if (mentorRepository.findByUsername(mentorRequestDto.getUsername()).isPresent()){
            throw new Exception("username already exists");
        }


        Mentor mentor = Mentor.builder()
                .username(mentorRequestDto.getUsername())
                .age(mentorRequestDto.getAge())
                .emailId(mentorRequestDto.getEmailId())
                .mobileNumber(mentorRequestDto.getMobileNumber())
                .password(passwordEncoder.encode(mentorRequestDto.getPassword()))
                .roles("MENTOR")
                .build();

        Mentor savedMentor = mentorRepository.save(mentor);

        return MentorResponse.builder()
                .id(savedMentor.getId())
                .username(savedMentor.getUsername())
                .age(savedMentor.getAge())
                .mobileNumber(savedMentor.getMobileNumber())
                .emailId(savedMentor.getEmailId())
                .build();
    }


    public String updatePassword(String password, Integer id) throws Exception {
        Mentor mentor;
        try {
            mentor = mentorRepository.findById(id).get();
        }
        catch (Exception e){
            throw new Exception("invalid id!!");
        }

//        mentor.setPassword(passwordEncoder.encode(password));
        mentorRepository.save(mentor);

        return "Password Updated Successfully";

    }

}