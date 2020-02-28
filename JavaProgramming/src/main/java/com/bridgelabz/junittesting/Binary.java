package com.bridgelabz.junittesting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.junittesting.utils.InputUtility;
import com.bridgelabz.junittesting.utils.Utility;

public class Binary {

	public static void main(String[] args) {
		LogsUtility.setLog("Binary");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"Binary.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		try {
			logger.info("enter any random decimal number to see its binary representation");
			int[] binary = Utility.toBinary(InputUtility.intVal());
			logger.info("binary is ");
			Utility.showArr(binary);
			int[] swappedBinaryArray = Utility.swapNibbles(binary);
			logger.info("after swapping ");
			Utility.showArr(swappedBinaryArray);
			int swappedDecimal = Utility.toDecimal(swappedBinaryArray);
			logger.info("decimal of swapped binary is " + swappedDecimal);
			if (Utility.powerOf2(swappedDecimal))
				logger.info("its power of 2");
			else
				logger.info("not power of 2");

		} catch (NegativeOrZeroNumberFoundException e) {
			logger.info(e);
		}
	}
}
