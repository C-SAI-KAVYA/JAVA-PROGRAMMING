package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.OutputUtility;
import com.bridgelabz.datastructures.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class PrimeAnagrams2DArray {

	public static void main(String[] args) {
		LogsUtility.setLog("PrimeAnagrams2DArray");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "PrimeAnagrams2DArray.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Prime Anagrams in 2D array");
		try {
			int[][] primeAnagram2DArray = Utility.primeAnagram2DArray(1000);
			for (int[] p : primeAnagram2DArray) {
				for (int p1 : p) {
					if(p1!=0) {
						OutputUtility.print(p1+" ");
					}
				}
				OutputUtility.println();
			}
		} catch (PrimeFactorsCannotBeFoundForZeroAndOneException e) {
			logger.error(e);
		}
	}
}
