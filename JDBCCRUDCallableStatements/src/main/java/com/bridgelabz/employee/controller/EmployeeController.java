package com.bridgelabz.employee.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.employee.serviceprovider.EmployeeServiceProviderImpl;
import com.bridgelabz.employee.utils.InputUtility;
import com.bridgelabz.employee.utils.LogsUtility;

public class EmployeeController {
	public static void main(String[] args) {
		EmployeeServiceProviderImpl impl = EmployeeServiceProviderImpl.getInstance();
		LogsUtility.setLog("employeeController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"employeeController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		int choice;
		do{
			logger.info("Enter What you would like to do : ");
			logger.info("\n1. Insert New Employee Details\n2. Read Employee Details Based On ID\n3. Update Employee Details Based On ID\n4. Delete Employee Details Based On ID\n5. exit");
			choice = InputUtility.intVal();
			switch(choice) {
				case 1:
					impl.insertEmployeeDetails();
					break;
				case 2:
					impl.readEmployeeDetailsOnID();
					break;
				case 3:
					impl.updateEmployeeDetailsOnID();
					break;
				case 4:
					impl.deleteEmployeeDetailsOnID();
					break;
				case 5:
					logger.info("Successfully Exited.................................");
					break;
				default:
					logger.info("Invalid Option Selected................................");
			}
		}while(choice != 5) 
	}
}
