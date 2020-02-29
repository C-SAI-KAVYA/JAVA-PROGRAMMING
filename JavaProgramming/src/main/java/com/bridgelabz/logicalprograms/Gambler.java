package com.bridgelabz.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.logicalprograms.utils.LogsUtility;
import com.bridgelabz.logicalprograms.utils.OutputUtility;
import com.bridgelabz.logicalprograms.utils.Utility;

public class Gambler {
	public static void main(String[] args) {
		LogsUtility.setLog("Gambler");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"Gambler.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to Gambling Game");
		
		logger.info("Enter the begining stake");
		int stake = InputUtility.intVal();
		logger.info("Enter you goal to be a millionare!");
		int goal = InputUtility.intVal();
		
		double[] winsAndLossesPercentage = Utility.gambler(stake, goal);
		
		logger.info("wins");
		logger.info("wins percentage");
		logger.info("loss percentages are as follows");
		
		OutputUtility.print1DDoubleArray(winsAndLossesPercentage);
	}
}
