package com.fil.springrest.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fil.springrest.entities.Course;

//chef- logic

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;

	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(12,"Java","this course has basics of java"));
		list.add(new Course(13,"JavaScript","this course has basics of javascript"));
		list.add(new Course(14,"JDBC","this course has basics of jdbc"));
		list.add(new Course(15,"JDBCXml","this course has basics of jdbc with xml"));
		
	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourses(long id) {
		Course c=null;
		for(Course course : list) {
			if (course.getId() == id) {
			 c= course;
			 break;	
			}
			 
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e ->{
			if(e.getId()== course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		}
		);
		return course;
	}

	@Override
	public void deleteCourse(long id) throws Exception  {
   // list=this.list.stream().filter(e -> e.getId()!=id).collect(Collectors.toList());
		if (!list.removeIf(courses -> courses.getId() == id)) throw new Exception("Not Found");	
	}
	}

