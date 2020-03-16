package com.bridgelabz.employeemanagement.repository;

import org.apache.log4j.Logger;

import com.bridgelabz.employeemanagement.utils.InputUtility;

public class EmployeeManagementRepository {
	Logger logger = Logger.getLogger(EmployeeManagementRepository.class);
	private String tableName;
	
	public EmployeeManagementRepository() {
		
	}
	public EmployeeManagementRepository(String tableName) {
		this.tableName = tableName;
	}
	//Query to create a database with the user input name
	public String getCreateDatabaseQuery() {
		return "CREATE DATABASE IF NOT EXISTS ";
	}
	//Query to create a table with the user input name
	public String getCreateTableQuery() {
		return "CREATE TABLE IF NOT EXISTS "+tableName+"(EmpID int PRIMARY KEY, EmpFirstName VARCHAR(50), EmpLastName VARCHAR(50), EmpEmail VARCHAR(50), EmpMobileNumber long);";
	}
	
	//Query to Insert details into the table
	public String getInsertQuery() {
		return "INSERT INTO "+tableName+" values(?,?,?,?,?);";
	}
	
	//Query to Read details from the table
	public String getReadTableQuery() {
		return "SELECT * FROM "+tableName+";";
	}
	
	//Query to read details based on ID 
	public String getReadTableOnIDQuery() {
		logger.info("Enter the id of the employee whose details you want to read");
		int iD = InputUtility.intVal();
		return "select * from "+tableName+" where EmpID = "+iD+";";
	}
	
	//Query to update details based on ID
	public String getUpdateOnIDQuery() {
		logger.info("Enter the New Employee ID to replace with the Old ID");
		int id = InputUtility.intVal();
		return "UPDATE "+tableName+" SET EmpID = ?, EmpFirstName = ?, EmpLastName = ?, EmpEmail = ?, EmpMobileNumber = ? WHERE EmpID = "+id+";";
	}
	
	//Query to drop the complete table
	public String getDeleteTableQuery() {
		return "DROP TABLE "+tableName+";";
	}
	
	//query to delete particular person details based on id
	public String getDeleteDetailsOnID() {
		logger.info("Enter the New Employee ID to replace with the Old ID");
		int id = InputUtility.intVal();
		return "DELETE FROM "+tableName+" WHERE EmpID = "+id+";";
	}
}
