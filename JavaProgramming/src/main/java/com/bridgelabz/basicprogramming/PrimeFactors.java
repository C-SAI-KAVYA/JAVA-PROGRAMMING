package com.bridgelabz.basicprogramming;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class PrimeFactors {
	public static void main(String[] args) {
		LogsUtility.setLog("PrimeFactors");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"PrimeFactors.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Enter any integer whose prime factors you want to find");
		int number = InputUtility.intVal();
		
		List<Integer> primeFactors = new ArrayList<>();
		
		try {
			logger.warn("Might throw PrimeFactorsCannotBeFoundZeroAndOneException");
			primeFactors = Utility.primeFactors(number);
		} catch (PrimeFactorsCannotBeFoundForZeroAndOneException e) {
			logger.info(e);
		}
		
		for(int i : primeFactors) {
			logger.info(i);
		}
}
}
