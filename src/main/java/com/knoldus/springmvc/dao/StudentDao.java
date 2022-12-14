package com.knoldus.springmvc.dao;

import java.util.List;

import com.knoldus.springmvc.model.Student;

public interface StudentDao {

	Student findById(int id);

	void saveStudent(Student student);
	
	public void saveOrUpdate(Student student);
	
	void deleteStudentByCode(String ssn);
	
	List<Student> findAllStudents();

	Student findStudentByCode(String ssn);

}
