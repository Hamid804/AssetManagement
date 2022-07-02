package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	// adding a new employee
	public Employee addEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	
	// updating an employee
	public Employee updateEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	
	// getting an employee by id
	public Employee getEmployee(int eId) {
		return this.employeeRepository.findById(eId).get();
	}
	
	
	// deleting an employee
	public void deleteEmployee(int eId) {
		this.employeeRepository.deleteById(eId);
	}

}
