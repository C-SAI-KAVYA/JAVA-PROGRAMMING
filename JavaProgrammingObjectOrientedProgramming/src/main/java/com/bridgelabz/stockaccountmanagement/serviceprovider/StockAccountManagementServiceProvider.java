package com.bridgelabz.stockaccountmanagement.serviceprovider;

import java.io.FileNotFoundException;

import com.bridgelabz.stockaccountmanagement.model.StockAccountManagementModel;

public interface StockAccountManagementServiceProvider {
	
	public StockAccountManagementModel readJsonFile();
	public double calculateTotalValueOfStock(int numberOfShares, double sharePrices);
	public double getTotalValueOfDairyMilk(int numberOfShares, double sharePrices);
	public double getTotalValueOfMilkyBar(int numberOfShares, double sharePrices);
	public double getTotalValueOfKitKat(int numberOfShares, double sharePrices);
	public double getTotalValueOfPikNik(int numberOfShares, double sharePrices);
	public double getTotalValueOfAllStocks(double totalDairyMilk, double totalMilkyBar, double totalKitKat, double totalPikNik);
	public void writeIntoJSON(Object obj) throws FileNotFoundException;
}
