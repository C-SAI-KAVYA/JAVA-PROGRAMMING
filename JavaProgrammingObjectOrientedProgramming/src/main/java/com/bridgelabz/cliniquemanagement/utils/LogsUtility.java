package com.bridgelabz.cliniquemanagement.utils;

import org.apache.log4j.Logger;

public class LogsUtility {
	
	private LogsUtility() {
		
	}
	public static final String FILEPATH = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\logs\\";
	public static final String CONFIGPATH = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\loggers\\log4j.properties";
	private static Logger logger;
	
	public static Logger getLog() {
		return logger;
	}
	public static void setLog(String className) {
		LogsUtility.logger = Logger.getLogger(className);
	}
}
