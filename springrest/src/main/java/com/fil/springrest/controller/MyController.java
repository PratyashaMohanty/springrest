package com.fil.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fil.springrest.entities.Course;
import com.fil.springrest.service.CourseService;

//waiter of resturaunt example - waiter:controls
//this annotation tells spring boot that this file is a controller file

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Hello World";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){  //controller method
		return this.courseService.getCourses(); //service method
	}
	@GetMapping("/courses/{id}")
	public Course getCourses(@PathVariable long id) {
		return this.courseService.getCourses(id);
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		}
	
//	@DeleteMapping("/courses/{id}")
//	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long id) {
//		try {
//			this.courseService.deleteCourse(id);
//			return new ResponseEntity<>(HttpStatus.OK);
//			
//		}
//		catch(Exception e) {
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	
//	@DeleteMapping("/courses/{id}")
//	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id) {
//		try {
//			this.courseService.deleteCourse(Long.parseLong(id));
//			return new ResponseEntity<>(HttpStatus.OK);
//			
//		}
//		catch(Exception e) {
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	
	
}
