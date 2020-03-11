package com.bridgelabz.stockaccount.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.stockaccount.model.Transaction;
import com.bridgelabz.stockaccount.model.TransactionModel;
import com.bridgelabz.stockaccount.repository.StockAccountRepository;
//import com.bridgelabz.stockaccount.serviceprovider.StockAccountServiceProviderImpl;
import com.bridgelabz.stockaccount.utils.InputUtility;
import com.bridgelabz.stockaccount.utils.StackList;
import com.bridgelabz.stockaccountmanagement.utils.LogsUtility;

public class StockAccountControllerUsingStack {
	
	public static void main(String[] args) {
		LogsUtility.setLog("StockAccountControllerUsingStack");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "StockAccountControllerUsingStack.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
	//	StockAccountServiceProviderImpl impl = new StockAccountServiceProviderImpl();
		
		final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\staticjson\\";
		StockAccountRepository repo = new StockAccountRepository();
		TransactionModel transactionModel = new TransactionModel();
		String transactionFileName = "TransactionInformationUsingStack.json";
		
		String initialFilePath = filePath + transactionFileName;
		transactionModel = (TransactionModel) repo.readFromJSONFile(initialFilePath, TransactionModel.class);
		
		StackList<Transaction> transactionStack = new StackList<>();
		
		for(int i=0; i<transactionModel.getTransactionInformation().size(); i++) {
			transactionStack.push(transactionModel.getTransactionInformation().get(i));
		}
		
		logger.info("Enter company symbol to check transactions of that company");
		String companySymbol = InputUtility.stringVal();
		
		if(companySymbol == transactionStack.peek().getSharesBuyerName()) {
			logger.info(transactionStack.peek().getTransactionID() + "\t");
			logger.info(transactionStack.peek().getSharesBuyerName()+ "\t");
			logger.info(transactionStack.peek().getSharesSellerName()+ "\t");
			logger.info(transactionStack.peek().getTransactionAmount()+ "\t");
			logger.info(transactionStack.peek().getDateAndTimeOfTransaction()+ "\t");
		}
		transactionStack.pop();
	}

}
