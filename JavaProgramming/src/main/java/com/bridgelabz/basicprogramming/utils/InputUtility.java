package com.bridgelabz.basicprogramming.utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtility {

	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

	private static final Pattern EMPTY_PATTERN = Pattern.compile("");
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
	
	private InputUtility() {
		throw new IllegalStateException("InputUtility class");
	}
	public static boolean isEmpty() {
		return !scanner.hasNext();
}

	public static boolean hasNextLine() {
		return scanner.hasNextLine();
	}
	private static final Scanner scanner = new Scanner(System.in);
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
					+ "but the next token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'byte' value from standard input, " + "but no more tokens are available");
		}
	}
	
	public static short shortVal() {
		try {
			return scanner.nextShort();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read a 'short' value from standard input, "
					+ "but the next token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'short' value from standard input, " + "but no more tokens are available");
		}
	}
	
	public static int intVal() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read an 'int' value from standard input, "
					+ "but the next token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("attemps to read an 'int' value from standard input, " + "but no more tokens are available");
		}

	}
	public static long longVal() {
		try {
			return scanner.nextLong();
		} catch (InputMismatchException e) {
			String token = scanner.next();
			throw new InputMismatchException("attempts to read a 'long' value from standard input, "
					+ "but the next token is \"" + token + "\"");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(
					"attempts to read a 'long' value from standard input, " + "but no more tokens are available");
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
	
	
}
