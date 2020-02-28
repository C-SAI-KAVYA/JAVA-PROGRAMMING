package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.Stack;
import com.bridgelabz.datastructures.utils.StackList;
import com.bridgelabz.datastructures.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class PrimeAnagramsInStack {

	public static void main(String[] args) {
		
		LogsUtility.setLog("PrimeAnagramsInStack");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "PrimeAnagramsInStack.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("prime anagrams in stack");
		try {
			int[] primes = Utility.primeNumbersRange(1000);
			Stack<Integer> stack = new Stack<>(primes.length);
			for(int i=primes.length-1; i>0;i--) {
				stack.push(primes[i]);
			}
			StackList<Integer> stackOfAnagrams = Utility.primeAnagrams(stack);
			//first reverse and then print
			stackOfAnagrams.printReverse();
			
			} catch (ArrayIndexOutOfBoundsException | PrimeFactorsCannotBeFoundForZeroAndOneException e) {
			e.printStackTrace();
		}

	}

}
