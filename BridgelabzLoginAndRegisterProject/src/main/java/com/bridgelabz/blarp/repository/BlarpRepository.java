package com.bridgelabz.blarp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bridgelabz.blarp.configuration.BlarpConfiguration;
import com.bridgelabz.blarp.dto.EngineerLoginDetailsDTO;
import com.bridgelabz.blarp.dto.EngineerRegistrationDetailsDTO;

public class BlarpRepository {
	Logger logger = Logger.getLogger(BlarpRepository.class);
	private static BlarpRepository repo = null;
	
	private BlarpRepository() {
		
	}
	
	public synchronized static BlarpRepository getInstance() {
		if(repo == null) 
			repo = new BlarpRepository();
		return repo;
	}
	
	BlarpConfiguration configuration = BlarpConfiguration.getConfigurationInstance();
	Connection connection = configuration.connectToDatabaseWithDatabaseName();
	String query = null;
	boolean status = false;
	
	/**
	 * To store the entered details into the data
	 * @param model
	 * @return
	 */
	public boolean registerUserAndStoreInDatabase(EngineerRegistrationDetailsDTO model) {
		query = "Insert into engineers_details values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		 
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, model.getEngineerID());
			preparedStatement.setString(2, model.getEngineerFirstName());
			preparedStatement.setString(3, model.getEngineerLastName());
			preparedStatement.setString(4, model.getEngineerDOB());
			preparedStatement.setString(5, model.getEngineerEmailID());
			preparedStatement.setString(6, model.getEngineerAddress());
			preparedStatement.setString(7, model.getEngineerMobileNumber());
			preparedStatement.setString(8, model.getEngineerYOP());
			preparedStatement.setString(9, model.getEngineerBranch());
			preparedStatement.setString(10, model.getEngineerAggregate());
			preparedStatement.setString(11, model.getAccountUserName());
			preparedStatement.setString(12, model.getAccountUserPassword());
			preparedStatement.setString(13, model.getAccountChangedPassword());
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			if(noOfRowsAffected != 0)
				status = true;
			logger.info("Successfully created table and number of rows affected are " + noOfRowsAffected);
		}catch(SQLException sqe) {
			logger.error(sqe);
		}
		logger.info("Successfully inserted data");
		return status;
	}
	
	/**
	 * method to check if the registering user already exist
	 * @param model
	 * @return
	 */
	public boolean checkUserAlreadyExsists(EngineerRegistrationDetailsDTO model) {
		query = "select * from engineers_details where accountUserName = ?;";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, model.getAccountUserName());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				return false;
			}
		}catch(SQLException sqe) {
			logger.error(sqe);
		}
		return true;
	}
	
	/**
	 * Method to check the user entered proper user credentials or no
	 * @param model
	 * @return
	 */
	public boolean checkLoginCredentials(EngineerLoginDetailsDTO login) {
		query = "select accountUserName, accountUserPassword from  engineers_details where accountUserName = ?, accountUserPassword = ?;";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				status = true;
			}
		}catch(SQLException sqe) {
			logger.error(sqe);
		}
		return status;
	}
	
	/**
	 * Method to change the user login password
	 * @param login
	 * @return
	 */
	public boolean resetPasswordModule(EngineerLoginDetailsDTO login) {
		query = "UPDATE engineers_details set accountUserPassword = ? where accountUserName = ?;";
		if(checkLoginCredentials(login))
			return status;
		logger.info("Setting up new Password");
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			if(preparedStatement.executeUpdate() != 0)
				status = true;
		}catch(SQLException sqe) {
			logger.error(sqe);
		}
		logger.info("Successfully changed password");
		return status;
	}
}
