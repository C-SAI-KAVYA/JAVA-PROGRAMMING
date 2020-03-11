package com.bridgelabz.inventorymanagement.serviceprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.bridgelabz.inventorydetails.model.InventoryDetailsModel;
import com.bridgelabz.inventorydetails.repository.InventoryDetailsRepository;
import com.bridgelabz.inventorydetails.serviceprovider.InventoryDetailsServiceProviderImpl;
import com.bridgelabz.inventorymanagement.model.InventoryManagementModel;
import com.bridgelabz.inventorymanagement.model.PulseModel;
import com.bridgelabz.inventorymanagement.model.RiceModel;
import com.bridgelabz.inventorymanagement.model.WheatsModel;
import com.bridgelabz.inventorymanagement.utils.InputUtility;

public class InventoryManagementServiceProviderImpl implements InventoryManagementServiceProvider {

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
	public RiceModel addRice() {
		logger.info("--------------------------adding rice------------------------");
		RiceModel rice = new RiceModel();
		logger.info("Enter the name of the brand rice you want to add");
		String riceName = InputUtility.stringVal();
		logger.info("Enter the Price Per Kg of the rice");
		int pricePerKg = InputUtility.intVal();
		logger.info("Enter weight of the rice");
		double weight = InputUtility.doubleVal();
		double totalPriceOfWeight = weight * pricePerKg;

		rice.setProductName(riceName);
		rice.setPricePerKg(pricePerKg);
		rice.setProductWeight(weight);
		rice.setTotalPriceOfWeight(totalPriceOfWeight);

		return rice;
	}

	@Override
	public WheatsModel addWheat() {
		logger.info("--------------------------adding wheat------------------------");
		WheatsModel wheat = new WheatsModel();
		logger.info("Enter the name of the brand wheat you want to add");
		String wheatName = InputUtility.stringVal();
		logger.info("Enter the Pwheat Per Kg of the wheat");
		int pricePerKg = InputUtility.intVal();
		logger.info("Enter weight of the wheat");
		double weight = InputUtility.doubleVal();
		double totalPriceOfWeight = weight * pricePerKg;

		wheat.setProductName(wheatName);
		wheat.setPricePerKg(pricePerKg);
		wheat.setProductWeight(weight);
		wheat.setTotalPriceOfWeight(totalPriceOfWeight);

		return wheat;
	}

	@Override
	public PulseModel addPulses() {
		logger.info("--------------------------adding pulses------------------------");
		PulseModel pulses = new PulseModel();
		logger.info("Enter the name of the brand pulses you want to add");
		String pulsesName = InputUtility.stringVal();
		logger.info("Enter the Pulses Per Kg of the pulses");
		int pricePerKg = InputUtility.intVal();
		logger.info("Enter weight of the pulses");
		double weight = InputUtility.doubleVal();
		double totalPriceOfWeight = weight * pricePerKg;

		pulses.setProductName(pulsesName);
		pulses.setPricePerKg(pricePerKg);
		pulses.setProductWeight(weight);
		pulses.setTotalPriceOfWeight(totalPriceOfWeight);

		return pulses;
	}

	@Override
	public void saveRiceDetails(String fileName, List<RiceModel> list)
			throws FileNotFoundException {
		repo.writeToJSONFile(filePath + fileName, model);

	}
	
	@Override
	public void savePulseDetails(String fileName, PulseModel pulseModel)throws FileNotFoundException {
		repo.writeToJSONFile(filePath + fileName, model);

	}
	
	@Override
	public void saveWheatDetails(String fileName, WheatsModel wheatModel)throws FileNotFoundException {
		repo.writeToJSONFile(filePath + fileName, model);

	}

	@Override
	public void saveInventoryDetails(String fileName, InventoryManagementModel inventoryManagemetModel)throws FileNotFoundException {
		repo.writeToJSONFile(filePath + fileName, model);
	}

}
