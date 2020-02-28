package com.bridgelabz.datastructures.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class InputUtility {
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

	private static final Pattern EMPTY_PATTERN = Pattern.compile("");
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

	private InputUtility() {
		throw new IllegalStateException("InputUtility class");
	}

	static Logger logger = Logger.getLogger("InputUtility");

	public static boolean isEmpty() {
		return !scanner.hasNext();
	}

	public static boolean hasNextLine() {
		return scanner.hasNextLine();
	}

	private static Scanner scanner = new Scanner(System.in);

	public static String readLine() {
		String line;
		try {
			line = scanner.nextLine();
		} catch (NoSuchElementException e) {
			line = null;
		}
		return line;
	}

	public static String readAll() {
		if (!scanner.hasNextLine())
			return "";

		String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
		// not that important to reset delimeter, since now scanner is empty
		scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
		return result;
	}

	public static byte byteVal() {
		try {
			return scanner.nextByte();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read a 'byte' value from standard input, "
					+ "but the next byte token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'byte' value from standard input, " + "but no more byte tokens are available");
		}
	}

	public static short shortVal() {
		try {
			return scanner.nextShort();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read a 'short' value from standard input, "
					+ "but the next short token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("attempts to read a 'short' value from standard input, "
					+ "but no more short tokens are available");
		}
	}

	public static int intVal() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read an 'int' value from standard input, "
					+ "but the next int token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attemps to read an 'int' value from standard input, " + "but no more int tokens are available");
		}

	}

	public static long longVal() {
		try {
			return scanner.nextLong();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read a 'long' value from standard input, "
					+ "but the next long token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'long' value from standard input, " + "but no more long tokens are available");
		}
	}

	public static float floatVal() {
		try {
			return scanner.nextFloat();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read a 'float' value from standard input, "
					+ "but the next token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("attempts to read a 'float' value from standard input, "
					+ "but there no more tokens are available");
		}
	}

	public static double doubleVal() {
		try {
			return scanner.nextDouble();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read a 'double' value from standard input, "
					+ "but the next token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'double' value from standard input, " + "but no more tokens are available");
		}
	}

	public static char charVal() {
		try {
			scanner.useDelimiter(EMPTY_PATTERN);
			String ch = scanner.next();
			assert ch.length() == 1 : "Internal (Std)In.readChar() error!" + " Please contact the authors.";
			scanner.useDelimiter(WHITESPACE_PATTERN);
			return ch.charAt(0);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'char' value from standard input, " + "but no more tokens are available");
		}
	}

	public static boolean booleanVal() {
		try {
			String token = stringVal();
			if ("true".equalsIgnoreCase(token))
				return true;
			if ("false".equalsIgnoreCase(token))
				return false;
			if ("1".equals(token))
				return true;
			if ("0".equals(token))
				return false;
			throw new InputMismatchException("attempts to read a 'boolean' value from standard input, "
					+ "but the next token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'boolean' value from standard input, " + "but no more tokens are available");
		}

	}

	public static String stringVal() {
		try {
			return scanner.next();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'String' value from standard input, " + "but no more tokens are available");
		}
	}

	public static String[] allStringVals() {
		// we could use readAll.trim().split(), but that's not consistent
		// because trim() uses characters 0x00..0x20 as whitespace
		String[] tokens = WHITESPACE_PATTERN.split(readAll());
		if (tokens.length == 0 || tokens[0].length() > 0)
			return tokens;

		// don't include first token if it is leading whitespace
		String[] decapitokens = new String[tokens.length - 1];
		for (int i = 0; i < tokens.length - 1; i++)
			decapitokens[i] = tokens[i + 1];
		return decapitokens;
	}

	public static String[] allLines() {
		ArrayList<String> lines = new ArrayList<String>();
		while (hasNextLine()) {
			lines.add(readLine());
		}
		return lines.toArray(new String[lines.size()]);
	}

	// stdin
	/*** begin: section (1 of 2) of code duplicated from In to StdIn. */

	// assume Unicode UTF-8 encoding
	private static final String CHARSET_NAME = "UTF-8";

	// assume language = English, country = US for consistency with System.out.
	private static final Locale LOCALE = Locale.US;

	/*** end: section (1 of 2) of code duplicated from In to StdIn. */
	/**
	 * Returns true if standard input has more input (including whitespace). Use
	 * this method to know whether the next call to {@link #readChar()} will
	 * succeed. This method is functionally equivalent to {@link #hasNextLine()}.
	 *
	 * @return {@code true} if standard input has more input (including whitespace);
	 *         {@code false} otherwise
	 */
	public static boolean hasNextChar() {
		scanner.useDelimiter(EMPTY_PATTERN);
		boolean result = scanner.hasNext();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}

	/**
	 * Reads all remaining tokens from standard input and returns them as an array
	 * of strings.
	 *
	 * @return all remaining tokens on standard input, as an array of strings
	 */
	public static String[] readAllStrings() {
		// we could use readAll.trim().split(), but that's not consistent
		// because trim() uses characters 0x00..0x20 as whitespace
		String[] tokens = WHITESPACE_PATTERN.split(readAll());
		if (tokens.length == 0 || tokens[0].length() > 0)
			return tokens;

		// don't include first token if it is leading whitespace
		String[] decapitokens = new String[tokens.length - 1];
		for (int i = 0; i < tokens.length - 1; i++)
			decapitokens[i] = tokens[i + 1];
		return decapitokens;
	}

	/**
	 * Reads all remaining lines from standard input and returns them as an array of
	 * strings.
	 * 
	 * @return all remaining lines on standard input, as an array of strings
	 */
	public static String[] readAllLines() {
		ArrayList<String> lines = new ArrayList<String>();
		while (hasNextLine()) {
			lines.add(readLine());
		}
		return lines.toArray(new String[lines.size()]);
	}

	/**
	 * Reads all remaining tokens from standard input, parses them as integers, and
	 * returns them as an array of integers.
	 * 
	 * @return all remaining integers on standard input, as an array
	 * @throws InputMismatchException if any token cannot be parsed as an
	 *                                {@code int}
	 */
	public static int[] readAllInts() {
		String[] fields = readAllStrings();
		int[] vals = new int[fields.length];
		for (int i = 0; i < fields.length; i++)
			vals[i] = Integer.parseInt(fields[i]);
		return vals;
	}

	/**
	 * Reads all remaining tokens from standard input, parses them as longs, and
	 * returns them as an array of longs.
	 * 
	 * @return all remaining longs on standard input, as an array
	 * @throws InputMismatchException if any token cannot be parsed as a
	 *                                {@code long}
	 */
	public static long[] readAllLongs() {
		String[] fields = readAllStrings();
		long[] vals = new long[fields.length];
		for (int i = 0; i < fields.length; i++)
			vals[i] = Long.parseLong(fields[i]);
		return vals;
	}

	/**
	 * Reads all remaining tokens from standard input, parses them as doubles, and
	 * returns them as an array of doubles.
	 * 
	 * @return all remaining doubles on standard input, as an array
	 * @throws InputMismatchException if any token cannot be parsed as a
	 *                                {@code double}
	 */
	public static double[] readAllDoubles() {
		String[] fields = readAllStrings();
		double[] vals = new double[fields.length];
		for (int i = 0; i < fields.length; i++)
			vals[i] = Double.parseDouble(fields[i]);
		return vals;
	}

	//// end: section (2 of 2) of code duplicated from In to StdIn

	// do this once when StdIn is initialized
	static {
		resync();
	}

	/**
	 * If StdIn changes, use this to reinitialize the scanner.
	 */
	private static void resync() {
		setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
	}

	private static void setScanner(Scanner scanner) {
		InputUtility.scanner = scanner;
		InputUtility.scanner.useLocale(LOCALE);
	}

	/**
	 * used to read text file content to string
	 * 
	 * @param fileNameWithPath
	 * @return
	 */
	public static String readFileToString(String fileNameWithPath) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileNameWithPath))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * This method is used to convert from string array to String
	 * 
	 * @param stringArray
	 * @return
	 */
	public static String stringArrayToString(String[] stringArray) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stringArray.length; i++) {
			sb.append(stringArray[i]);
		}
		String str = sb.toString();
		return str;
	}

	// for reading 1D array elements of primitive data types
	/**
	 * reads and stores values in 1D array of type byte
	 * 
	 * @param n
	 * @return
	 */
	public static byte[] readByte1DArray(int n) {
		byte[] byteArray = new byte[n];
		for (int index = 0; index < n; index++)
			byteArray[index] = byteVal();
		return byteArray;
	}

	/**
	 * reads and stores values in 1D array of type short
	 * 
	 * @param n
	 * @return
	 */
	public static short[] readShort1DArray(int n) {
		short[] shortArray = new short[n];
		for (int index = 0; index < n; index++)
			shortArray[index] = shortVal();
		return shortArray;
	}

	/**
	 * reads and stores values in 1D array of type int
	 * 
	 * @param n
	 * @return
	 */
	public static int[] readInt1DArray(int n) {
		int[] intArray = new int[n];
		for (int index = 0; index < n; index++)
			intArray[index] = intVal();
		return intArray;
	}

	/**
	 * reads and stores values in 1D array of type long
	 * 
	 * @param n
	 * @return
	 */
	public static long[] readLong1DArray(int n) {
		long[] longArray = new long[n];
		for (int index = 0; index < n; index++)
			longArray[index] = longVal();
		return longArray;
	}

	/**
	 * reads and stores values in 1D array of type float
	 * 
	 * @param n
	 * @return
	 */
	public static float[] readFloat1DArray(int n) {
		float[] floatArray = new float[n];
		for (int index = 0; index < n; index++)
			floatArray[index] = floatVal();
		return floatArray;
	}

	/**
	 * reads and stores values in 1D array of type double
	 * 
	 * @param n
	 * @return
	 */
	public static double[] readDouble1DArray(int n) {
		double[] doubleArray = new double[n];
		for (int index = 0; index < n; index++)
			doubleArray[index] = doubleVal();
		return doubleArray;
	}

	/**
	 * reads and stores values in 1D array of type boolean
	 * 
	 * @param n
	 * @return
	 */
	public static boolean[] readBoolean1DArray(int n) {
		boolean[] booleanArray = new boolean[n];
		for (int index = 0; index < n; index++)
			booleanArray[index] = booleanVal();
		return booleanArray;
	}

	/**
	 * reads and stores values in 1D array of type char
	 * 
	 * @param n
	 * @return
	 */
	public static char[] readChar1DArray(int n) {
		char[] charArray = new char[n];
		for (int index = 0; index < n; index++) {
			logger.info("In char 1D array reading variables" + index);
			charArray[index] = charVal();
			logger.info("stored");
		}
		return charArray;
	}

	/**
	 * reads and stores values in 1D array of type String
	 * 
	 * @param n
	 * @return
	 */
	public static String[] readString1DArray(int arraySize) {
		String array[] = new String[arraySize];
		System.out.println("Enter array elements");
		for (int i = 0; i < arraySize; i++) {
			array[i] = stringVal();
		}
		return array;
	}

	// Take 1D Array Input
	public static Integer[] readInteger1DArray(int arraySize) {
		Integer array[] = new Integer[arraySize];
		System.out.println("Enter array elements");
		for (int i = 0; i < arraySize; i++) {
			array[i] = intVal();
		}
		return array;
	}

	// for reading 2D array elements of primitive data types with different row and
	// column length
	/**
	 * reads and stores values in 2D array of type byte
	 */
	public static byte[][] readByte2DArray(int rows, int columns) {
		byte[][] byteArray = new byte[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				byteArray[index][jIndex] = byteVal();
		}
		return byteArray;
	}

	/**
	 * reads and stores values in 2D array of type char
	 */
	public static char[][] readChar2DArray(int rows, int columns) {
		char[][] charArray = new char[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				charArray[index][jIndex] = charVal();
		}
		return charArray;
	}

	/**
	 * reads and stores values in 2D array of type short
	 */
	public static short[][] readShort2DArray(int rows, int columns) {
		short[][] shortArray = new short[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				shortArray[index][jIndex] = shortVal();
		}
		return shortArray;
	}

	/**
	 * reads and stores values in 2D array of type int
	 */
	public static int[][] readInt2DArray(int rows, int columns) {
		int[][] intArray = new int[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				intArray[index][jIndex] = intVal();
		}
		return intArray;
	}

	/**
	 * reads and stores values in 2D array of type long
	 */
	public static long[][] readLong2DArray(int rows, int columns) {
		long[][] longArray = new long[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				longArray[index][jIndex] = longVal();
		}
		return longArray;
	}

	/**
	 * reads and stores values in 2D array of type float
	 */
	public static float[][] readFloat2DArray(int rows, int columns) {
		float[][] floatArray = new float[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				floatArray[index][jIndex] = floatVal();
		}
		return floatArray;
	}

	/**
	 * reads and stores values in 2D array of type double
	 */
	public static double[][] readDouble2DArray(int rows, int columns) {
		double[][] doubleArray = new double[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				doubleArray[index][jIndex] = doubleVal();
		}
		return doubleArray;
	}

	/**
	 * reads and stores values in 2D array of type string
	 */
	public static String[][] readString2DArray(int rows, int columns) {
		String[][] stringArray = new String[rows][columns];
		for (int index = 0; index < rows; index++) {
			for (int jIndex = 0; jIndex < columns; jIndex++)
				stringArray[index][jIndex] = stringVal();
		}
		return stringArray;
	}

	// for reading 2D array elements of primitive data types with same row and
	// column length
	/**
	 * reads and stores values in 2D array of type byte
	 */
	public static byte[][] readByte2DArray(int n) {
		byte[][] byteArray = new byte[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				byteArray[index][jIndex] = byteVal();
		}
		return byteArray;
	}

	/**
	 * reads and stores values in 2D array of type char
	 */
	public static char[][] readChar2DArray(int n) {
		char[][] charArray = new char[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				charArray[index][jIndex] = charVal();
		}
		return charArray;
	}

	/**
	 * reads and stores values in 2D array of type short
	 */
	public static short[][] readShort2DArray(int n) {
		short[][] shortArray = new short[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				shortArray[index][jIndex] = shortVal();
		}
		return shortArray;
	}

	/**
	 * reads and stores values in 2D array of type int
	 */
	public static int[][] readInt2DArray(int n) {
		int[][] intArray = new int[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				intArray[index][jIndex] = intVal();
		}
		return intArray;
	}

	/**
	 * reads and stores values in 2D array of type long
	 */
	public static long[][] readLong2DArray(int n) {
		long[][] longArray = new long[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				longArray[index][jIndex] = longVal();
		}
		return longArray;
	}

	/**
	 * reads and stores values in 2D array of type float
	 */
	public static float[][] readFloat2DArray(int n) {
		float[][] floatArray = new float[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				floatArray[index][jIndex] = floatVal();
		}
		return floatArray;
	}

	/**
	 * reads and stores values in 2D array of type double
	 */
	public static double[][] readDouble2DArray(int n) {
		double[][] doubleArray = new double[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				doubleArray[index][jIndex] = doubleVal();
		}
		return doubleArray;
	}

	/**
	 * reads and stores values in 2D array of type string
	 */
	public static String[][] readString2DArray(int n) {
		String[][] stringArray = new String[n][n];
		for (int index = 0; index < n; index++) {
			for (int jIndex = 0; jIndex < n; jIndex++)
				stringArray[index][jIndex] = stringVal();
		}
		return stringArray;
	}
	
	/**
	 * static method to convert of integer values into int array
	 * 
	 * @param primeNumbers
	 * @return int array of Prime Numbers
	 */
	public static Integer[] stringToIntArray(String content) {
		String[] words = content.split("\\s+");
		Integer[] primeNumbers = new Integer[words.length];
		// converting each value from String to int
		for (int i = 0; i < words.length; i++) {
			primeNumbers[i] = Integer.parseInt(words[i]);
		}
		return primeNumbers;
	}

}
