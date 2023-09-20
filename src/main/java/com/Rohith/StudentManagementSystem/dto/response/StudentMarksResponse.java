package com.Rohith.StudentManagementSystem.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentMarksResponse {

    int telugu;

    int english;

    int maths;

    int science;

    int social;
}
