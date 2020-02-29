package com.bridgelabz.basicprogramming;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;

public class FlipCoin {

	public static void main(String[] args) {
		LogsUtility.setLog("FlipCoin");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"FlipCoin.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);

		logger.info("Enter Number of times you would like to flip a coin");
		int timesToFlipCoin = InputUtility.intVal();

		double[] headsTailsPercentage = new double[2];
		try {
			headsTailsPercentage = Utility.flipCoin(timesToFlipCoin);
		} catch (NegativeOrZeroNumberFoundException e) {
			logger.info(e);
		}

		logger.debug("The heads percentage is " + headsTailsPercentage[0]);
		logger.debug("The Tails percentage is " + headsTailsPercentage[1]);
}

}
