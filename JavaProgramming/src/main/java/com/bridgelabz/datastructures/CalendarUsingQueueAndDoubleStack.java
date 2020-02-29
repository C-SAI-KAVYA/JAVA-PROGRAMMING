package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.OutputUtility;
import com.bridgelabz.datastructures.utils.Utility;

public class CalendarUsingQueueAndDoubleStack {

	public static void main(String[] args) {
		// setting up the logger
		LogsUtility.setLog("CalendarUsingQueueAndDoubleStack");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "CalendarWeekdayUsingQueue.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);

		logger.info("Calender using queue and double stack");

		logger.info("Enter input");
		int year;
		int month;
		int days;
		int day;
		int[] daysPerYear = { 31, 28, 30, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		OutputUtility.println("Enter month");
		month = InputUtility.intVal();
		if (month > 0 && month <= 12) {
			OutputUtility.println("Enter year");
			year = InputUtility.intVal();
			if (year > 1582 && year < 9999) {
				if (Utility.isLeap(year)) {
					daysPerYear[1] = 29;
				}
				days = daysPerYear[month - 1];
				day = Utility.day(month, 1, year);
				Utility.printCalendarUsingQueueDoubleStack(day, days);

			} else
				OutputUtility.println("please enter valid year");
		} else
			OutputUtility.println("Please enter valid month");
	}
}
