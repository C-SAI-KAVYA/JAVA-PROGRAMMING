package com.bridgelabz.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.UnsupportedValuesForEuclideanDistanceCalculationException;
import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.functionalprograms.utils.Utility;

public class EuclideanDistance {

	public static void main(String[] args) {
		LogsUtility.setLog("EuclideanDistance");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"EuclideanDistance.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to Euclidean Distance Calculator");
		
		logger.info("There are two points x2 and y2 enter the values in which position you want to place them");
		int x2 = InputUtility.intVal();
		int y2 = InputUtility.intVal();
		double euclideanDistance = 0.0;
		try {
		euclideanDistance = Utility.euclideanDistance(x2, y2);
		}catch(UnsupportedValuesForEuclideanDistanceCalculationException e) {
			logger.info(e);
		}
		
		logger.info("The Euclidean Distance between the two points you entered is "+euclideanDistance);
		
		logger.info("Thank you for using Euclidean Distance Calculator");
		
	}
}
