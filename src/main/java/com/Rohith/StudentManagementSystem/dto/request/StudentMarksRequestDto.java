package com.Rohith.StudentManagementSystem.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentMarksRequestDto {

    Integer student_id;

    int telugu;

    int english;

    int maths;

    int Science;

    int social;
}
