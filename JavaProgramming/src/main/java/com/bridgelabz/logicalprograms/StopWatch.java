package com.bridgelabz.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.exceptions.InvalidIntegerException;
import com.bridgelabz.exceptions.NumberNotInRequiredFormatOrSizeException;
import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.logicalprograms.utils.LogsUtility;
import com.bridgelabz.logicalprograms.utils.Utility;

public class StopWatch {
	public static void main(String[] args) throws NumberNotInRequiredFormatOrSizeException {
		LogsUtility.setLog("StopWatch");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"StopWatch.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcomt to StopWatch Calculator");
		
		logger.info("Enter any value where you want to end the timer");
		int end = InputUtility.intVal();
		try {
			logger.info("The elapsed time is "+Utility.stopWatch(end));
		} catch (InvalidIntegerException e) {
			e.printStackTrace();
		}
		

	}

}
