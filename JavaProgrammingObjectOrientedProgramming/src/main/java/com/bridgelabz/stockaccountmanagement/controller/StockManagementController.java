package com.bridgelabz.stockaccountmanagement.controller;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.stockaccountmanagement.model.StockAccountManagementModel;
import com.bridgelabz.stockaccountmanagement.serviceprovider.StockAccountManagementServiceProviderImpl;
import com.bridgelabz.stockaccountmanagement.utils.InputUtility;
import com.bridgelabz.stockaccountmanagement.utils.LogsUtility;

public class StockManagementController {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		LogsUtility.setLog("StockManagementController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"StockManagementController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Stock Management Controller");
		
		StockAccountManagementServiceProviderImpl impl = new StockAccountManagementServiceProviderImpl();
		double totalDairyMilk = 0;
		double totalMilkyBar = 0; 
		double totalKitKat = 0;
		double totalPikNik = 0;
		
		
		StockAccountManagementModel stockData = new StockAccountManagementModel();
		stockData = impl.readJsonFile();
		boolean close = false;
		
		while(!close) {
			logger.info("Choose an option");
			logger.info("\n1. Get Dairy Milk Company Stock Details \n2. Get MilkyBar Company Stock Details\n3. Get Kit Kat Company Stock Details\n4. Get Pik Nik Company Stock Details\n5. Get All Stock Details\n6. close stock details");
		switch(InputUtility.intVal()) {
			case 1:
				logger.info("Stock Name is "+stockData.getDairyMilk().get(0).getStockName());
				logger.info("Stock Price is "+stockData.getDairyMilk().get(0).getSharePrices());
				logger.info("Stock Number of Shares are "+stockData.getDairyMilk().get(0).getNumberOfShares());
				totalDairyMilk = impl.getTotalValueOfDairyMilk(stockData.getDairyMilk().get(0).getNumberOfShares(), stockData.getDairyMilk().get(0).getSharePrices());
				logger.info("Total Stock Value of Dairy Milk is "+totalDairyMilk);
				stockData.getDairyMilk().get(0).setTotalStockValue(totalDairyMilk);
			break;
			case 2:
				logger.info("Stock Name is "+stockData.getMilkyBar().get(0).getStockName());
				logger.info("Stock Price is "+stockData.getMilkyBar().get(0).getSharePrices());
				logger.info("Stock Number of Shares are "+stockData.getMilkyBar().get(0).getNumberOfShares());
				totalMilkyBar = impl.getTotalValueOfMilkyBar(stockData.getMilkyBar().get(0).getNumberOfShares(), stockData.getMilkyBar().get(0).getSharePrices());
				logger.info("Total Stock Value of Milky Bar is "+totalMilkyBar);
				stockData.getMilkyBar().get(0).setTotalStockValue(totalMilkyBar);
			break;
			case 3:
				logger.info("Stock Name is "+stockData.getKitKat().get(0).getStockName());
				logger.info("Stock Price is "+stockData.getKitKat().get(0).getSharePrices());
				logger.info("Stock Number of Shares are "+stockData.getKitKat().get(0).getNumberOfShares());
				totalKitKat = impl.getTotalValueOfKitKat(stockData.getKitKat().get(0).getNumberOfShares(), stockData.getKitKat().get(0).getSharePrices());
				logger.info("Total Stock Value of Kit Kat is "+totalKitKat);
				stockData.getKitKat().get(0).setTotalStockValue(totalKitKat);
			break;
			case 4:
				logger.info("Stock Name is "+stockData.getPikNik().get(0).getStockName());
				logger.info("Stock Price is "+stockData.getPikNik().get(0).getSharePrices());
				logger.info("Stock Number of Shares are "+stockData.getPikNik().get(0).getNumberOfShares());
				totalPikNik = impl.getTotalValueOfPikNik(stockData.getPikNik().get(0).getNumberOfShares(), stockData.getPikNik().get(0).getSharePrices());
				logger.info("Total Stock Value of Pik Nik is "+totalPikNik);
				stockData.getPikNik().get(0).setTotalStockValue(totalPikNik);
			break;
			case 5:
				logger.info(" "+totalDairyMilk+" "+totalKitKat+" "+totalMilkyBar+" "+totalPikNik);
				logger.info("The total stock value of all the stocks together is "+impl.getTotalValueOfAllStocks(totalDairyMilk, totalMilkyBar, totalKitKat, totalPikNik));
				stockData.setTotalValueOfAllStocks(impl.getTotalValueOfAllStocks(totalDairyMilk, totalMilkyBar, totalKitKat, totalPikNik));
			break;
			case 6:
					close = true;
					logger.info("Closed stock details");
			break;
			default:
				logger.info("Invalid Option");
		}
		}
		
		try {
			impl.writeIntoJSON(stockData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
