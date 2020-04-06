package com.bridgelabz.employee.repository;

import org.apache.log4j.Logger;

public class EmployeeRepository {
	Logger logger = Logger.getLogger(EmployeeRepository.class);
	private String tableName;
	
	public EmployeeRepository() {
		
	}
	public EmployeeRepository(String tableName) {
		this.tableName = tableName;
	}
	
	//Query to Insert details into the table
	public String getInsertQuery() {
		return "{call insertEmployee(?, ?, ?, ?, ?)}";
	}
	
	//Query to read details based on ID 
	public String getReadTableOnIDQuery() {
		return "{call readTableOnID(?, ?, ?, ?, ?, ?)}";
	}
	
	//Query to update details based on ID
	public String getUpdateOnIDQuery() {
		return "{call updateEmployee(?, ?, ?, ?, ?, ?)}";
	}
	
	//Query to drop the complete table
	public String getDeleteTableQuery() {
		return "DROP TABLE "+tableName+";";
	}
	
	//query to delete particular person details based on id
	public String getDeleteDetailsOnID() {
		return "{call deleteOnID(?)}";
	}
}
