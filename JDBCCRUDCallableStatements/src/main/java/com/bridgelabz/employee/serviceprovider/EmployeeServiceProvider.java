package com.bridgelabz.employee.serviceprovider;

import org.apache.log4j.Logger;

public interface EmployeeServiceProvider {
	Logger logger = Logger.getLogger(EmployeeServiceProvider.class);
	// default Method an java 8 feature to create database
	
	// abstract method to insert employeeDetails
	public void register();
	
	// abstract method to read employee details based on employee ID
	public void getEmpDetails();

	// abstract method to update employee details
	public void updateByID();

	// abstract method to delete details of an employee based on key
	public void deleteByID();

}
