package com.ashok.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.model.Student;

@RestController
public class StudentController {

	@GetMapping("/name")
	public String getControllerName() {
		return "Student Controller";
	}
	
	@GetMapping("/students/{student_id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("student_id") Integer studentId) {
		Student student =new Student(1,"Ashok","BSC","India");
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@GetMapping("/course/{course_id}/students")
	public ResponseEntity<List<Student>> getStudentsByCourses(@PathVariable("course_id") Integer courseId) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"Ashok","BSC","India"));
		list.add(new Student(2,"kumar","MCA","TN"));
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@GetMapping("/department/{department_id}/courses/{course_id}/students")
	public ResponseEntity<List<Student>> getStudentbyDepartmentCourses() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"Ashok","BSC","India"));
		list.add(new Student(2,"kumar","MCA","TN"));
		list.add(new Student(3,"Dhesike","LKG","CHENNAI"));
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
}
