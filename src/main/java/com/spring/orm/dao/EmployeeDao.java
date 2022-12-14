package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Employee;

public interface EmployeeDao {
	
	public int insert(Employee emp);
	public Employee getEmployee(int employeeId);
	public List<Employee> getAllEmployees();
	public void Delete(int employeeId);
	public void update(Employee emp);

}
