package com.demo.springRest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springRest.dao.StudentRepository;
import com.demo.springRest.models.Students;

@RestController
@RequestMapping("/student")
public class mongoTestController {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Students student){
		
		Students save =  this.studentRepository.save(student);
		
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/getStudents")
	public ResponseEntity<?> getStudent(){
		
		return ResponseEntity.ok(this.studentRepository.findAll());
	}

}
