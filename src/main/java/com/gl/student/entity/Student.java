package com.gl.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	private int id;


	@Column(name="STUDENT_NAME")
	private String name;


	@Column(name="STUDENT_DEPARTMENT")
	private String department;


	@Column(name="STUDENT_COUNTRY")
	private String country;


	public Student(String name, String department, String country) {
		super();
		this.id = 0;
		this.name = name;
		this.department = department;
		this.country = country;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


}
