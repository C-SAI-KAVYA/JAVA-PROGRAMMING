package com.bridgelabz.junittesting.utils;

import org.apache.log4j.Logger;

import com.bridgelabz.exceptions.ChangeCannotBeCalculatedForZeroOrNegativeException;
import com.bridgelabz.exceptions.InvalidDateEnteredException;
import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.exceptions.UnsupportedTemparatureEnteredException;
import com.bridgelabz.junittesting.ConvertedTemperatureWithType;

public class Utility {

	static Logger logger = Logger.getLogger(Utility.class);

	private Utility() {

	}

	// Vending Machine
	public static int i = 0;
	public static int total = 0;
	public static final int[] notes = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
	public static int count = 0;

	/**
	 * Tenders the minimum number of notes required in return to the amount entered
	 * by the user
	 * 
	 * @param amount
	 * @param notes
	 * @return
	 * @throws ChangeCannotBeCalculatedForZeroOrNegativeException 
	 */
	public static int vendingMachine(int money, int[] notes) throws ChangeCannotBeCalculatedForZeroOrNegativeException {
	   		//calling calculate Function
	         int rem;
	         if(money==0) {
	        	return -1;
	         }
	 			if(money>=notes[i])
	 			{
	 				// logic for Calculating The notes
	 				int calNotes =money/notes[i];
	 				rem = money%notes[i];
	 				money =rem;
	 				total += calNotes;
	 				logger.info(notes[i]+   " Notes ---> " +calNotes );
	 				
	 			}
	 			i++;
	 			vendingMachine(money, notes);
	 			return total;
	}

	// Day Of Week
	/**
	 * Function to check the day of the week of given date
	 *
	 * @param d int value for day of date
	 * @param m int value for month of year
	 * @param y int value for year
	 * @return day of week from 1 to 7
	 * @throws InvalidDateEnteredException
	 */
	public static int dayOfWeek(int d, int m, int y) throws InvalidDateEnteredException {
		if (d < 1 || d > 31 || m < 1 || m > 12 || y <= 999 || y >= 9999 || (y % 4 == 0 && m == 2 && d >29)) {
			throw new InvalidDateEnteredException("Entered date is invalid");
		} else {
			int y0 = y - (14 - m) / 12;
			int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
			int m0 = m + 12 * ((14 - m) / 12) - 2;
			return (d + x + (31 * m0) / 12) % 7;
		}
	}

	// temperature conversion
	/**
	 * Function to convert fahrenheit to celcius and vice-versa
	 *
	 * @param tem the value of temperature
	 * @param t   the character ie c or f for given temp to convert
	 * @return converted temperature
	 */
	public static ConvertedTemperatureWithType temperaturConversion(double tem, char t)
			throws UnsupportedTemparatureEnteredException {
		double convertedTemperature;
		char type;
		if (t != 'c' && t != 'C' && t != 'f' && t != 'F') {
			throw new UnsupportedTemparatureEnteredException(
					"The temparature is expected to be either in celcius or farenheit");
		} else {
			if (t == 'c' || t == 'C') {
				convertedTemperature = (tem * 9 / 5) + 32;
				type = 'f';
			} else if (t == 'f' || t == 'F') {
				convertedTemperature = (tem - 32) * 5 / 9;
				type = 'c';
			} else {
				logger.info("Enter correct input");
				return new ConvertedTemperatureWithType(0.0, ' ');
			}
		}
		return new ConvertedTemperatureWithType(convertedTemperature, type);
	}

	// Monthly payments
	/**
	 * to calculate monthly payment for r interest and p principal for y years
	 *
	 * @param p the principal amount given
	 * @param y the year for which p is given
	 * @param r the rate at which p is given
	 * @return monthly payment
	 * @throws LessThanOrGreaterThanSpecifiedRangeException
	 */
	public static double monthlyPayment(double principalLoanAmount, int year, double rateOfInterest)
			throws LessThanOrGreaterThanSpecifiedRangeException {
		if (year < 999 || year > 9999 || principalLoanAmount == 0) {
			throw new LessThanOrGreaterThanSpecifiedRangeException(
					"year must be four digit or payment value should be greater than zero ");
		} else {
			double n = 12 * year;
			double r0 = rateOfInterest / (12 * 100);
			return principalLoanAmount * r0 / (1 - Math.pow((1 + r0), -n));
		}
	}

	// Square Root
	/**
	 * Function to find the square root of given no
	 *
	 * @param c the value to find square root of
	 * @return return the square root
	 * @throws NegativeOrZeroNumberFoundException
	 */
	public static double sqrt(double c) throws NegativeOrZeroNumberFoundException {
		if (c <= 0) {
			throw new NegativeOrZeroNumberFoundException(
					"to calculate square root using newtons method c must be positive");
		} else {
			double t = c;
			double epsilon = 1e-15;
			while (Math.abs(t - c / t) > epsilon * t) {
				t = (c / t + t) / 2;
			}
			return t;
		}

	}

	// Decimal to binary
	// function to convert decimal to binary
	// Binary
	/**
	 * Function to convert decimal to binary
	 *
	 * @param d integer value to convert
	 * @return return integer array with binary digits
	 * @throws NegativeOrZeroNumberFoundException
	 */
	public static int[] toBinary(int decimal) throws NegativeOrZeroNumberFoundException {
		if (decimal <= 0) {
			throw new NegativeOrZeroNumberFoundException("Cannot convert negative or zero to binary");
		} else {
			// array to store binary number
			int[] binaryNum = new int[8];

			// counter for binary array
			int i = 0;
			while (decimal > 0) {
				// storing remainder in binary array
				binaryNum[i] = decimal % 2;
				decimal = decimal / 2;
				i++;
			}
			return binaryNum;
		}
	}

	// binary
	/**
	 * Function to print array
	 *
	 * @param array the array to print integer on console
	 */
	public static void showArr(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			OutputUtility.print(arr[i]);
		}
		OutputUtility.println();
	}

	/**
	 * Function to convert string to int array helper function for swapnibble in
	 * Binary.java class
	 *
	 * @param bin String of binary no
	 * @return return integer array
	 */
	public static int[] stringToIntArray(String bin) {
		int[] binary = new int[bin.length()];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = bin.charAt(i) - 48;
		}
		return binary;
	}

	// Binary Swap

	/**
	 * Function to swap nibbles in array
	 *
	 * @param int array to swap nibbles in array
	 * @return return swapped array
	 */
	public static int[] swapNibbles(int[] arr) {
		// swap nibbles at first and last of the array
		// j is used for saving last 4 index of the array
		int temp, j = arr.length - 4;
		for (int i = 0; i < 4; i++) { // loop runs 4 times and swap first four element to last four elements
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j++;
		}
		return arr;
	}

	/**
	 * Function to convert binary to decimal
	 *
	 * @param binary the binary array to convert
	 * @return return converted decimal no
	 */
	public static int toDecimal(int[] binary) {
		int dec = 0, j = 0;
		for (int i = binary.length - 1; i >= 0; i--) {
			if (binary[i] == 1) {
				dec = dec + (int) Math.pow(2, j);
			}
			j++;
		}
		return dec;
	}

	/**
	 * Function to check if no is power of 2
	 *
	 * @param number to check the for power of 2
	 * @return boolean for prime no
	 * @throws NegativeOrZeroNumberFoundException
	 */
	public static boolean powerOf2(int number) throws NegativeOrZeroNumberFoundException {
		if (number <= 0) {
			throw new NegativeOrZeroNumberFoundException(
					"Cannot find whether power of two or not for negative or zero numbers");
		} else {
			while (number > 1) {
				if (number % 2 != 0) {
					return false;
				}
				number = number / 2;
			}
			return true;
		}
	}
}
