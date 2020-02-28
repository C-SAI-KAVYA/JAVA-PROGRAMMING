package com.bridgelabz.datastructure;

import com.bridgelabz.datastructures.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.OutputUtility;

public class Prime2DArray {

	public static void main(String[] args) {
		LogsUtility.setLog("Primes2DArray");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "Primes2DArray.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		logger.info("0-1000 prime numbers in 2D array");
		try {	
			int[][] primes2D = Utility.prime1Dto2D(1000);
			OutputUtility.print2DIntArray(primes2D);
		} catch (PrimeFactorsCannotBeFoundForZeroAndOneException e) {
			logger.error(e);
		}

	}

}
