package com.edgar.jpa.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.jpa.models.Employee;
import com.edgar.jpa.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService service;
	
	@PostMapping("/new")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(service.newEmployee(employee));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> allEmployees(){
		return ResponseEntity.ok(service.getAllEmployees());
	}
}
