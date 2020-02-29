package com.bridgelabz.junittesting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.ChangeCannotBeCalculatedForZeroOrNegativeException;
import com.bridgelabz.junittesting.utils.InputUtility;
import com.bridgelabz.junittesting.utils.Utility;

public class VendingMachine {

	public static void main(String[] args) {
		LogsUtility.setLog("VendingMachine");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "VendingMachine.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		try {
			// ask the user enter the money
			logger.info("Enter the Amount:");
			int money = InputUtility.intVal();

			// Creating The Object of Vending Machine class
			int total = Utility.vendingMachine(money, Utility.notes);
			logger.info("Total Number of Notes are :" + total);
		} catch (ChangeCannotBeCalculatedForZeroOrNegativeException e) {
			logger.error(e);
		}
	}

}
