package com.bridgelabz.stockaccount.serviceprovider;

import java.io.FileNotFoundException;

public interface StockAccountServiceProvider {
		
		public void readCompanyInfoFromJSONFile();
		public void readCustomerInfoFromJSONFile();
		public void readTransactionInfoFromJSONFile();
		public int buyShares(int numberOfSharesToBuy, int indexOfCustomer);
		public int sellShares(int sharesToBeSold, int indexOfCustomer);
		public void saveTransactionDetails(String fileName) throws FileNotFoundException;
		public void printReport(int customerID);
		
}
