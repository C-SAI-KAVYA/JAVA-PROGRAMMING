package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.bridgelabz.datastructures.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.Utility;

public class PalindromeChecker {

	public static void main(String[] args) {
		
		// setting up the logger
		LogsUtility.setLog("PalindromeChecker");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "PalindromeChecker.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Palindrome checker");
		logger.info("Enter any string to check whether it is palindrome or not");
		String userInput = InputUtility.stringVal();
		
		boolean check = Utility.palindromeChecker(userInput);
		if(check) 
			logger.info("palindrome");
		else
			logger.info("Not palindrome");
	}
}
