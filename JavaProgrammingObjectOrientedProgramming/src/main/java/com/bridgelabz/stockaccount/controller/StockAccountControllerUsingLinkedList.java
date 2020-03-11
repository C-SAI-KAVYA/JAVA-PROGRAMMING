package com.bridgelabz.stockaccount.controller;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.stockaccount.serviceprovider.StockAccountServiceProviderImpl;
import com.bridgelabz.stockaccount.utils.InputUtility;
import com.bridgelabz.stockaccountmanagement.utils.LogsUtility;

public class StockAccountControllerUsingLinkedList {
	public static void main(String[] args) {

		LogsUtility.setLog("StockAccountController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "StockAccountController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		StockAccountServiceProviderImpl impl = new StockAccountServiceProviderImpl();
		
		
		logger.info("---------------------------Stock Account Using Linked List---------------------------------");
		boolean exit = false;
		int indexOfCustomer = 0;
		int customerID = 0;
		int numberOfSharesToBuy = 0;
		impl.readCompanyInfoFromJSONFile();
		impl.readCustomerInfoFromJSONFile();
			while (!exit) {
				logger.info("Choose what you wuld like to do");
				logger.info(
						"\n1. Buy Shares \n2. Sell Shares\n3. Save Transaction Details \n4. Print the Transaction information Report \n5. Exit from the menu");
				switch (InputUtility.intVal()) {
				case 1:
					logger.info("please enter how many shares you would like to buy");
					numberOfSharesToBuy = InputUtility.intVal();
					double newCustomerBalance = impl.buyShares(numberOfSharesToBuy, indexOfCustomer);
					logger.info("New customer balance is "+newCustomerBalance);
					break;
				case 2:
					logger.info("Enter number of shares you want to sell to the company");
					int sharesToBeSold = InputUtility.intVal();
					double newBalance = impl.sellShares(sharesToBeSold, indexOfCustomer);
					logger.info("New company balance is "+newBalance);
					break;
				case 3:
					logger.info("Saving Transaction information");
					logger.info("Enter file name where you want to store Transaction information");
					String fileName2 = InputUtility.stringVal();
					try {
						impl.saveTransactionDetails(fileName2);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					logger.info("Print the transaction information report");
					impl.printReport(customerID);
					break;
				case 5:
					exit = true;
					logger.info("----------------------Successfully exited------------------------");
					break;
				default:
					logger.info("Invalid Option");
				}
			}
		}

}
