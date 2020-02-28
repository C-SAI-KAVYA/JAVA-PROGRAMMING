package com.bridgelabz.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.logicalprograms.utils.LogsUtility;
import com.bridgelabz.logicalprograms.utils.Utility;

public class DistinctCouponNumber {

	public static void main(String[] args) {
		LogsUtility.setLog("DistinctCouponNumber");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"DistinctCouponNumber.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to Distinct Coupon Numbers Generator");
		
		logger.info("Enter any random number to generate that many distinct coupon numbers");
		int randomNumberByUser = InputUtility.intVal();
		logger.info("the number of times the random called is "+Utility.distinctCouponNumbers(randomNumberByUser));
		
	}

}
