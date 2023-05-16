package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.reposiory.StudentRepo;

@RestController
public class WelcomeController {

	@Autowired
	private com.example.demo.reposiory.StudentRepo repo;

	@GetMapping("/hello")
	public String sayHello() {
		return "welcome";
	}

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return repo.save(student);
	}
}
