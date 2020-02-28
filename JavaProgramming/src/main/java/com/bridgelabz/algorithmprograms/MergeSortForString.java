package com.bridgelabz.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.algorithmprograms.utils.OutputUtility;

public class MergeSortForString {
	public static void main(String[] args) {
		LogsUtility.setLog("MergerSortForString");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"MergeSortForString.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		String content = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\MergeSortStrings.txt");
		String[] words = content.split("\\s+");
		
		logger.info("The content in the text file is as follows");
		logger.info(content);
		
		String[] sortedUsingMergeSort = Utility.mergeSortA(words);
		
		logger.info("The sorted string is as follows");
		OutputUtility.print1DStringArray(sortedUsingMergeSort);
		OutputUtility.println();
		
		/**
		 * storing back the sorted content into the file
		 */
		String sortedContent =  InputUtility.stringArrayToString(sortedUsingMergeSort);
		logger.info("the sorted string is");
		System.out.println(sortedContent);
		OutputUtility.writeToFile(sortedContent, "F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\MergeSortStrings.txt");
		
	}
}
