package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.Utility;
import com.bridgelabz.exceptions.IncorrectStringFormatException;

public class BalancedParenthesis {

	public static void main(String[] args) {
		// setting up the logger
		LogsUtility.setLog("OrderedList");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "OrderedList.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);

		// reading the expression
		logger.info("Balanced Parenthesis");
		logger.info("Enter the expression");
		String expression = InputUtility.stringVal();

		// modifying the expression
		try {
			boolean check = Utility.areParenthesisBalanced(expression);
			if (check)
				logger.info("Balanced parenthesis");
			else
				logger.info("Not Balanced parenthesis");
		} catch (IncorrectStringFormatException isfe) {
			logger.error(isfe);

		}
	}
}
