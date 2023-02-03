package com.src.dao;

import java.util.List;

import com.src.model.Employee;

public interface EmployeeDao {
	public void getConnection();
	public void closeConnection();
	public int addEmployee(Employee e);
	public int deleteEmployee(Employee e);
	public int updateEmployee(Employee e);
	public List<Employee> getEmployees();
}
