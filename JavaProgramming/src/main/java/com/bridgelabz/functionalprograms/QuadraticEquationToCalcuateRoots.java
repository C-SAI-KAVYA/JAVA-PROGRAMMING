package com.bridgelabz.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.functionalprograms.utils.Utility;


public class QuadraticEquationToCalcuateRoots {
	
	public static void main(String[] args) {
		LogsUtility.setLog("QuadraticEquationToCalculateRoots");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"QuadraticEquationToCalculateRoots.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to Quadratic Equations Calculator");
		
		logger.info("Enter the values of the a b c constants to calculate the roots");
		int a = InputUtility.intVal();
		int b = InputUtility.intVal();
		int c = InputUtility.intVal();
		double[] roots = Utility.quadraticRootsCalculator(a, b, c);
		
		logger.info("root 1 is "+roots[0]);
		logger.info("root 2 is "+roots[1]);
		
		logger.info("Thank you for using Quadratic roots calculator");
	}
}
