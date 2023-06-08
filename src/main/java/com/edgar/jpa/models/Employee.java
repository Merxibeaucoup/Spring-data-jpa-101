package com.edgar.jpa.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="EMPLOYEE_TB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(EmployeePkId.class)
public class Employee {
//	
// use thos for only @idClass
//	@Id
//	private Long employeeId;
//	@Id
//	private Long deptId;
	
	@EmbeddedId
	private EmployeePkId employeePkId;
	
	private String employeeName;
	
	private String employeeEmail;
	
	private String employeePhone;

}
