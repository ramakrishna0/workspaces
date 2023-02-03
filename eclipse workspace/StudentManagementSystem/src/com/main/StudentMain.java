package com.main;

import java.util.ArrayList;

import com.dao.StudentDAO;
import com.dao.StudentDAOInterface;
import com.model.Student;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.setStudentId("6");
		s.setStudentpwd("password");
		s.setStudentName("rama");
		s.setAge("72");
		s.setMobileNo(9876543210l);
		StudentDAOInterface dao = new StudentDAO();
		dao.getCOnnection();
		if(dao.addStudent(s) > 0)
			System.out.println("insertion successful");
		
		ArrayList<Student> students = dao.getStudents();
		for(Student st: students) {
			System.out.println(st);
		}
		dao.closeConnection();
		
		
		
	}

}
