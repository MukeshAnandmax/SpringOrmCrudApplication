package com.spring.orm.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private HibernateTemplate hibernetTemplet;

	
	// -----------------Save Employee Method----------------------------------
	@Transactional
	public int insert(Employee emp) {
		// TODO Auto-generated method stub
		Integer r = (Integer) this.hibernetTemplet.save(emp);
		return r;
	}

	// -----------------Get Single Employee Method----------------------------------

	public Employee getEmployee(int employeeId) {
		
		Employee employee = this.hibernetTemplet.get(Employee.class, employeeId);
		
		return employee;
	}
	// -----------------Get All Employee Method----------------------------------

	
	public List<Employee> getAllEmployees() {
		
		List<Employee> list = this.hibernetTemplet.loadAll(Employee.class);
		
		return list;
	}
	
	// -----------------Deleting one Employee Method----------------------------------
	@Transactional
	public void Delete(int employeeId) {
		
		this.hibernetTemplet.delete(getEmployee(employeeId));
		
	}

	// -----------------Updating one Employee Method----------------------------------
	@Transactional
	public void update(Employee emp) {
		this.hibernetTemplet.update(emp);
		
	}
	
	public HibernateTemplate getHibernetTemplet() {
		return hibernetTemplet;
	}

	public void setHibernetTemplet(HibernateTemplate hibernetTemplet) {
		this.hibernetTemplet = hibernetTemplet;
	}

	

	

	


}
