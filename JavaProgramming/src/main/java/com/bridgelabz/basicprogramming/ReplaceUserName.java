package com.bridgelabz.basicprogramming;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.NameNotFoundException;

public class ReplaceUserName {

	public static void main(String[] args){
		/**
		 * Initializing the Loggers properties file
		 */
		LogsUtility.setLog("ReplaceUserName");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"ReplaceUserName.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		String yesOrNo = "";
		
		
		// printing information for the user to understand
		String mainString = "Hello <<UserName>>, How are you??";
		logger.info(mainString);
		logger.info("is the standard string would you like to use the same to replace or would you like to customize it");
		logger.info("enter yes or no");
		yesOrNo = InputUtility.stringVal();
		String toBeReplaced = "";
		String replaceWith = "";
		boolean flag = true;
		if (yesOrNo.equalsIgnoreCase("yes")) {
			logger.info("enter the string you want to modify");
			mainString = InputUtility.stringVal();
			logger.info("Enter the word you want to replace and the word with which you want to replace");
			toBeReplaced = InputUtility.stringVal();
			while (flag) {
				if (Utility.checkToBeReplaced(mainString, toBeReplaced)) {
					logger.info("enter the word you want to replace with");
					replaceWith = InputUtility.stringVal();
					if (Utility.checkReplaceWith(replaceWith)) {
						try {
							mainString = Utility.replaceUserName(mainString, toBeReplaced, replaceWith);
						} catch (NameNotFoundException e) {
							logger.error(e);
						}
						logger.info("The modified string is as follows");
						logger.info(mainString);
						flag = false;
					} else {
						logger.info("enter some string with min of two characters");
						replaceWith = InputUtility.stringVal();
					}
				} else {
					logger.info("enter toBeReplaced word once again");
					toBeReplaced = InputUtility.stringVal();
				}
			}
		}else {
			logger.info("Enter the word you want to replace and the word with which you want to replace");
			toBeReplaced = InputUtility.stringVal();
			while (flag) {
				if (Utility.checkToBeReplaced(mainString, toBeReplaced)) {
					logger.info("enter the word you want to replace with");
					replaceWith = InputUtility.stringVal();
					if (Utility.checkReplaceWith(replaceWith)) {
						try {
							mainString = Utility.replaceUserName(mainString, toBeReplaced, replaceWith);
						} catch (NameNotFoundException e) {
							logger.error(e);
						}
						logger.info("The modified string is as follows");
						logger.info(mainString);
						flag = false;
					} else {
						logger.info("enter some string with min of two characters");
						replaceWith = InputUtility.stringVal();
					}
				} else {
					logger.info("enter toBeReplaced word once again");
					toBeReplaced = InputUtility.stringVal();
				}
			}
			
		}
	}
}
