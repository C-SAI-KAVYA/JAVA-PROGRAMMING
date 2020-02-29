package com.bridgelabz.basicprogramming;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.exceptions.NumberNotInRequiredFormatOrSizeException;

public class LeapYear {
	public static void main(String[] args) {
		/**
		 * Creating and initializing logger
		 */
		LogsUtility.setLog("LeapYear");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"LeapYear.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Enter and random year to check whether its leap year or not");
		int year = InputUtility.intVal();
		
		try {
			if (Utility.isLeapYear(year))
				logger.info(year+"  is a leap year");
			else
				logger.info(year+"  is not a leap year");
		} catch (NumberNotInRequiredFormatOrSizeException | LessThanOrGreaterThanSpecifiedRangeException e) {
			logger.info(e);
		}
}

}
