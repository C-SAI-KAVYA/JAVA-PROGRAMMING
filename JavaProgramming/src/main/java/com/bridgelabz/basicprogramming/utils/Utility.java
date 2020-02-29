package com.bridgelabz.basicprogramming.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.bridgelabz.exceptions.CannotCalculateZeroPowerException;
import com.bridgelabz.errors.HarmonicNumberCannotBeFoundError;
import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.exceptions.NameNotFoundException;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.exceptions.NumberNotInRequiredFormatOrSizeException;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class Utility {
	static Logger logger = Logger.getLogger(Utility.class);

	// Java adds an implicit public constructor to every class which does not define
	// at least one explicitly.
	// Hence, at least one non-public constructor should be defined.
	private Utility() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Replace the user name from <<UserName>> to the user entered user name
	 * Example:- Hello <<UserName>>, How are you?? UserName = JamesGosling Hello
	 * JamesGosling, How are you??
	 */

	public static boolean checkToBeReplaced(String mainString, String toBeReplaced) {
		boolean check1 = false;
		if (mainString.contains(toBeReplaced))
			check1 = true;
		return check1;
	}

	public static boolean checkReplaceWith(String replaceWith) {
		boolean check1 = false;
		if (!"".equals(replaceWith))
			check1 = true;
		return check1;
	}

	public static String replaceUserName(String mainString, String toBeReplaced, String replaceWith)
			throws NameNotFoundException {
		if (checkToBeReplaced(mainString, toBeReplaced) && checkReplaceWith(replaceWith)) {
			mainString = mainString.replaceAll(toBeReplaced, replaceWith);
			return mainString;
		} else {
			throw new NameNotFoundException("Incorrect Inputs Exceptions");
		}
	}

	// Method for Flip coin
	/**
	 * accepts user inputs how many times he/she wants to flip the coin and returns
	 * the percentage of how many times heads and tails may occur
	 * 
	 * @param times
	 * @return
	 */
	public static double[] flipCoin(int times) throws NegativeOrZeroNumberFoundException {
		double heads = 0;
		double tails = 0;
		double[] headsAndTailsPercentage = new double[2];
		if (times <= 0) {
			throw new NegativeOrZeroNumberFoundException("Incorrect Inputs Exceptions");
		} else {
			for (int i = 0; i < times; i++) {
				// Math.random() returns a value that is between 0.0 and 1.0
				if (Math.random() > 0.5) {
					heads++;
				} else
					tails++;
			}
		}
		// [0] heads percentage position [1] tails percentage position
		headsAndTailsPercentage[0] = (heads / times * 100);
		headsAndTailsPercentage[1] = (tails / times * 100);

		return headsAndTailsPercentage;
	}

	// Method to Check Leap year
	/**
	 * accepts any random year entered from the user prints whether the entered year
	 * is a leap year or not
	 * @param year
	 * @return
	 */
	public static int numberLength(int num) {
		int count = 0;
		while (num != 0) {
			num /= 10;
			++count;
		}
		return count;
	}

	public static boolean isLeapYear(int year) throws NumberNotInRequiredFormatOrSizeException, LessThanOrGreaterThanSpecifiedRangeException {
		boolean check = false;
		int yearLength = numberLength(year);
		if (yearLength != 4) {
			throw new NumberNotInRequiredFormatOrSizeException("Number is not in the required size or format");
		}
		if (year > 1582 && year < 9999) {
			if (year > 1000 && (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
				check = true;
			}
		} else {
			throw new LessThanOrGreaterThanSpecifiedRangeException("Number is less than or greater than the specified range");
		}
		return check;
	}

	// PowerOf2
	/**
	 * Accepts any random integer "tillPower" and "numberPower" tillPower is the
	 * range till where the numbers will be printed for example if 2 then 2^0=1
	 * 2^1=2 2^2=4 numberPower is whose powers will be printed for example 2 powers
	 * or 3 powers and so forth
	 * 
	 * @param tillPower
	 * @param numberPower
	 * @return
	 * @throws CannotCalculateZeroPowerException
	 */
	public static double[] powerOfTwo(int tillPower, int numberPower) throws CannotCalculateZeroPowerException {
		if(tillPower==0) {
			double[] arr = {1};
			return arr;
		}
		if (tillPower == 0 && numberPower == 0) {
			throw new CannotCalculateZeroPowerException("Incorrect Inputs Exceptions");
		} else {
			double[] powerArr = new double[Math.abs(tillPower)];
			if (tillPower > 0) {
				for (int i = 0; i < tillPower; i++) {
					powerArr[i] = (int) Math.pow(numberPower, i);
				}
			} else {
				for (int i = 0; i < Math.abs(tillPower); i++) {
					powerArr[i] = (1 / Math.pow(numberPower, i));
				}
			}
			return powerArr;
		}
	}

	// Prime Factors
	/**
	 * accepts random integer as input and returns a list of prime factors of the
	 * number entered
	 * 
	 * @param number returns list of prime factors
	 */
	// PrimeFactors
	private static List<Integer> primeFactors;

	public static List<Integer> primeFactors(long number) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		if (number == 0 || number == 1) {
			throw new PrimeFactorsCannotBeFoundForZeroAndOneException("Zero and One are not prime numbers");
		}
		primeFactors = new ArrayList<>();
		for (int i = 2; i <= number; i++) {
			if (number % i == 0) {
				primeFactors.add(i); // prime factor
				number /= i;
				i--;
			}
		}
		return primeFactors;
	}

	// Harmonic
	/**
	 * Accepts random integer and returns a double value which is the Nth harmonic
	 * of the number entered
	 * 
	 * @param num
	 * @return
	 * @throws CustomizedException
	 */
	public static double harmonicNumber(int num) throws HarmonicNumberCannotBeFoundError {
		if (num <= 0) {
			throw new HarmonicNumberCannotBeFoundError("Cannot find harmonic numbers for zero and negative numbers");
		} else {
			double sum = 0.0;
			for (int i = 1; i <= num; i++)
				sum = sum + (1.0 / i);
			return sum;
		}

	}

}
