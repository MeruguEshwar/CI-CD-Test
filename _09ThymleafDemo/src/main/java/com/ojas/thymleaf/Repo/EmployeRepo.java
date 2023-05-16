package com.ojas.thymleaf.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.thymleaf.model.Employee;

@Repository
public interface EmployeRepo extends JpaRepository<Employee, Integer> {

}
