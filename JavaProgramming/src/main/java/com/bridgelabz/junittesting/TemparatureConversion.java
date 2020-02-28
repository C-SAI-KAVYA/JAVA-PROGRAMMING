package com.bridgelabz.junittesting;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.LogsUtility;
import com.bridgelabz.exceptions.UnsupportedTemparatureEnteredException;
import com.bridgelabz.junittesting.utils.InputUtility;
import com.bridgelabz.junittesting.utils.Utility;

public class TemparatureConversion {
	public static void main(String[] args) {
		LogsUtility.setLog("TemparatureConversion");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"TemparatureConversion.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		logger.info("name:"+logger.getName());
		try {
			logger.info("enter temp in c or f");
			double tem = InputUtility.doubleVal();
			logger.info("enter whether it is in c or f");
			char t = InputUtility.charVal();
			ConvertedTemperatureWithType tempWithType = Utility.temperaturConversion(tem, t);
			logger.info("converted temp is " + tempWithType.convertedTemperature);
			logger.info("temperature is in"+tempWithType.tempType);
		} catch (UnsupportedTemparatureEnteredException e) {
			logger.error(e);
		}

	}
}
