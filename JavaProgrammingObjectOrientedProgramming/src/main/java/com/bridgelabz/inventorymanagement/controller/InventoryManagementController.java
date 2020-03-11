package com.bridgelabz.inventorymanagement.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.inventorymanagement.model.InventoryManagementModel;
import com.bridgelabz.inventorymanagement.model.PulseModel;
import com.bridgelabz.inventorymanagement.model.RiceModel;
import com.bridgelabz.inventorymanagement.model.WheatsModel;
import com.bridgelabz.inventorymanagement.repository.InventoryManagementRepository;
import com.bridgelabz.inventorymanagement.serviceprovider.InventoryManagementServiceProviderImpl;
import com.bridgelabz.inventorymanagement.utils.InputUtility;
import com.bridgelabz.inventorymanagement.utils.LogsUtility;

public class InventoryManagementController {
	
	public static void main(String[] args) {
		LogsUtility.setLog("InventoryDetailsController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "InventoryDetailsController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("-----------------------Inventory Management---------------------------");
		
		boolean exit = false;
		double totalValueOfCompleteInventory = 0;
		InventoryManagementModel model = new InventoryManagementModel();
		InventoryManagementServiceProviderImpl impl = new InventoryManagementServiceProviderImpl();
		InventoryManagementRepository repo = new InventoryManagementRepository();
		final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\staticjson\\";
		
		RiceModel rice = new RiceModel();
		PulseModel pulse = new PulseModel();
		WheatsModel wheats = new WheatsModel();
		
		List<RiceModel> riceList = new ArrayList<>();
		List<PulseModel> pulseList = new ArrayList<>();
		List<WheatsModel> wheatsList = new ArrayList<>();
		
		while(!exit) {
			logger.info("Choose from the following");
			logger.info("\n1. add rice\n2. add pulses\n3. add wheats\n4. exit");
			
			switch(InputUtility.intVal()) {
				case 1:
					logger.info("--------------Adding rice procedure started-----------------------");
					rice = impl.addRice();
					totalValueOfCompleteInventory += rice.getTotalPriceOfWeight();
					logger.info(totalValueOfCompleteInventory);
					model.setTotalStockValue(totalValueOfCompleteInventory);
					riceList.add(rice);
					model.setRiceList(riceList);
					try {
						repo.writeToJSONFile(filePath+"InventoryManagementReport.json", model);
					} catch (FileNotFoundException e) {
						logger.error(e);
					}
					break;
				case 2:
					logger.info("--------------Adding wheat procedure started-----------------------");
					wheats = impl.addWheat();
					totalValueOfCompleteInventory += wheats.getTotalPriceOfWeight();
					wheatsList.add(wheats);
					model.setWheatsList(wheatsList);
					model.setTotalStockValue(totalValueOfCompleteInventory);
					try {
						repo.writeToJSONFile(filePath+"InventoryManagementReport.json", model);
					} catch (FileNotFoundException e) {
						logger.error(e);
					}
					break;
				case 3:
					logger.info("--------------Adding pulse procedure started-----------------------");
					pulse = impl.addPulses();
					totalValueOfCompleteInventory += pulse.getTotalPriceOfWeight();
					pulseList.add(pulse);
					model.setPulsesList(pulseList);
					model.setTotalStockValue(totalValueOfCompleteInventory);
					try {
						repo.writeToJSONFile(filePath+"InventoryManagementReport.json", model);
					} catch (FileNotFoundException e) {
						logger.error(e);
					}
					break;		
				case 4:
					exit = true;
					logger.info("-----------------------Successfully exited--------------------------");
					break;
				default:
					logger.info("Invalid choice");
					
			}
		}
	}

}
