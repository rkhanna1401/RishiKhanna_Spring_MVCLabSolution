package com.gl.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.student.dao.StudentDaoImplementation;
import com.gl.student.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {


	@Autowired
	private StudentDaoImplementation studentService;



	@RequestMapping("/list")
	public String back() {
		return "redirect:/student/print";
	}

	@RequestMapping("/print")
	public String listStudents(Model theModel) {

		// get Books from db
		List<Student> st = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("student", st);

		return "list-Student";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student st = new Student();
		theModel.addAttribute("student", st);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId,
			Model theModel) {

		// get the Book from the service
		Student st = studentService.findById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("student", st);

		// send over to our form
		return "Student-form";			
	}


	@PostMapping("/save")
	public String saveStudentRecord(@RequestParam("id") int id,
			@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country) {

		//System.out.println(id);
		Student st = new Student();
		
		if(id!=0)
		{
			st=studentService.findById(id);
			st.setName(name);
			st.setDepartment(department);
			st.setCountry(country);
		}
		else
			st=new Student(name, department, country);
		// save the Book
		studentService.save(st);


		// use a redirect to prevent duplicate submissions
		return "redirect:/student/print";

	}


	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {

		// delete the Book
		studentService.deleteById(id);

		// redirect to /Books/list
		return "redirect:/student/print";

	}


}
