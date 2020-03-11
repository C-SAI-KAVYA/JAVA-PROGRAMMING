package com.bridgelabz.stockaccountmanagement.serviceprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.utils.InputUtility;
import com.bridgelabz.stockaccountmanagement.model.DairyMilk;
import com.bridgelabz.stockaccountmanagement.model.KitKat;
import com.bridgelabz.stockaccountmanagement.model.MilkyBar;
import com.bridgelabz.stockaccountmanagement.model.PikNik;
import com.bridgelabz.stockaccountmanagement.model.StockAccountManagementModel;
import com.bridgelabz.stockaccountmanagement.repository.StockAccountManagementRepository;

public class StockAccountManagementServiceProviderImpl implements StockAccountManagementServiceProvider {
	Logger logger = Logger.getLogger(StockAccountManagementServiceProviderImpl.class);
	private final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\staticjson\\";
	StockAccountManagementModel model = new StockAccountManagementModel();
	StockAccountManagementRepository repo = new StockAccountManagementRepository();
	static ArrayList<DairyMilk> dairyMilkStockDetails = new ArrayList<>();
	static ArrayList<MilkyBar> milkyBarStockDetails = new ArrayList<>();
	static ArrayList<KitKat> kitKatStockDetails = new ArrayList<>();
	static ArrayList<PikNik> pikNikStockDetails = new ArrayList<>();
	int dairyMilkcount = 0;
	int milkyBarcount = 0;
	int kitKatcount = 0;
	int pikNikcount = 0;

	@Override
	public StockAccountManagementModel readJsonFile() {
		logger.info("Enter file name with .json extension that consists of stock details");
		String initialFileName = InputUtility.stringVal();
		String initialFilePath = filePath + initialFileName;
		File file = new File(initialFilePath);
		if (file.exists() && file.length() != 0) {
			try {
				model = (StockAccountManagementModel) repo.readFromJSONFile(initialFilePath,
						StockAccountManagementModel.class);
				logger.info("Successfully read");
			} catch (ParseException | ClassNotFoundException e) {
				logger.error(e);
			}

			dairyMilkStockDetails.addAll(model.getDairyMilk());
			milkyBarStockDetails.addAll(model.getMilkyBar());
			kitKatStockDetails.addAll(model.getKitKat());
			pikNikStockDetails.addAll(model.getPikNik());

			dairyMilkcount = dairyMilkStockDetails.size();
			milkyBarcount = milkyBarStockDetails.size();
			kitKatcount = kitKatStockDetails.size();
			pikNikcount = pikNikStockDetails.size();

		}
		return model;
	}

	@Override
	public double calculateTotalValueOfStock(int numberOfShares, double sharePrices) {
		return numberOfShares * sharePrices;
	}

	@Override
	public double getTotalValueOfDairyMilk(int numberOfShares, double sharePrices) {
		return calculateTotalValueOfStock(numberOfShares, sharePrices);
	}

	@Override
	public double getTotalValueOfMilkyBar(int numberOfShares, double sharePrices) {
		return calculateTotalValueOfStock(numberOfShares, sharePrices);
	}

	@Override
	public double getTotalValueOfKitKat(int numberOfShares, double sharePrices) {
		return calculateTotalValueOfStock(numberOfShares, sharePrices);
	}

	@Override
	public double getTotalValueOfPikNik(int numberOfShares, double sharePrices) {
		return calculateTotalValueOfStock(numberOfShares, sharePrices);
	}

	@Override
	public double getTotalValueOfAllStocks(double totalDairyMilk, double totalMilkyBar, double totalKitKat, double totalPikNik) {
		return totalDairyMilk+totalMilkyBar+totalKitKat+totalPikNik;
	}

	@Override
	public void writeIntoJSON(Object obj) throws FileNotFoundException {
		logger.info("Enter the file Name with .json extension in which you want to store the stock details");
		String fileName = InputUtility.stringVal();
		String writingFilePath = filePath+fileName;
		repo.writeToJSONFile(writingFilePath, obj);
		logger.info("Successfully written");
		
	}

}
