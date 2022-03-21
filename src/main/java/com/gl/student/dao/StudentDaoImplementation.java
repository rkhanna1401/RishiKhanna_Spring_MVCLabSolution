package com.gl.student.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.student.entity.Student;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class StudentDaoImplementation implements IStudentDao{

	private SessionFactory sessionFactory;
	// create session
	private Session session;

	@Autowired
	StudentDaoImplementation(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}


	@Transactional
	@Override
	public List<Student> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Student> students =session.createQuery("from Student").list();

		tx.commit();

		return students;
	}

	@Transactional
	@Override
	public Student findById(int id) {
		Student student = new Student();
		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		student = session.get(Student.class, id);

		tx.commit();


		return student;
	}

	@Transactional
	@Override
	public void save(Student st) {
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(st);


		tx.commit();
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();

		// get transaction
		Student student = session.get(Student.class, id);

		// delete record
		session.delete(student);

		tx.commit();

	}

	@Transactional
	@Override
	public List<Student> searchBy(String name, String id) {
		String query="";
		Transaction tx = session.beginTransaction();
		if(name.length()!=0 && id.length()!=0)
			query ="from Student where STUDENT_NAME like '%"+name+"%' or author like '%"+id+"%'";
		else if(name.length()!=0)
			query ="from Student where STUDENT_NAME like '%"+name+"%'";
		else if(id.length()!=0)
			query ="from Student where STUDENT_ID like '%"+id+"%'";
		else
			System.out.println("Cannot search without input data");


		List<Student> student = session.createQuery(query).list();

		tx.commit();

		return student;
	}

	@Transactional
	public void print(List<Student> st) {

		for(Student s:st) 
		{
			System.out.println(s);
		}
	}
}
