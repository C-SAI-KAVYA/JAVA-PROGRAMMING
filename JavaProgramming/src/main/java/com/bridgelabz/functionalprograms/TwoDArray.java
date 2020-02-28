package com.bridgelabz.functionalprograms;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.errors.UnspecifiedOptionSelectedError;
import com.bridgelabz.functionalprograms.utils.InputUtility;
import com.bridgelabz.functionalprograms.utils.OutputUtility;

public class TwoDArray {
	public static void main(String[] args) {
		LogsUtility.setLog("TwoDArray");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"TwoDArray.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);

		logger.info("Enter Number of rows and columns you want in your 2D array");
		int rows = InputUtility.intVal();
		int columns = InputUtility.intVal();

		logger.info(
				"Select from the following list which primitive data type would you like to choose for your 2D array");
		logger.info("byte");
		logger.info("short");
		logger.info("int");
		logger.info("long");
		logger.info("float");
		logger.info("double");
		logger.info("char");
		logger.info("String");

		String userChoice = InputUtility.stringVal();
		try {
			switch (userChoice) {

			case "byte":
				logger.info("Enter the byte 2D array elements");
				byte[][] byteArray = InputUtility.readByte2DArray(rows, columns);
				OutputUtility.print2DByteArray(byteArray);
				break;

			case "short":
				logger.info("Enter the short 2D array elements");
				short[][] shortArray = InputUtility.readShort2DArray(rows, columns);
				OutputUtility.print2DShortArray(shortArray);
				break;

			case "int":
				logger.info("Enter the int 2D array elements");
				int[][] intArray = InputUtility.readInt2DArray(rows, columns);
				OutputUtility.print2DIntArray(intArray);
				break;

			case "long":
				logger.info("Enter the long 2D array elements");
				long[][] longArray = InputUtility.readLong2DArray(rows, columns);
				OutputUtility.print2DLongArray(longArray);
				break;

			case "char":
				logger.info("Enter the char 2D array elements");
				char[][] charArray = InputUtility.readChar2DArray(rows, columns);
				OutputUtility.print2DCharArray(charArray);
				break;

			case "string":
				logger.info("Enter the string 2D array elements");
				String[][] stringArray = InputUtility.readString2DArray(rows, columns);
				OutputUtility.print2DStringArray(stringArray);
				break;

			case "float":
				logger.info("Enter the float 2D array elements");
				float[][] floatArray = InputUtility.readFloat2DArray(rows, columns);
				OutputUtility.print2DFloatArray(floatArray);
				break;

			case "double":
				logger.info("Enter the double 2D array elements");
				double[][] doubleArray = InputUtility.readDouble2DArray(rows, columns);
				OutputUtility.print2DDoubleArray(doubleArray);
				break;
			default:
				throw new UnspecifiedOptionSelectedError("given value is not present in the list");
			}
		} catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
			logger.fatal(e);
		}
	}
}
