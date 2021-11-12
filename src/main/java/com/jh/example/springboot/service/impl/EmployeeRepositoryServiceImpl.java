package com.jh.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.jh.example.springboot.model.Employee;
import com.jh.example.springboot.repository.EmployeeRepository;
import com.jh.example.springboot.service.IEmployeeRepositoryService;

public class EmployeeRepositoryServiceImpl implements IEmployeeRepositoryService {

    private EmployeeRepository employeeRepository = new EmployeeRepository();
	
	@Override
	public Employee getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getAllEmployees(Integer employeeId) {
		 Employee employee = employeeRepository.findById(employeeId)
		            .orElseThrow();
		        return employee;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}
