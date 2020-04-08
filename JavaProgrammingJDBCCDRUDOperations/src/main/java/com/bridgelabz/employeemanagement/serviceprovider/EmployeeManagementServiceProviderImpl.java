package com.bridgelabz.employeemanagement.serviceprovider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.bridgelabz.employeemanagement.configuration.EmployeeManagementConfiguration;
import com.bridgelabz.employeemanagement.repository.EmployeeManagementRepository;
import com.bridgelabz.employeemanagement.utils.InputUtility;
import com.bridgelabz.employeemanagement.utils.OutputUtility;

public class EmployeeManagementServiceProviderImpl implements EmployeeManagementServiceProvider {
	private static EmployeeManagementConfiguration configuration = EmployeeManagementConfiguration.getConfigurationInstance();
	private static Properties properties = configuration.getConfiguredPropertyObject();
	private static EmployeeManagementRepository repo = new EmployeeManagementRepository(properties.getProperty("TABLENAME"));
	EmployeeServceProviderImpl impl;
	@Override
	public void register() {
		logger.info("The table in which you are going to insert is "+properties.getProperty("TABLENAME"));
		String insertTableQuery = repo.getInsertQuery();

		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				PreparedStatement preparedStatement = connection.prepareStatement(insertTableQuery);) {
			logger.info("Enter the Employee ID number : ");
			long iD = InputUtility.longVal();
			logger.info("Enter the Employee First Name : ");
			String firstName = InputUtility.stringVal();
			logger.info("Enter the Employee Last Name : ");
			String lastName = InputUtility.stringVal();
			logger.info("Enter the Employee Email ID : ");
			String email = InputUtility.stringVal();
			logger.info("Enter the Employee Mobile Number : ");
			long mobileNumber = InputUtility.longVal();

			preparedStatement.setLong(1, iD);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setString(4, email);
			preparedStatement.setLong(5, mobileNumber);

			int noOfRowsAffected = preparedStatement.executeUpdate();
			logger.info("Successfully created table and number of rows affected are " + noOfRowsAffected);
		} catch (SQLException e) {
			logger.error(e);
		}

	}

	@Override
	public void getEmpDetails() {
		String readTableQuery = repo.getReadTableQuery();
		OutputUtility.println(
				"_________________________________________________________________________________________________");
		OutputUtility.println("|\t| EmpID |\t| EmpFirstName |\t| EmpLastName |\t| EmpEmail |\t| EmpMobileNumber |\t|");
		OutputUtility.println(
				"_________________________________________________________________________________________________");
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				PreparedStatement preparedStatement = connection.prepareStatement(readTableQuery);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				long EmpID = rs.getLong("EmpID");
				String EmpFirstName = rs.getString("EmpFirstName");
				String EmpLastName = rs.getString("EmpLastName");
				String EmpEmail = rs.getString("EmpEmail");
				long EmpMobileNumber = rs.getLong("EmpMobileNumber");

				OutputUtility.println("|\t|" + EmpID + "|\t|" + EmpFirstName + "|\t|" + EmpLastName + "|\t|" + EmpEmail
						+ "|\t|" + EmpMobileNumber + "|\t|");
				OutputUtility.println(
						"_________________________________________________________________________________________________");
			}
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public void getEmpDetailsByID() {
		String readOnIDQuery = repo.getReadTableOnIDQuery();
	
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				PreparedStatement preparedStatement = connection.prepareStatement(readOnIDQuery);) {
			ResultSet rs = preparedStatement.executeQuery(readOnIDQuery);
			if(rs.next()) {
			OutputUtility.println(
						"--------------------------------------------------------------------------------------------------------------");
			OutputUtility.println("|\t| EmpID |\t| EmpFirstName |\t| EmpLastName |\t\t| EmpEmail |\t| EmpMobileNumber |\t|");
			OutputUtility.println(
						"--------------------------------------------------------------------------------------------------------------");
			long EmpID = rs.getLong("EmpID");
			String EmpFirstName = rs.getString("EmpFirstName");
			String EmpLastName = rs.getString("EmpLastName");
			String EmpEmail = rs.getString("EmpEmail");
			long EmpMobileNumber = rs.getLong("EmpMobileNumber");
			OutputUtility.println("|\t|" + EmpID + "|\t\t|" + EmpFirstName + "|\t\t|" + EmpLastName + "|\t\t|" + EmpEmail
					+ "|\t     |" + EmpMobileNumber + "|\t|");
			OutputUtility.println(
					"--------------------------------------------------------------------------------------------------------------");
			}


		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public void updateByID() {
		String updateOnIdQuery = repo.getUpdateOnIDQuery();
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				PreparedStatement preparedStatement = connection.prepareStatement(updateOnIdQuery);) {
			logger.info("Enter the New employee ID to replace with the old");
			long iD = InputUtility.longVal();
			preparedStatement.setLong(1, iD);
			logger.info("Enter the New Employee first Name to replace with the Old first name");
			String firstName = InputUtility.stringVal();
			if (!firstName.equalsIgnoreCase(null))
				preparedStatement.setString(2, firstName);
			logger.info("Enter the New Employee last name to replace with the Old last name");
			String lastName = InputUtility.stringVal();
			if (!lastName.equalsIgnoreCase(null))
				preparedStatement.setString(3, lastName);
			logger.info("Enter the New Employee email to replace with the Old email");
			String email = InputUtility.stringVal();
			preparedStatement.setString(4, email);
			logger.info("Enter the New Employee mobile number to replace with the Old mobile number");
			long mobileNumber = InputUtility.longVal();
			preparedStatement.setLong(5, mobileNumber);

			int noOfRowsAffected = preparedStatement.executeUpdate();
			logger.info("Successfully Updated the number of rows affected " + noOfRowsAffected);
		} catch (SQLException e) {

		}
	}

	@Override
	public void deleteTable() {
		String deleteTableQuery = repo.getDeleteTableQuery();
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				PreparedStatement preparedStatement = connection.prepareStatement(deleteTableQuery);) {
			int noOfRowsAffected = preparedStatement.executeUpdate();
			logger.info("Table Successfully Deleted " + noOfRowsAffected);
		} catch (SQLException e) {

		}
	}

	@Override
	public void deleteByID() {
		String deleteDetailsOnIDQuery = repo.getDeleteDetailsOnID();
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				PreparedStatement preparedStatement = connection.prepareStatement(deleteDetailsOnIDQuery);) {
			int noOfRowsAffected = preparedStatement.executeUpdate();
			logger.info("Successfully deleted no of rows affected are"+noOfRowsAffected);
		} catch (SQLException e) {
			logger.info(e);
		}
	}
	
	public static EmployeeServiceProviderImpl getInstance(){
		if(impl == null)
			impl = new EmployeeServiceProviderImpl();
		return impl;
	}
}
