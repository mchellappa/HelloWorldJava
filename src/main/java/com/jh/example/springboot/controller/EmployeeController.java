package com.jh.example.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jh.example.springboot.exception.ResourceNotFoundException;
import com.jh.example.springboot.model.Employee;
import com.jh.example.springboot.service.impl.EmployeeRepositoryServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {
  
	@Autowired
    private EmployeeRepositoryServiceImpl employeeRepositoryService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepositoryService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeRepositoryService.getEmployee(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepositoryService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map <String,Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
    throws ResourceNotFoundException {
        Employee employee = employeeRepositoryService.getEmployee(employeeId);

        employeeRepositoryService.deleteEmployee(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}