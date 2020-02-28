package com.bridgelabz.algorithmprograms;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.SelectedStringDoesNotExsistsException;
import com.bridgelabz.logicalprograms.utils.OutputUtility;

public class BinarySearchForWord {

	public static void main(String[] args) {
		LogsUtility.setLog("BinarySearchForWord");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"BinarySearchForWord.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		String content = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\BinaryWordSearch.txt");
		String[] words = content.split("\\s+");
		OutputUtility.print1DStringArray(words);
		logger.info("Done reading words");

		// sort the words (if needed)
		Arrays.sort(words);
		logger.info("Done sorting words");

		// prompt user to enter a word and check if it's there
		while (!InputUtility.isEmpty()) {
			String key = InputUtility.stringVal();
			logger.info("Reading the String");
			try {
				if (Utility.binaryWordsearch(key, words) <= 0)
					logger.info("Not found------------" + key);

				else
					logger.info("found--------" + key);
			} catch (SelectedStringDoesNotExsistsException e) {
				logger.error(e);
			}
		}
	}
}
