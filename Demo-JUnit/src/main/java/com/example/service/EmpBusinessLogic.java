package com.example.service;

import com.example.model.EmployeeDetails;

public class EmpBusinessLogic {
	public double calculateYearlySalary(EmployeeDetails employeeDetails) {
		double yearlySalary = 0;
		yearlySalary = employeeDetails.getMonthlySalary() * 12;
		return yearlySalary;
	}
	// Calculate the appraisal amount of employee
	public double calculateAppraisal(EmployeeDetails employeeDetails) {
		double appraisal = 0;
		if (employeeDetails.getMonthlySalary() < 10000) {
			appraisal = 500;
		} else {
			appraisal = 1000;
		}
		return appraisal;
	}
}
