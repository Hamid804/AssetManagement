package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	// add employee
	@PostMapping("/")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		
		Employee employee2 = this.employeeService.addEmployee(employee);
		
		return ResponseEntity.ok(employee2);
	}
	
	
	// update employee
	@PutMapping("/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(this.employeeService.updateEmployee(employee));
	}
	
	
	// get employee by id
	@GetMapping("/{aId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("aId") int aId) {
		return ResponseEntity.ok(this.employeeService.getEmployee(aId));
	}
	
	
	// delete employee
	@DeleteMapping("/{eId}")
	public void deleteEmployee(@PathVariable("eId") int eId) {
		this.employeeService.deleteEmployee(eId);
	}

}
