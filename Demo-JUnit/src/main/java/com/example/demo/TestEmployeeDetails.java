package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.model.EmployeeDetails;
import com.example.service.EmpBusinessLogic;

public class TestEmployeeDetails {
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	EmployeeDetails employee = new EmployeeDetails();

	@Test
	public void testCalculateAppriasal() {
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
		double appraisal = empBusinessLogic.calculateAppraisal(employee);
		assertEquals(600, appraisal, 0.0);
	}
	@Test
	public void testCalculateYearlySalary() {
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
		double salary = empBusinessLogic.calculateYearlySalary(employee);
		assertEquals(96000, salary, 0.0);
		// khẳng định a == b
	}
}
