package com.bridgelabz.employeemanagement.serviceprovider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.bridgelabz.employeemanagement.configuration.EmployeeManagementConfiguration;
import com.bridgelabz.employeemanagement.repository.EmployeeManagementRepository;
import com.bridgelabz.employeemanagement.utils.InputUtility;

@SuppressWarnings("null")
public interface EmployeeManagementServiceProvider {
	Logger logger = Logger.getLogger(EmployeeManagementServiceProvider.class);
	// default Method an java 8 feature to create database

	public default void createDatabase() {
		logger.info("Enter the database name you want to create");
		String databaseName = InputUtility.stringVal();
		EmployeeManagementRepository repo = new EmployeeManagementRepository();
		EmployeeManagementConfiguration configuration = EmployeeManagementConfiguration.getConfigurationInstance();
		Properties properties = configuration.getConfiguredPropertyObject();

		try (OutputStream outputstreamwriter = new FileOutputStream(
				"F:\\BridgeLabzFellowship\\JavaProgrammingJDBCCDRUDOperations\\resources\\Configuration.properties")) {
			properties.setProperty("DATABASENAME", databaseName);
			properties.store(outputstreamwriter, null);
			logger.info("successfully updated the properties file");
		} catch (IOException ioe) {

		}

		String createdatabaseQuery = repo.getCreateDatabaseQuery();
		logger.info(createdatabaseQuery+databaseName+";");
		try (Connection connection = configuration.connectToDatabase(); 
				Statement statement = connection.createStatement();){
			statement.execute(createdatabaseQuery+databaseName+";");
			logger.info("Successfully created database");
		} catch (SQLException e) {
			logger.error(e);
		}

	}

	// default Method an Java 8 feature to create a table
	public default void createEmployeeDetailsTable() {
		logger.info("Enter the table name you want to create");
		String tableName = InputUtility.stringVal();
		EmployeeManagementRepository repo = new EmployeeManagementRepository(tableName);
		EmployeeManagementConfiguration configuration = EmployeeManagementConfiguration.getConfigurationInstance();
		Properties properties = configuration.getConfiguredPropertyObject();

		try (OutputStream outputstreamwriter = new FileOutputStream(
				"F:\\BridgeLabzFellowship\\JavaProgrammingJDBCCDRUDOperations\\resources\\Configuration.properties")) {
			properties.setProperty("TABLENAME", tableName);
			properties.store(outputstreamwriter, null);
			logger.info("successfully updated the properties file");
		} catch (IOException ioe) {

		}

		String createTableQuery = repo.getCreateTableQuery();

		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);) {
			int noOfRowsAffected = preparedStatement.executeUpdate();
			logger.info("Successfully created table and number of rows affected are " + noOfRowsAffected);
		} catch (SQLException e) {
			logger.error(e);
		}

	}

	// abstract method to insert employeeDetails
	public void insertEmployeeDetails();

	// abstract method to read employee details
	public void readEmployeeDetailsTable();

	// abstract method to read employee details based on employee ID
	public void readEmployeeDetailsOnID();

	// abstract method to update employee details
	public void updateEmployeeDetailsOnID();

	// abstract method to delete employee details table
	public void deleteEmployeeDetailsTable();

	// abstract method to delete details of an employee based on key
	public void deleteEmployeeDetailsOnID();

}
