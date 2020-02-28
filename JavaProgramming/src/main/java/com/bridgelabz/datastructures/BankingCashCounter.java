package com.bridgelabz.datastructure;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.Queue;
import com.bridgelabz.datastructures.utils.Utility;
import com.bridgelabz.exceptions.UnspecifiedOptionSelectedException;

public class BankingCashCounter {

	public static void main(String[] args) {
		
		/**
		 * Setting up logger
		 */
		LogsUtility.setLog("BankingCashCounter");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "BankingCashCounter.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		/**
		 * Queue to add customers into the line and serve one at a time and remove when he/she is served
		 */
		Queue<Integer> queue = new Queue<Integer>(10);
		try {
			for (int i = 1; i <= 10;) {
				logger.info("Token number " + i + " please");
				queue.enqueue(i);//customer added to queue
				logger.info("sir/mam enter your account name");
				String accountHolderName = InputUtility.stringVal();
				String status = Utility.bankCashCounter(accountHolderName);
				if (!(status.equals(""))) {
					queue.dequeue();//served so removing from queue
					i++;
				}else
					i++;
			}
		} catch (UnspecifiedOptionSelectedException uose) {
			logger.error(uose);
		}

	}
}
