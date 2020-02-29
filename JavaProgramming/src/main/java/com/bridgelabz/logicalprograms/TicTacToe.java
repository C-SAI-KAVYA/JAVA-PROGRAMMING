package com.bridgelabz.logicalprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.logicalprograms.utils.LogsUtility;
import com.bridgelabz.logicalprograms.utils.Utility;

public class TicTacToe {

	public static void main(String[] args) {
		LogsUtility.setLog("TicTacToe");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"TicTacToe.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Welcome to the TicTacToe game");
		logger.info("Lets start");
		
		String decision = Utility.playTicTacToe();
		System.out.println(decision);
	}

}
