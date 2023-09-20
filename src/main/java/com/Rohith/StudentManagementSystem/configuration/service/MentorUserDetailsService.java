package com.Rohith.StudentManagementSystem.configuration.service;

import com.Rohith.StudentManagementSystem.Model.Mentor;
import com.Rohith.StudentManagementSystem.configuration.MentorUserDetails;
import com.Rohith.StudentManagementSystem.dao.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class MentorUserDetailsService implements UserDetailsService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<Mentor> mentor = mentorRepository.findByUsername(username);


        return mentor.map(MentorUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
    }
}
