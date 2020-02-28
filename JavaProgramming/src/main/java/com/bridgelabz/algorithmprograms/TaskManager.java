package com.bridgelabz.algorithmprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.LogsUtility;

public class TaskManager {
	public static void main(String[] args) {
		
		LogsUtility.setLog("TaskManager");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"TaskManager.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Logger Name : " + logger.getName());
		logger.warn("Can Cause InputMismatchException");
		logger.info("Enter input");
		try {
			logger.info("enter no of tasks");
			int tasks = InputUtility.intVal();
			int[] dead = new int[tasks];
			int[] min = new int[tasks];
			for (int i = 0; i < min.length; i++) {
				logger.info("task " + i + " time");
				min[i] = InputUtility.intVal();
				logger.info("task " + i + " deadline");
				dead[i] = InputUtility.intVal();
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
