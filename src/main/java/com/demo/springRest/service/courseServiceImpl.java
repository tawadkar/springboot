package com.demo.springRest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.demo.springRest.models.Courses;

@Service
public class courseServiceImpl implements CourseService{
	
	List<Courses> list;
	
	public courseServiceImpl() {
		
		list  =  new ArrayList<>();
		list.add(new Courses(145,"abc","xyz"));
		list.add(new Courses(146,"abc","xyz"));
		
	}

	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c= null;
		
		for(Courses course : list) {
			if(course.getId()== courseId) {
				c= course;
				break;
			}
		}
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		
		list.forEach(cr->{
			if(cr.getId()==course.getId()) {
				cr.setTitle(course.getTitle());
				cr.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
	
		list = this.list.stream().filter(cr->cr.getId()!=courseId).collect(Collectors.toList());
		
	}
	


}
