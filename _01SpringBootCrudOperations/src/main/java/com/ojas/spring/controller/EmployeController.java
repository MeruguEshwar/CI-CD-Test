package com.ojas.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.spring.Repository.EmployeeRepository;
import com.ojas.spring.model.Employee;

@RestController
public class EmployeController {

	@Autowired
	private EmployeeRepository repos;
	
	@GetMapping("/test")
	public String hello() {
		return "hi eshwar";
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee student) {
		return repos.save(student);
	}
}
