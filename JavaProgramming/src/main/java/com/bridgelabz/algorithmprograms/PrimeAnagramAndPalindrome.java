package com.bridgelabz.algorithmprograms;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.OutputUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class PrimeAnagramAndPalindrome {
	
	public static void main(String[] args) {
		LogsUtility.setLog("PrimeAnagramPalindrome");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "PrimeAnagramPalindrome.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		
		logger.info("Enter input");
		try {
			logger.info("enter the limit of prime numbers:");
			int limit = InputUtility.intVal();
			int[] primesNumbers;

			primesNumbers = Utility.primeNumbersRange(limit);

			// getting prime numbers in the specified range
			Utility.printPrimes(limit, primesNumbers);
			OutputUtility.println();
			logger.info("Prime numbers which are palindrome : ");
			List<Integer> primePalindromes = Utility.primePalindrome(limit);
			OutputUtility.printList(primePalindromes);
			OutputUtility.println();
			OutputUtility.println("PrimeNumbers which are Anagrams");
			List<Integer> primeAnagram = Utility.primeAnagrams(limit);
			for (int i = 0; i < primeAnagram.size(); i++) {
				for (int j = i + 1; j < primeAnagram.size(); j++) {
					if (Utility.isAnagram(primeAnagram.get(i), primeAnagram.get(j))) {
						OutputUtility.println(primeAnagram.get(i) + "  " + primeAnagram.get(j));
					}
				}
			}
		} catch (PrimeFactorsCannotBeFoundForZeroAndOneException e) {
			logger.error(e);
		}
}
}
