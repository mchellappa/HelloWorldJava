package com.jh.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.example.springboot.model.Employee;
import com.jh.example.springboot.repository.EmployeeRepository;
import com.jh.example.springboot.service.IEmployeeRepositoryService;

@Service
public class EmployeeRepositoryServiceImpl implements IEmployeeRepositoryService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		 Employee employee = employeeRepository.findById(employeeId)
		            .orElseThrow();
		        return employee;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public String deleteEmployee(Employee employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
