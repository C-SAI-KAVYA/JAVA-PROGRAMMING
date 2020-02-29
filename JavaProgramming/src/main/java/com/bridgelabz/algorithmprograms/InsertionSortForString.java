package com.bridgelabz.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.OutputUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;

public class InsertionSortForString {
	public static void main(String[] args) {
		LogsUtility.setLog("InsertionSortForString");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"InsertionSortForString.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		String content = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\InsertionSortStrings.txt");
		String[] words = content.split("\\s+");
		logger.info("The string achieved from the text file is ");
		logger.info(content);
		String[] sortedUsingInsertionArray = Utility.insertionSortA(words);
		logger.info("The sorted string using insertion sort is as follows");
		
		OutputUtility.print1DStringArray(sortedUsingInsertionArray );
	
		/**
		 * storing back the sorted content into the file
		 */
		String sortedContent =  InputUtility.stringArrayToString(sortedUsingInsertionArray);
		logger.info("the sorted string is");
		OutputUtility.println(sortedContent);
		OutputUtility.writeToFile(sortedContent, "F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\InsertionSortStrings.txt");
}
}
