package com.bridgelabz.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.functionalprograms.utils.Utility;

public class WindChillTemperatureCalc {
	
	public static void main(String[] args) {
		LogsUtility.setLog("WindChillTemperatureCalc");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"WindChillTemparatureCalc.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to Wind Chill Temparature Calculator");
		logger.warn("The method will throw exception if you enter the value of t larger than 50 in absolute value");
		logger.warn("The method will also throw exception if you do not enter V(wind chill speed) larger than 120 or less than 3");
		
		logger.info("Keeping above warnings in mind enter valid values for temparature(t) and speed(v)");
		int t = InputUtility.intVal();
		int v = InputUtility.intVal();
		
		try {
			logger.info("Calculated Wind Chill temparature is "+Utility.windChillTemperatureCalculator(t, v));
		} catch (LessThanOrGreaterThanSpecifiedRangeException e) {
			logger.fatal(e);
		}
		
		logger.info("Thank you for using Wind Chill Temparature Calculator");
	}
}
