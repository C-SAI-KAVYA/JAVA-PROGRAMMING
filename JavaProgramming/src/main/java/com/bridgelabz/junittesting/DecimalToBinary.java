package com.bridgelabz.junittesting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.junittesting.utils.InputUtility;
import com.bridgelabz.junittesting.utils.Utility;

public class DecimalToBinary {
	/**
	 * main function/method to test Binary class
	 *
	 * @param int array to swap nibbles in array
	 * @return return swapped array
	 */
	public static void main(String[] args) {
		LogsUtility.setLog("DecimalToBinary");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"DecimalToBinary.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		try {
			logger.info("enter a no");
			int[] binary = Utility.toBinary(InputUtility.intVal());
			logger.info("binary is ");
			Utility.showArr(binary);
		} catch (NegativeOrZeroNumberFoundException e) {
			logger.info(e);
		}
	}
}
