package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.Utility;
import com.bridgelabz.exceptions.InvalidDateEnteredException;

public class Calendar {

	public static void main(String[] args) {
		// setting up the logger
		LogsUtility.setLog("Calendar");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "Calendar.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Printing calendar by accepting the month and year");
		try {
			logger.info("Enter the month");
			int month = InputUtility.intVal();
			logger.info("Enter year");
			int year = InputUtility.intVal();
			Utility.printCalendar(month, year);
		} catch (InvalidDateEnteredException e) {
			e.printStackTrace();
		}

	}

}
