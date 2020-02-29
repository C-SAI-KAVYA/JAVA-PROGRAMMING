package com.bridgelabz.basicprogramming;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.basicprogramming.utils.Utility;

public class HarmonicNumber {
	
	public static void main(String[] args) {
		LogsUtility.setLog("HarmonicNumber");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"HarmonicNumber.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to Harmonic Number Calculator");
		
		logger.info("Enter and random integer till where you want to find the Nth harmonic value");
		int nthNumber = InputUtility.intVal();
		
		double nthHarmonicValue = Utility.harmonicNumber(nthNumber);
		
		logger.info("The nth harmonic value is "+ nthHarmonicValue);
}

}
