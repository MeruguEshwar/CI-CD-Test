package com.ojas.thymleaf.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.thymleaf.Repo.EmployeRepo;
import com.ojas.thymleaf.model.Employee;

@Service
public class EmployeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeRepo employerepo;

	@Override
	public List<Employee> viewEmploye() {
		
		List<Employee> addEmployee = new ArrayList<Employee>();
		
		List<Employee> employe = employerepo.findAll();
		
		for(Employee employee:employe) {
			Employee emp = new Employee();
			BeanUtils.copyProperties(addEmployee, employe);
			employe.add(emp);
		}
		return addEmployee;
	}

}
