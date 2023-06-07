package com.edgar.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.jpa.models.Employee;
import com.edgar.jpa.models.EmployeePkId;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeePkId> {

}
