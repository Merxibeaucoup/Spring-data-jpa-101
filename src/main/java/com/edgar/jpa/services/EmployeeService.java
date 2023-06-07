package com.edgar.jpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edgar.jpa.models.Employee;
import com.edgar.jpa.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository repository;

	// save employee
	public Employee newEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	// get all employees
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}

}
