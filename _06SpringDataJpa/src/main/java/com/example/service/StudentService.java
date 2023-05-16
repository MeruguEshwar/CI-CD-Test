package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.StudentRepo;
import com.example.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	
	public Student addStudent(Student student) {
		return repo.save(student);
	}
}
