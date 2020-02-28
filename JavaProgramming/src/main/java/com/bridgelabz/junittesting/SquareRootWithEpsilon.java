package com.bridgelabz.junittesting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.junittesting.utils.InputUtility;
import com.bridgelabz.junittesting.utils.Utility;

public class SquareRootWithEpsilon {
	public static void main(String[] args) throws Exception {
		LogsUtility.setLog("SquareRootWithEpsilon");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"SquareRootWithEpsilon.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		try {
			logger.info("enter no to find square root");
			double c =InputUtility.doubleVal();
			logger.info("square root is " + Utility.sqrt(c));
		} catch (NegativeOrZeroNumberFoundException e) {
			logger.error(e);
		}

	}
}
