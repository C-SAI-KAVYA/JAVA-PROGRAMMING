package com.bridgelabz.functionalprograms.utils;


import org.apache.log4j.Logger;

public class OutputUtility {
	
	private OutputUtility() {	
	}
	//print primitive data types
	/**
	 * functions are written to print all types of primitive data types on to screen
	 * @param line
	 */
	private static Logger logger = Logger.getLogger(OutputUtility.class);
	
	public static void printLine(String line) {
		logger.info(line);
	}
	public static void printCharVal(char ch) {
		logger.info(ch);
	}
	public static void printStringVal(String str) {
		logger.info(str);
	}
	public static void printIntVal(int n) {
		logger.info(n);
	}
	public static void printShortVal(short shrt) {
		logger.info(shrt);
	}
	public static void printLongVal(long lng) {
		logger.info(lng);
	}
	public static void printFloatVal(float flt) {
		logger.info(flt);
	}
	public static void printDoubleVal(double dble ) {
		logger.info(dble);
	}
	public static void printByteVal(byte by) {
		logger.info(by);
	}
	
	//1D array printing of all primitive data types
	/**
	 * prints 1D array of type byte
	 */
	public static<E> void print1DByteArray(E[] inputArray) {
		for(E index : inputArray)
			logger.info(index);
	}
	/**
	 * prints 1D array of type short
	 */
	public static void print1DShortArray(short[] shortArray) {
		for(int index : shortArray)
			logger.info(index);
	}
	/**
	 * prints 1D array of type int
	 */
	public static void print1DIntArray(int[] intArray) {
		for(int index : intArray)
			logger.info(index);
	}
	/**
	 * prints 1D array of type long
	 */
	public static void print1DLongArray(long[] longArray) {
		for(long index : longArray)
			logger.info(index);
	}
	/**
	 * prints 1D array of type float
	 */
	public static void print1DFloatArray(float[] floatArray) {
		for(float index : floatArray)
			logger.info(index);
	}
	/**
	 * prints 1D array of type double
	 */
	public static void print1DDoubleArray(double[] doubleArray) {
		for(double index : doubleArray)
			logger.info(index);
	}
	/**
	 * prints 1D array of type char
	 */
	public static void print1DCharArray(char[] charArray) {
		for(char index : charArray)
			logger.info(index);
	}
	/**
	 * prints 1D array of type String
	 */
	public static void print1DStringArray(String[] stringArray) {
		for(String index : stringArray)
			logger.info(index);
	}
	
	//printing 2D Array of
	 public static void print2DByteArray(byte[][] byteArray) {
		 int rows = byteArray[0].length;
		 int columns = byteArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(byteArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 }	 
	 }
	 public static void print2DIntArray(int[][] intArray) {
		 int rows = intArray[0].length;
		 int columns = intArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(intArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 }		 
	 }
	 public static void print2DShortArray(short[][] shortArray) {
		 int rows = shortArray[0].length;
		 int columns = shortArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(shortArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 }		 
	 }
	 public static void print2DLongArray(long[][] longArray) {
		 int rows = longArray[0].length;
		 int columns = longArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(longArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 } 
	 }
	 public static void print2DFloatArray(float[][] floatArray) {
		 int rows = floatArray[0].length;
		 int columns = floatArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(floatArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 }		 
	 }
	 public static void print2DDoubleArray(double[][] doubleArray) {
		 int rows = doubleArray[0].length;
		 int columns = doubleArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(doubleArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 }	 
	 }
	 public static void print2DCharArray(char[][] charArray) {
		 int rows = charArray[0].length;
		 int columns = charArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(charArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 }
	 }
	 public static void print2DStringArray(String[][] stringArray) {
		 int rows = stringArray[0].length;
		 int columns = stringArray[1].length;
		 
		 for(int index = 0; index < rows; index++) {
			 for(int jIndex = 0; jIndex < columns; jIndex++) {
				 System.out.print(stringArray[index][jIndex]+"\t");
			 }
			 System.out.println();
		 }	 
	 }
	
}
