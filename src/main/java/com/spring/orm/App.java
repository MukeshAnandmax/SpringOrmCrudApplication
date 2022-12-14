package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.EmployeeDao;
import com.spring.orm.dao.EmployeeDaoImpl;
import com.spring.orm.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws NumberFormatException, IOException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
		EmployeeDao empdao = context.getBean("empDao", EmployeeDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = true;
		System.out.println("**************************************************************************************************************");
		System.out.println("                              Welcome to spring orm CRUD Application       ");
		System.out.println("**************************************************************************************************************");


		while (flag) {
	    	System.out.println("---------------------------------------------------------------------");

			System.out.println("Press 1 for add new Employee");
			System.out.println("Press 2 for Display one Employee");
			System.out.println("Press 3 for Display all Employee");
			System.out.println("Press 4 for Delete Employee");
			System.out.println("Press 5 for Update Employee");
			System.out.println("Press 6 for Exit");
			
	    	System.out.println("---------------------------------------------------------------------");


			try {

				Integer input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					//add new Employee
					
					Employee  emp = new Employee();
					System.out.println("Enter Employee ID");
					emp.setEmpId(Integer.parseInt(br.readLine()));
					
					System.out.println("Enter Employee Name");
					emp.setEmpName(br.readLine());
					
					System.out.println("Enter Employee city");
					emp.setEmpCity(br.readLine());
			    	
			    	empdao.insert(emp);
			    	System.out.println(".........................................................");

			    	System.out.println("Employee inserted");
			    	System.out.println(".........................................................");
					
					break;
				case 2:
					//Display one Employee
					System.out.println("Enter Employee ID");
					int id = Integer.parseInt(br.readLine());
			    	Employee employee = empdao.getEmployee(id);
			    	System.out.println(".........................................................");
			    	System.out.println(employee);
			    	System.out.println(".........................................................");

					
					break;
				case 3:
					//Display all Employee
			    	//Fetching All Employee
			    	List<Employee> list = empdao.getAllEmployees();
			    	
			    	System.out.println("---------------------*--------------------*----------------------------");
			    	for(Employee e:list) {
			    		System.out.println(e);
			    	}
			    	System.out.println("---------------------*--------------------*----------------------------");

					
					break;
				case 4:
					//Delete Employee
					System.out.println("Enter Employee ID to Delete");
					int id1 = Integer.parseInt(br.readLine());
					empdao.Delete(id1);
					System.out.println(".........................................................");

			    	System.out.println("Employee Deleted");
			    	System.out.println(".........................................................");
					
					
					break;
				case 5:
					// Updating Employee Data
					
					Employee  emp1 = new Employee();
					System.out.println("Enter Employee ID");
					emp1.setEmpId(Integer.parseInt(br.readLine()));
					
					System.out.println("Enter Employee Name to update");
					emp1.setEmpName(br.readLine());
					
					System.out.println("Enter Employee city to update");
					emp1.setEmpCity(br.readLine());
			    	
					empdao.update(emp1);
			    	System.out.println(".........................................................");

			    	System.out.println("Employee Details Updated");
			    	System.out.println(".........................................................");
					
					break;
				case 6:
					//Exit
					flag = false;
					break;

				default:
					break;
				}
			} catch (Exception e) {
				
				System.out.println("Invalid input, Try with another one..");
				e.printStackTrace();
			}

		}
		System.out.println("**************************************************************************************************************");
		System.out.println("ThankYou for using My Application.");
		System.out.println("See you soon...!!");
		System.out.println("**************************************************************************************************************");


		// Inserting employee
//    	Employee  emp = new Employee(6546,"Pritam Anand","Bhagalpur");
//    	
//    	int i = empdao.insert(emp);
//    	System.out.println(i+"Employee inserted");

		// Fetching Single Employee
//    	Employee employee = empdao.getEmployee(6546);
//    	System.out.println("---------------------------------------------------------------------");
//    	System.out.println(employee);
//    	System.out.println("---------------------------------------------------------------------");

		// Deleting one Employee
		// empdao.Delete(56546);

		// Updating Employee Data
//    	Employee  emp1 = new Employee(6546,"Pritam Anand","Delhi");
//    	empdao.update(emp1);
//    	
//
//    	//Fetching All Employee
//    	List<Employee> list = empdao.getAllEmployees();
//    	
//    	System.out.println("---------------------*--------------------*----------------------------");
//    	for(Employee e:list) {
//    		System.out.println(e);
//    	}
//    	System.out.println("---------------------*--------------------*----------------------------");

	}
}
