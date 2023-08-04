package com.demo.springRest.controllers;

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

import com.demo.springRest.models.Courses;
import com.demo.springRest.service.CourseService;

import jakarta.websocket.server.PathParam;

@RestController

public class TestController {
	
	@Autowired
	public CourseService courseService;
	
	@GetMapping("/home")
	public String welcomePage() {
		return "Welcome to SpringBoot";
	}
	
	//Get List of Courses
	@GetMapping("/courses")
	public List <Courses> getCourses(){
		
		return courseService.getCourses();
	}
	
	//Get Individual Course
	@GetMapping("/courses/{courseId}")
		
		public Courses getCourse(@PathVariable String courseId) {
			
			return courseService.getCourse(Long.parseLong(courseId));
		}
	
	
	//Add New Course
	@PostMapping("/courses")
    
    public Courses addCourse(@RequestBody Courses course) {
		   
		   return courseService.addCourse(course);
    	
        }
	
	 //Update existing Course
	  @PutMapping("/updateCourse")
      public Courses updateCourse(@RequestBody Courses course) {
    	  
    	  	return courseService.updateCourse(course);
    	
    	
       }
	  
	  //Delete Course
	  
	  @DeleteMapping("/deleteCourse/{courseId}")
	  public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		  
		  try {
		   courseService.deleteCourse(Long.parseLong(courseId));
		   
		   return new ResponseEntity<>(HttpStatus.OK);
		   
		  }catch(Exception e) {
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  
		  }
		  
	  }
	  
	  
	  
	}

  

    

