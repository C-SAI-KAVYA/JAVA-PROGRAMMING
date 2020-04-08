package com.bridgelabz.employee.serviceprovider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import com.bridgelabz.employee.configuration.EmployeeConfiguration;
import com.bridgelabz.employee.repository.EmployeeRepository;
import com.bridgelabz.employee.utils.InputUtility;
import com.bridgelabz.employee.utils.OutputUtility;

public class EmployeeServiceProviderImpl implements EmployeeServiceProvider {
	private static EmployeeConfiguration configuration = EmployeeConfiguration.getConfigurationInstance();
	private static Properties properties = configuration.getConfiguredPropertyObject();
	private static EmployeeRepository repo = new EmployeeRepository(properties.getProperty("TABLENAME"));
	private EmployeeServiceProviderImpl impl;
	
	private EmployeeServiceProviderImpl(){
	
	}
	@Override
	public void insertEmployeeDetails() {
		logger.info("The table in which you are going to insert is "+properties.getProperty("TABLENAME"));
		String insertTableQuery = repo.getInsertQuery();

		try(Connection connection = configuration.connectToDatabaseWithDatabaseName();){
			CallableStatement callableStatement = connection.prepareCall(insertTableQuery);
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

			callableStatement.setLong(1, iD);
			callableStatement.setString(2, firstName);
			callableStatement.setString(3, lastName);
			callableStatement.setString(4, email);
			callableStatement.setLong(5, mobileNumber);

			int noOfRowsAffected = callableStatement.executeUpdate();
			logger.info("Successfully Inserted and number of rows affected are " + noOfRowsAffected);
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public void readEmployeeDetailsOnID() {
		String readOnIDQuery = repo.getReadTableOnIDQuery();
	
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				CallableStatement callableStatement = connection.prepareCall(readOnIDQuery);) {
			
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.registerOutParameter(3, Types.VARCHAR);
			callableStatement.registerOutParameter(4, Types.VARCHAR);
			callableStatement.registerOutParameter(5, Types.VARCHAR);
			callableStatement.registerOutParameter(6, Types.INTEGER);
			
			logger.info("Enter ID whose details you want to read");
			long iD = InputUtility.longVal(); 
			callableStatement.setInt(1, iD);
		
			long EmpID = callableStatement.getLong("EmpID");
			String EmpFirstName = callableStatement.getString("EmpFirstName");
			String EmpLastName = callableStatement.getString("EmpLastName");
			String EmpEmail = callableStatement.getString("EmpEmail");
			long EmpMobileNumber = callableStatement.getLong("EmpMobileNumber");
			OutputUtility.println("|\t|" + EmpID + "|\t\t|" + EmpFirstName + "|\t\t|" + EmpLastName + "|\t\t|" + EmpEmail
					+ "|\t     |" + EmpMobileNumber + "|\t|");
			OutputUtility.println(
					"--------------------------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public void updateEmployeeDetailsOnID() {
		String updateOnIdQuery = repo.getUpdateOnIDQuery();
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				CallableStatement callableStatement = connection.prepareCall(updateOnIdQuery);) {
			logger.info("Enter the New employee ID whose details you want to update");
			long iD1 = InputUtility.longVal();
			callableStatement.setInt(1, iD1);
			logger.info("Enter the ID to replace with the old ID");
			long iD = InputUtility.longVal();
			callableStatement.setInt(2, iD);
			logger.info("Enter the New Employee first Name to replace with the Old first name");
			String firstName = InputUtility.stringVal();
			if (!firstName.equalsIgnoreCase(null))
				callableStatement.setString(3, firstName);
			logger.info("Enter the New Employee last name to replace with the Old last name");
			String lastName = InputUtility.stringVal();
			if (!lastName.equalsIgnoreCase(null))
				callableStatement.setString(4, lastName);
			logger.info("Enter the New Employee email to replace with the Old email");
			String email = InputUtility.stringVal();
			callableStatement.setString(5, email);
			logger.info("Enter the New Employee mobile number to replace with the Old mobile number");
			int mobileNumber = InputUtility.intVal();
			callableStatement.setInt(6, mobileNumber);

			int noOfRowsAffected = callableStatement.executeUpdate();
			logger.info("Successfully Updated the number of rows affected " + noOfRowsAffected);
		} catch (SQLException e) {

		}
	}

	@Override
	public void deleteEmployeeDetailsOnID() {
		String deleteDetailsOnIDQuery = repo.getDeleteDetailsOnID();
		try (Connection connection = configuration.connectToDatabaseWithDatabaseName();
				CallableStatement callableStatement = connection.prepareCall(deleteDetailsOnIDQuery);) {
			logger.info("Enter the ID whose details you want to delete");
			long iD = InputUtility.longVal();
			
			callableStatement.setInt(1, iD);
			int noOfRowsAffected = callableStatement.executeUpdate();
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
