package com.dao;

import java.util.ArrayList;

import com.model.Student;

public interface StudentDAOInterface {
	public int addStudent(Student s);
	public int deketeStudent(Student s);
	public int updateStudent(Student s);
	public ArrayList<Student> getStudents();
	
	public void getCOnnection();
	public void closeConnection();
	
	
}
