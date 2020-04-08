package com.bridgelabz.employeemanagement.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.employeemanagement.serviceprovider.EmployeeManagementServiceProviderImpl;
import com.bridgelabz.employeemanagement.utils.InputUtility;
import com.bridgelabz.employeemanagement.utils.LogsUtility;

public class EmployeeManagementController {
	public static void main(String[] args) {
		EmployeeManagementServiceProviderImpl impl = EmployeeManagementServiceProviderImpl.getInstance();
		LogsUtility.setLog("EmployeeManagementController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"EmployeeManagementController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		int choice;
		do{
			logger.info("Enter What you would like to do : ");
			logger.info("\n1. Create New Database \n2. Create New Table\n3. Insert New Employee Details\n4. Read Employee Details Based On ID\n5. Read Employee Details Table\n6. Update Employee Details Based On ID\n7. Delete Employee Details Based On ID\n8. Delete Table\n9. exit");
			choice = InputUtility.intVal();
			switch(choice) {
				case 1:
					impl.createDatabase();
					break;
				case 2:
					impl.createEmployeeDetailsTable();
					break;
				case 3:
					impl.insertEmployeeDetails();
					break;
				case 4:
					impl.readEmployeeDetailsOnID();
					break;
				case 5:
					impl.readEmployeeDetailsTable();
					break;
				case 6:
					impl.updateEmployeeDetailsOnID();
					break;
				case 7:
					impl.deleteEmployeeDetailsOnID();
					break;
				case 8:
					impl.deleteEmployeeDetailsTable();
					break;
				case 9:
					exit = true;
					logger.info("Successfully Exited.................................");
					break;
				default:
					logger.info("Invalid Option Selected................................");
			}
		}while(choice != 5) 
	}
}
