package com.jh.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.jh.example.springboot.model.Employee;
import com.jh.example.springboot.repository.EmployeeRepository;
import com.jh.example.springboot.service.IEmployeeRepositoryService;

public class EmployeeRepositoryServiceImpl implements IEmployeeRepositoryService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		 Employee employee = employeeRepository.findById(employeeId)
		            .orElseThrow();
		        return employee;
	}

	@Override
	public Employee addEmployees(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}
