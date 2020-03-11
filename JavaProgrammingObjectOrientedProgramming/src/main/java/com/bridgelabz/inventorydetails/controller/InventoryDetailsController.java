package com.bridgelabz.inventorydetails.controller;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.inventorydetails.model.InventoryDetailsModel;
import com.bridgelabz.inventorydetails.serviceprovider.InventoryDetailsServiceProviderImpl;
import com.bridgelabz.stockaccountmanagement.utils.LogsUtility;

public class InventoryDetailsController {
	public static void main(String[] args) {
		LogsUtility.setLog("InventoryDetailsController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "InventoryDetailsController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("---------------------------Inventory Details Controller--------------------------------------------");
		
		InventoryDetailsServiceProviderImpl impl = new InventoryDetailsServiceProviderImpl();
		InventoryDetailsModel model;
		
		model = impl.readInventoryDetailsInfoFromJSONFile();
		
		int totalStockValue = 0;
		logger.info("Company Name Of The Pulses is :" + model.getPulsesList().get(0).getProductName());
		logger.info("Price Of The Pulses Product Per Kg is :"+model.getPulsesList().get(0).getPricePerKg());
		logger.info("Pulses Product Weight is :"+model.getPulsesList().get(0).getProductWeight());
		totalStockValue += model.getPulsesList().get(0).getPricePerKg()*model.getPulsesList().get(0).getProductWeight();
		
		logger.info("Company Name Of The Wheat is :" + model.getWheatsList().get(0).getProductName());
		logger.info("Price Of The Wheat Product Per Kg is :"+model.getWheatsList().get(0).getPricePerKg());
		logger.info("Wheat Product Weight is :"+model.getWheatsList().get(0).getProductWeight());
		totalStockValue += model.getWheatsList().get(0).getPricePerKg()*model.getWheatsList().get(0).getProductWeight();
		
		
		logger.info("Company Name Of The Rice is :" + model.getRiceList().get(0).getProductName());
		logger.info("Price Of The Rice Product Per Kg is :"+model.getRiceList().get(0).getPricePerKg());
		logger.info("Rice Product Weight is :"+model.getRiceList().get(0).getProductWeight());
		totalStockValue += model.getRiceList().get(0).getPricePerKg()*model.getWheatsList().get(0).getProductWeight();
		
		model.setTotalStockValue(totalStockValue);
		
		try {
			impl.saveInventoryDetails("InventoryDetailsReport.json", model);
		} catch (FileNotFoundException e) {
			logger.error(e);
		}
	}
	
}
