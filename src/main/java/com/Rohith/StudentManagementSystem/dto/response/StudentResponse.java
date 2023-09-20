package com.Rohith.StudentManagementSystem.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentResponse {

    Integer id;

    String username;

    int age;

    String mobileNumber;

    String emailId;
}
