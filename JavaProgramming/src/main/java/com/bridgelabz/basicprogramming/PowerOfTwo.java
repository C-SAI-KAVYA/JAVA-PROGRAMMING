package com.bridgelabz.basicprogramming;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.CannotCalculateZeroPowerException;

public class PowerOfTwo {

	public static void main(String[] args) {
		/**
		 * Creating and initializing logger
		 */
		LogsUtility.setLog("PowerOfTwo");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"PowerOfTwo.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);

		logger.info("Enter any random integer till where you want to find the powers of two");
		int tillPower = InputUtility.intVal();
		logger.info("Enter any random integer whose powers you want to find");
		int numberPower = InputUtility.intVal();

		double[] powersOfTwo = new double[Math.abs(tillPower)];
		try {
			powersOfTwo = Utility.powerOfTwo(tillPower, numberPower);
		} catch (CannotCalculateZeroPowerException e) {
			logger.info(e);
		}
		if (tillPower < 0) {
			for (int i = 0; i < Math.abs(tillPower); i++)
				logger.info(numberPower + " to the power " + i + " is equal to " + powersOfTwo[i]);
		} else {
			for (int i = 0; i < tillPower; i++)
				logger.info(numberPower + " to the power " + i + " is equal to " + powersOfTwo[i]);
		}
}

}
