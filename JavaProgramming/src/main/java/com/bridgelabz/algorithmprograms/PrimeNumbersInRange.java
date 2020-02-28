package com.bridgelabz.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.OutputUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;
import com.bridgelabz.functionalprograms.utils.InputUtility;

public class PrimeNumbersInRange {
	public static void main(String[] args) {
		LogsUtility.setLog("PrimeNumbersInRange");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "PrimeNumbersInRange.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("lower limit is zero by default enter the upper limit till where you want the prime numbers to be printed ");
		int limit = InputUtility.intVal();
		
		try {
			int [] primeNumbers = Utility.primeNumbersRange(limit);
			logger.info("the prime numbers from 0 to "+limit+" are as follows");
			OutputUtility.print1DIntArray(primeNumbers);
		} catch (PrimeFactorsCannotBeFoundForZeroAndOneException e) {
			logger.error(e);
		}
	}
}
