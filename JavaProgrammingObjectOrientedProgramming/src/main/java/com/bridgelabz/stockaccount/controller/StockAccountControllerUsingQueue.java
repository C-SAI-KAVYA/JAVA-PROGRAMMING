package com.bridgelabz.stockaccount.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.stockaccount.model.Transaction;
import com.bridgelabz.stockaccount.model.TransactionModel;
import com.bridgelabz.stockaccount.repository.StockAccountRepository;
import com.bridgelabz.stockaccount.utils.QueueList;
import com.bridgelabz.stockaccountmanagement.utils.LogsUtility;

public class StockAccountControllerUsingQueue {

	public static void main(String[] args) {
		
		final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\staticjson\\";
		
		LogsUtility.setLog("StockAccountController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "StockAccountController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		StockAccountRepository repo = new StockAccountRepository();
		TransactionModel transactionModel = new TransactionModel();
		
		String transactionFileName = "TransactionInformation.json";
		QueueList<Transaction> transactionQueue = new QueueList<>();
		
		String initialFilePath = filePath + transactionFileName;
		transactionModel = (TransactionModel) repo.readFromJSONFile(initialFilePath, TransactionModel.class);
		logger.info(transactionQueue);
		logger.info("Successfully read transaction details");
		for(int i = 0; i< transactionModel.getTransactionInformation().size(); i++) {
			transactionQueue.enqueue(transactionModel.getTransactionInformation().get(i));
		}
		
		int size = transactionQueue.size();
		for(int i=0;i<size;i++) {
			logger.info(transactionQueue.get(i).getDateAndTimeOfTransaction());
			transactionQueue.dequeue();
		}
	}

}
