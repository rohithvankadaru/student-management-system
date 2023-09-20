package com.Rohith.StudentManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}







//	Create a database to hold student records and Mentor records. Write rest apis to update student records with privilege of Mentor and the Mentor can only modify student records the student can only view and comment
//		Privilege of Mentor
//		Add students
//		Add and modify marks of student
//		Mentor can change his password
//		All 3 tasks are done using rest apis
//		Student privileges
//		View his marks and comment
//		Student can also change his password
//		All the calls are implement using rest APIS