package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

@RestController
public class StudentController {

	@GetMapping("/hello")
	public String sayHello() {
		return "welcome";
	}

	@Autowired
	private StudentService service;

	@GetMapping("/all")
	public List<Student> viewAllStudent() {
		System.out.println("hello1");
		return service.getAllStudents();
	}

	@PostMapping("/add")
	public Student adduser(@RequestBody Student std) {
		return service.addStudent(std);
	}

	@RequestMapping("/hello")
	public String home() {
		return "Hello World!";
	}
}
