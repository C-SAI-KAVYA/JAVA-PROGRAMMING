package com.bridgelabz.algorithmprograms;

import java.util.Date;
import java.util.InputMismatchException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;
import com.bridgelabz.algorithmprograms.utils.OutputUtility;
import com.bridgelabz.algorithmprograms.utils.UserDetails;
import com.bridgelabz.algorithmprograms.utils.Utility;

public class ReplaceStringUsingRegex {
	public static void main(String args[])
	{
		LogsUtility.setLog("ReplaceStringUsingRegex");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"ReplaceStringUsingRegex.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		
		logger.info("Logger Name : " + logger.getName());
		logger.warn("Can Cause InputMismatchException");
		logger.info("Enter input");
		try {
			Utility utility=new Utility();
			UserDetails user=new UserDetails();
			logger.info("Enter FirstName:");
			user.setfName(utility.inputString());
			OutputUtility.println();
	
			logger.info("Enter LastName:");
			user.setlName(utility.inputString());
			OutputUtility.println();
		
			logger.info("Enter Mobile Number:");
			user.setmobileNo(utility.inputString());
			OutputUtility.println();	
			
			//Setting current date
			logger.info("Today's Date : "+new Date());
			user.setdate(utility.getFormatedDate(new Date()));
			OutputUtility.println();
			String filePath = "F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\RegistrationAndReplacement.txt";
			OutputUtility.println(utility.convertString(user,InputUtility.readFileToString(filePath)));
			
			OutputUtility.writeToFile(utility.convertString(user, InputUtility.readFileToString(filePath)), filePath);
		} catch (InputMismatchException ime) {
			logger.error(ime);
		}
			
}

}
