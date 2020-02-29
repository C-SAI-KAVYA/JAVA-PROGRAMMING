package com.bridgelabz.junittesting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.junittesting.utils.InputUtility;
import com.bridgelabz.junittesting.utils.Utility;

public class MonthlyPayment {
	public static void main(String[] args) {
		LogsUtility.setLog("MonthlyPayment");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"MonthlyPayment.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		logger.info("enter principal ,year and rate");
		double p = InputUtility.doubleVal();
		int y = InputUtility.intVal();
		double r = InputUtility.doubleVal();
		try {
			logger.info("mothly payment is " + Utility.monthlyPayment(p, y, r));
		} catch (LessThanOrGreaterThanSpecifiedRangeException e) {
			logger.error(e);
		}
	}
}
