package com.bridgelabz.junittesting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.InvalidDateEnteredException;
import com.bridgelabz.junittesting.utils.InputUtility;
import com.bridgelabz.junittesting.utils.Utility;

public class DayOfWeek {

	 /**
	  * main function to test the class
	  * @throws InvalidDateEnteredException 
	  */
		public static void main(String[] args) throws InvalidDateEnteredException {
			LogsUtility.setLog("DayOfWeek");
			Logger logger = LogsUtility.getLog();
			System.setProperty("fname", LogsUtility.FILEPATH+"DayOfWeek.log");
			PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
			
			int d, m, y;
			logger.info("enter date in day month year");
			d = InputUtility.intVal();
			m = InputUtility.intVal();
			y = InputUtility.intVal();
			
			
			try {
				int d0 = Utility.dayOfWeek(d, m, y);
				logger.info("day is ");
				switch (d0) {

				case 0:
					logger.info("sunday");
					break;

				case 1:
					logger.info("monday");
					break;

				case 2:
					logger.info("tuesday");
					break;

				case 3:
					logger.info("wednesday");
					break;

				case 4:
					logger.info("Thursday");
					break;

				case 5:
					logger.info("friday");
					break;

				case 6:
					logger.info("saturday");
					break;
				default:
					throw new InvalidDateEnteredException("Enter valid date");
				}
			} catch (InvalidDateEnteredException e) {
				logger.error(e);
			}
		
		}
}
