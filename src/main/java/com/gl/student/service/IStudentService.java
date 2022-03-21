package com.gl.student.service;

import java.util.List;

import com.gl.student.entity.Student;

public interface IStudentService {

	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student st);

	public void deleteById(int theId);

	public List<Student> searchBy(String name, String id);

}
