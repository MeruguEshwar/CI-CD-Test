package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "sid")
	private int studentId;
	@Column(name = "sname")
	private String studentName;
	@Column(name = "marks")
	private String studentMarks;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(String studentMarks) {
		this.studentMarks = studentMarks;
	}

	public Student() {

	}

	public Student(int studentId, String studentName, String studentMarks) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ "]";
	}

}
