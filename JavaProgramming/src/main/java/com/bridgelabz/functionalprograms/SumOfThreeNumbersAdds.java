package com.bridgelabz.functionalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.errors.UnspecifiedOptionSelectedError;
import com.bridgelabz.exceptions.ArraySizeDoesNotSatisfyRequiredLengthException;
import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.functionalprograms.utils.Utility;

public class SumOfThreeNumbersAdds {

	public static void main(String[] args) {
		LogsUtility.setLog("SumOfThreeNumbersAdds");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"SumOfThreeNumbersAdds.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to SumOfThreeNumbersAddsToZero Calculator");
		
		logger.info("enter the length of the array");
		int length = InputUtility.intVal();
		
		logger.info("choose from the following triplets of which data type you want to find");
		logger.info("byte");
		logger.info("short");
		logger.info("int");
		logger.info("long");
		logger.info("float");
		logger.info("double");
		logger.info("char");
		String userChoice = InputUtility.stringVal();
		
		switch(userChoice) {
			case "byte":
				logger.info("Enter the array elements of type byte");
				byte[] tripletsByteArray = InputUtility.readByte1DArray(length);
				try {
					logger.info("The number of triplets present in the byte array are "+Utility.findTriplets(tripletsByteArray));
				} catch (ArraySizeDoesNotSatisfyRequiredLengthException e) {
					logger.fatal(e);
				}
				break;
			case "short":
				logger.info("Enter the array elements of type short");
				short[] tripletsShortArray = InputUtility.readShort1DArray(length);
				try {
					logger.info("The number of triplets present in the short array are "+Utility.findTriplets(tripletsShortArray));
				} catch (ArraySizeDoesNotSatisfyRequiredLengthException e) {
					logger.fatal(e);
				}
				break;
			case "int":
				logger.info("Enter the array elements of type int");
				int[] tripletsIntArray = InputUtility.readInt1DArray(length);
				try {
					logger.info("The number of triplets present in the int array are "+Utility.findTriplets(tripletsIntArray));
				} catch (ArraySizeDoesNotSatisfyRequiredLengthException e) {
					logger.fatal(e);
				}
				break;
			case "long":
				logger.info("Enter the array elements of type long");
				long[] tripletsLongArray = InputUtility.readLong1DArray(length);
				try {
					logger.info("The number of triplets present in the long array are "+Utility.findTriplets(tripletsLongArray));
				} catch (ArraySizeDoesNotSatisfyRequiredLengthException e) {
					logger.fatal(e);
				}
				break;
			case "float":
				logger.info("Enter the array elements of type float");
				long[] tripletsFloatArray = InputUtility.readLong1DArray(length);
				try {
					logger.info("The number of triplets present in the float array are "+Utility.findTriplets(tripletsFloatArray));
				} catch (ArraySizeDoesNotSatisfyRequiredLengthException e) {
					logger.fatal(e);
				}
				break;
			case "double":
				logger.info("Enter the array elements of type double");
				double[] tripletsDoubleArray = InputUtility.readDouble1DArray(length);
				try {
					logger.info("The number of triplets present in the double array are "+Utility.findTriplets(tripletsDoubleArray));
				} catch (ArraySizeDoesNotSatisfyRequiredLengthException e) {
					logger.fatal(e);
				}
				break;
			default:
				throw new UnspecifiedOptionSelectedError("Selected Option is not presnt in the list");
		}
		logger.info("Thank you for using SumOfThreeNumbersAddsToZero calculator");
	}

}
