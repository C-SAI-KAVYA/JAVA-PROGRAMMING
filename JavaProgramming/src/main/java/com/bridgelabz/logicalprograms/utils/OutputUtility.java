package com.bridgelabz.logicalprograms.utils;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

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
			OutputUtility.print(index+" ");
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
	// stdout
				// force Unicode UTF-8 encoding; otherwise it's system dependent
				private static final String CHARSET_NAME_out = "UTF-8";

				// assume language = English, country = US for consistency with StdIn
				private static final Locale LOCALE_out = Locale.US;

				// send output here
				private static PrintWriter out;

				// this is called before invoking any methods
				static {
					try {
						out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME_out), true);
					} catch (UnsupportedEncodingException e) {
						System.out.println(e);
					}
				}

				/**
				 * Terminates the current line by printing the line-separator string.
				 */
				public static void println() {
					out.println();
				}

				/**
				 * Prints an object to this output stream and then terminates the line.
				 *
				 * @param x the object to print
				 */
				public static void println(Object x) {
					out.println(x);
				}

				/**
				 * Prints a boolean to standard output and then terminates the line.
				 *
				 * @param x the boolean to print
				 */
				public static void println(boolean x) {
					out.println(x);
				}

				/**
				 * Prints a character to standard output and then terminates the line.
				 *
				 * @param x the character to print
				 */
				public static void println(char x) {
					out.println(x);
				}

				/**
				 * Prints a double to standard output and then terminates the line.
				 *
				 * @param x the double to print
				 */
				public static void println(double x) {
					out.println(x);
				}

				/**
				 * Prints an integer to standard output and then terminates the line.
				 *
				 * @param x the integer to print
				 */
				public static void println(float x) {
					out.println(x);
				}

				/**
				 * Prints an integer to standard output and then terminates the line.
				 *
				 * @param x the integer to print
				 */
				public static void println(int x) {
					out.println(x);
				}

				/**
				 * Prints a long to standard output and then terminates the line.
				 *
				 * @param x the long to print
				 */
				public static void println(long x) {
					out.println(x);
				}

				/**
				 * Prints a short integer to standard output and then terminates the line.
				 *
				 * @param x the short to print
				 */
				public static void println(short x) {
					out.println(x);
				}

				/**
				 * Prints a byte to standard output and then terminates the line.
				 * <p>
				 * To write binary data, see {@link BinaryStdOut}.
				 *
				 * @param x the byte to print
				 */
				public static void println(byte x) {
					out.println(x);
				}

				/**
				 * Flushes standard output.
				 */
				public static void print() {
					out.flush();
				}

				/**
				 * Prints an object to standard output and flushes standard output.
				 * 
				 * @param x the object to print
				 */
				public static void print(Object x) {
					out.print(x);
					out.flush();
				}

				/**
				 * Prints a boolean to standard output and flushes standard output.
				 * 
				 * @param x the boolean to print
				 */
				public static void print(boolean x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints a character to standard output and flushes standard output.
				 * 
				 * @param x the character to print
				 */
				public static void print(char x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints a double to standard output and flushes standard output.
				 * 
				 * @param x the double to print
				 */
				public static void print(double x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints a float to standard output and flushes standard output.
				 * 
				 * @param x the float to print
				 */
				public static void print(float x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints an integer to standard output and flushes standard output.
				 * 
				 * @param x the integer to print
				 */
				public static void print(int x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints a long integer to standard output and flushes standard output.
				 * 
				 * @param x the long integer to print
				 */
				public static void print(long x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints a short integer to standard output and flushes standard output.
				 * 
				 * @param x the short integer to print
				 */
				public static void print(short x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints a byte to standard output and flushes standard output.
				 *
				 * @param x the byte to print
				 */
				public static void print(byte x) {
					out.print(x);
					out.flush();
				}
				/**
				 * Prints a formatted string to standard output, using the specified format
				 * string and arguments, and then flushes standard output.
				 *
				 *
				 * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format
				 *               string</a>
				 * @param args   the arguments accompanying the format string
				 */
				public static void printf(String format, Object... args) {
					out.printf(LOCALE_out, format, args);
					out.flush();
				}
				/**
				 * Prints a formatted string to standard output, using the locale and the
				 * specified format string and arguments; then flushes standard output.
				 *
				 * @param locale the locale
				 * @param format the <a href =
				 *               "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format
				 *               string</a>
				 * @param args   the arguments accompanying the format string
				 */
				public static void printf(Locale locale, String format, Object... args) {
					out.printf(locale, format, args);
					out.flush();
				}
}
