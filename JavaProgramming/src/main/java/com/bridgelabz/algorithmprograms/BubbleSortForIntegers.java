package com.bridgelabz.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.OutputUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.ArrayLengthDoesNotSatisfyTheRequiredLengthException;

public class BubbleSortForIntegers {
	
	
	public static void main(String[] args) {
		
		
		LogsUtility.setLog("BubbleSortForIntegers");
		Logger logger = LogsUtility.getLog();	
		System.setProperty("fname", LogsUtility.FILEPATH+"BubbleSortForIntegers.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.warn("Can Cause InputMismatchException");
		logger.info("Enter input");
		
		
		try {
			logger.info("Enter number of words to be sorted: ");
			int arrayStringSize = InputUtility.intVal();
			logger.info("Enter the array elements");
			String stringWords[] = InputUtility.readString1DArray(arrayStringSize);
			OutputUtility.printArray(stringWords);
			Utility.genericBubbleSortA(stringWords); // sorting the array

			logger.info("");
			logger.info("The Sorted Order is: ");
			OutputUtility.printArray(stringWords); // printing the sorted array
			logger.info("-------------");
			
			
			logger.info("Enter numbers to be sorted: ");
			int arrayIntSize = InputUtility.intVal();
			Integer intWords[] = InputUtility.readInteger1DArray(arrayIntSize);
			Utility.genericBubbleSortA(intWords); // sorting the array
			OutputUtility.println();
			OutputUtility.println("The Sorted Order is: ");
			OutputUtility.print1DIntegerArray(intWords);
		} catch (ArrayLengthDoesNotSatisfyTheRequiredLengthException e) {
			logger.error(e);
		}
	}
}
