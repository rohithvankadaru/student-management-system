package com.Rohith.StudentManagementSystem.configuration;

import com.Rohith.StudentManagementSystem.Model.Mentor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class MentorUserDetails implements UserDetails {


    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public MentorUserDetails(){}

    public MentorUserDetails(Mentor mentor) {
        this.name = mentor.getUsername();
        this.password = mentor.getPassword();

        authorities = Arrays.stream(mentor.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return name;

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
