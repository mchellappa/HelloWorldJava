package com.jh.example.springboot.service;

import java.util.List;

import com.jh.example.springboot.model.Employee;

public interface IEmployeeRepositoryService {

	List <Employee> getEmployees();
	
	Employee getEmployee(Long employeeId);
	
	Employee addEmployee (Employee employee);
	
	String deleteEmployee(Employee employeeId);
}
