package com.ojas.thymleaf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	private int employeeID;
	private String employeName;
	private String employeType;
	private String employeeAddress;
}
