package com.ashok.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.model.Course;

@RestController
public class CourseController {

	@GetMapping("/courses/{course_id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("course_id") Integer courseId)
	{
		return new ResponseEntity<Course>(new Course(1, "BSC-IT","English"),HttpStatus.OK);
	}
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "Bsc-IT", "English"));
        courseList.add(new Course(2, "Bsc-CS", "English"));
        courseList.add(new Course(3, "Msc-IT", "English"));
        courseList.add(new Course(4, "Zend Certification", "English"));
        return new ResponseEntity<List<Course>>(courseList,HttpStatus.OK);
	}
}
