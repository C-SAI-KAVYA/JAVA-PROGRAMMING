package com.bridgelabz.employee.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class Configuration {
	private static Logger logger = Logger.getLogger(EmployeeConfiguration.class);
	private final String filePath = "F:\\BridgeLabzFellowship\\JDBCCRUDCallableStatements\\resources\\Configuration.properties";
	private static Properties properties = new Properties();
	private static Connection connection;
	private static Configuration configuration;
	
	//Constructor to load the properties file
	private Configuration() {
		try(FileInputStream fips = new FileInputStream(new File(filePath));){
			properties.load(fips);
		}catch(FileNotFoundException fnfe) {
			logger.error(fnfe);
		}catch(IOException ex) {
			logger.error(ex);
		}
	}
	
	//returns the loaded properties object 
	public Properties getConfiguredPropertyObject() {
		return properties;
	}
	
	//method to connect to the database with valid user name and password and database name
	public Connection connectToDatabaseWithDatabaseName() {
		try {
			logger.info(properties.getProperty("DRIVERNAME"));
			Class.forName(properties.getProperty("DRIVERNAME"));
			logger.info(properties.getProperty("URL")+properties.getProperty("USERNAME")+properties.getProperty("PASSWORD"));
			connection = DriverManager.getConnection(properties.getProperty("URL")+"/"+properties.getProperty("DATABASENAME"),properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
			logger.info("Successfully Connected to MySQL Database");
			return connection;
		} catch (SQLException |ClassNotFoundException e) {
			logger.error(e);
			return connection;
		}
		
	}
	
	//method to connect to the database with valid user name and password
		public Connection connectToDatabase() {
			try {
				logger.info(properties.getProperty("DRIVERNAME"));
				Class.forName(properties.getProperty("DRIVERNAME"));
				logger.info(properties.getProperty("URL")+properties.getProperty("USERNAME")+properties.getProperty("PASSWORD"));
				connection = DriverManager.getConnection(properties.getProperty("URL"),properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
				logger.info("Successfully Connected to MySQL Database");
				return connection;
			} catch (SQLException |ClassNotFoundException e) {
				logger.error(e);
				return connection;
			}
			
		}
	
	//SingleTon Lazy Initialization usage to create an configuration object 
	public static Configuration getConfigurationInstance() {
		if(configuration == null) {
		configuration = new Configuration();
		}
		return configuration;
	}
}
