package com.example.captcha.service;

import java.util.List;
import java.util.Optional;

import com.example.captcha.model.Employee;

public interface EmployeService {

	int createEmployes(Employee emp);
	List<Employee> getEmployees();
	Optional<Employee> getOneEmployees(int id);
}
