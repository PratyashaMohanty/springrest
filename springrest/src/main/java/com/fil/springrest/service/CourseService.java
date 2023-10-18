package com.fil.springrest.service;

import java.util.List;

import com.fil.springrest.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	public Course getCourses(long id);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long id) throws Exception;
	
}
