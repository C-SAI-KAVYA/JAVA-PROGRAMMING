package com.bridgelabz.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.CannotCheckAnagramForEmptyStringException;

public class StringAnagram {
	public static void main(String[] args) {
		LogsUtility.setLog("StringAnagram");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"StringAnagram.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		String string1 = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\StringAnagramText1.txt");
		
		String string2 = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\StringAnagramText2.txt");
		
		boolean isAnagram;
		try {
			isAnagram = Utility.isAnagram(string1, string2);
			if(isAnagram) 
				logger.info("Strings are anagram");
			else
				logger.info("Strings are not anagram");
		} catch (CannotCheckAnagramForEmptyStringException e) {
			e.printStackTrace();
		}
}
	

}
