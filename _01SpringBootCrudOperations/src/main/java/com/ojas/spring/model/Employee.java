package com.ojas.spring.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employee_new")
public class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private String employeeAddress;
}
