package com.bridgelabz.inventorydetails.serviceprovider;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.bridgelabz.inventorydetails.model.InventoryDetailsModel;
import com.bridgelabz.inventorydetails.repository.InventoryDetailsRepository;

public class InventoryDetailsServiceProviderImpl implements InventoryDetailsServiceProvider {

	Logger logger = Logger.getLogger(InventoryDetailsServiceProviderImpl.class);
	private final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\staticjson\\";
	InventoryDetailsModel model = new InventoryDetailsModel();
	InventoryDetailsRepository repo = new InventoryDetailsRepository();
	String inventoryDetailsFileName = "InventoryDetailsData.json";
	
	@Override
	public InventoryDetailsModel readInventoryDetailsInfoFromJSONFile() {
		String initialFilePath = filePath + inventoryDetailsFileName;
		logger.info("Company shares model" + (filePath + inventoryDetailsFileName));
		File file = new File(initialFilePath);
		if (file.exists() && file.length() != 0) {
			try {
				model = (InventoryDetailsModel) repo.readFromJSONFile(initialFilePath, InventoryDetailsModel.class);
				logger.info("Successfully read Company Shares details");
			} catch (ParseException | ClassNotFoundException e) {
				logger.error(e);
			}

		}
		return model;
	}
	@Override
	public void saveInventoryDetails(String fileName, InventoryDetailsModel inventoryDetailsModel)
			throws FileNotFoundException {
		repo.writeToJSONFile(filePath + fileName, model);
		
	}
	
	
}
