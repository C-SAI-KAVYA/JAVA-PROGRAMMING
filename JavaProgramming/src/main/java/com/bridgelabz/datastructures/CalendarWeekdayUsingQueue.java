package com.bridgelabz.datastructure;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.Utility;

public class CalendarWeekdayUsingQueue {

	public static void main(String[] args) {
		// setting up the logger
		LogsUtility.setLog("CalendarWeekdayUsingQueue");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "CalendarWeekdayUsingQueue.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		int year=0; 
		System.out.println("enter month");
		int month=InputUtility.intVal();
		try {
		if (month > 0 && month <= 12) {
			System.out.println("Enter year");
			year =  InputUtility.intVal();
			if (year > 1582 && year < 9999) {
				Utility.printQueueCalendar(month, year);
			}
			
		}
		}catch(NumberFormatException e) {
			logger.error(e);
		}
	}
}
