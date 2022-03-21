package com.gl.student.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.student.entity.Student;

@Service
public interface IStudentDao {


		public List<Student> findAll();

		public Student findById(int theId);

		public void save(Student st);

		public void deleteById(int theId);

		public List<Student> searchBy(String name, String id);

	}

