package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Student;

public class StudentDAO implements StudentDAOInterface {
	private Connection con;
	private PreparedStatement stmt;
	
	@Override
	public int addStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into Student values(?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, s.getStudentId());
			stmt.setString(2, s.getStudentName());
			stmt.setString(3, s.getStudentpwd());
			stmt.setString(4, s.getAge());
			stmt.setLong(5, s.getMobileNo());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deketeStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "delete from Student where stdid = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, s.getStudentId());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateStudent(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Student> getStudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList<>();
		String sql = "select* from Student";
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setStudentId(rs.getString(1));
				s.setStudentName(rs.getString(2));
				s.setStudentpwd(rs.getString(3));
				s.setAge(rs.getString(4));
				s.setMobileNo(rs.getLong(5));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public void getCOnnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
