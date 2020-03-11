package com.bridgelabz.stockaccount.serviceprovider;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bridgelabz.addressbook.utils.OutputUtility;
import com.bridgelabz.stockaccount.model.CompanyShares;
import com.bridgelabz.stockaccount.model.CompanySharesModel;
import com.bridgelabz.stockaccount.model.CustomerInformation;
import com.bridgelabz.stockaccount.model.CustomerInformationModel;
import com.bridgelabz.stockaccount.model.Transaction;
import com.bridgelabz.stockaccount.model.TransactionModel;
import com.bridgelabz.stockaccount.repository.StockAccountRepository;
import com.bridgelabz.stockaccount.utils.InputUtility;

public class StockAccountServiceProviderImpl implements StockAccountServiceProvider {
	Logger logger = Logger.getLogger(StockAccountServiceProviderImpl.class);
	private final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\staticjson\\";

	CompanySharesModel companyModel = new CompanySharesModel();
	CustomerInformationModel customerModel = new CustomerInformationModel();
	TransactionModel transactionModel = new TransactionModel();

	StockAccountRepository repo = new StockAccountRepository();

	boolean companyPresent = false;
	boolean companyPresent2 = false;
	boolean valueExsists = false;
	int indexOfCompany = 0;
	int indexOfTransaction = 0;
	double customerBalance = 0;
	String companySymbol = "";
	
	String companyFileName = "CompanySharesInformation.json";
	String customerFileName = "CustomerInformation.json";
	String transactionFileName = "TransactionInformation.json";
	
	List<CompanyShares> companyList = new ArrayList<>();
	List<CustomerInformation> customerList = new ArrayList<>();
	List<Transaction> transactionList = new ArrayList<>();
	
	
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HHmmss");
	
	@Override
	public void readCompanyInfoFromJSONFile() {
		String initialFilePath = filePath + companyFileName;
			companyModel = (CompanySharesModel) repo.readFromJSONFile(initialFilePath, CompanySharesModel.class);
		companyList.addAll(companyModel.getCompanySharesInformation());
		logger.info(companyList);
		logger.info("Successfully read company details");
	}
	
	@Override
	public void readCustomerInfoFromJSONFile() {
		String initialFilePath = filePath + customerFileName;
			customerModel = (CustomerInformationModel) repo.readFromJSONFile(initialFilePath, CustomerInformationModel.class);
		customerList.addAll(customerModel.getCustomerInformation());
		logger.info(customerList);
		logger.info("Successfully read customer details");
	}

	@Override
	public void readTransactionInfoFromJSONFile() {
		String initialFilePath = filePath + transactionFileName;
			transactionModel = (TransactionModel) repo.readFromJSONFile(initialFilePath, TransactionModel.class);
			logger.info(transactionList);
		logger.info("Successfully read transaction details");
	}
	@Override
	public int buyShares(int numberOfSharesToBuy, int indexOfCustomer) {
		logger.info("--------------Buying Shares Process Started------------------");
		logger.info("please enter company symbol for example TCS");
		companySymbol = InputUtility.stringVal();

		logger.info("--------------Validating company-----------------");
		logger.info(companyList.size());
		for (int i = 0; i < companyList.size(); i++) {
			String symbol = companyList.get(i).getCompanySymbol();
			if (companySymbol.equals(symbol)) {
				logger.info("Company found");
				companyPresent = true;
				indexOfCompany = i;
				break;
			}
		}
		logger.info("The company you selected is : " + companyList.get(indexOfCompany).getCompanyName());
		logger.info("Company Shares are : " + companyList.get(indexOfCompany).getCompanyShares());
		logger.info("Company share prices : " + companyList.get(indexOfCompany).getCompanySharePrices());
		customerBalance = customerList.get(indexOfCustomer).getCustomerBalance();

		if (companyPresent) {
			OutputUtility.println();
			// Checking whether customer has sufficient balance or no
			if (numberOfSharesToBuy < companyList.get(indexOfCompany).getCompanyShares()) {
				if (customerBalance > (numberOfSharesToBuy * companyList.get(indexOfCompany).getCompanySharePrices())) {
					int newCustomerBalance = (int) (customerBalance - numberOfSharesToBuy * companyList.get(indexOfCompany).getCompanySharePrices());
					
					
					companyList.get(indexOfCompany).setCompanyShares(companyList.get(indexOfCompany).getCompanyShares() - numberOfSharesToBuy);
					companyList.get(indexOfCompany).setCompanyTotalSharePriceValue(companyList.get(indexOfCompany).getCompanySharePrices()* companyList.get(indexOfCompany).getCompanyShares());
					customerList.get(indexOfCustomer).setCustomerBalance(newCustomerBalance);
					customerList.get(indexOfCustomer).setCustomerShares(customerList.get(indexOfCustomer).getCustomerShares() + numberOfSharesToBuy);
					
					
					companyModel.setCompanySharesInformation(companyList);
					customerModel.setCustomerInformation(customerList);
					
					
					try {
						repo.writeToJSONFile(filePath + companyFileName, companyModel);
						repo.writeToJSONFile(filePath + customerFileName, customerModel);
						String transactionID = dateTimeFormatter2.format(now)+customerList.get(indexOfCustomer).getCustomerSymbol()+companyList.get(indexOfCompany).getCompanySymbol();
						Transaction transaction = new Transaction();
						transaction.setTransactionID(transactionID);
						transaction.setSharesBuyerName(customerList.get(indexOfCustomer).getCustomerName());
						transaction.setSharesSellerName(companyList.get(indexOfCompany).getCompanyName());
						transaction.setTransactionAmount(numberOfSharesToBuy * companyList.get(indexOfCompany).getCompanySharePrices());
						transaction.setDateAndTimeOfTransaction(dateTimeFormatter.format(now));
						transactionList.add(transaction);
						transactionModel.setTransactionInformation(transactionList);
						repo.writeToJSONFile(filePath+transactionFileName, transactionModel);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					return newCustomerBalance;
				} else
					logger.info("Sufficient Balance not available");
				return 0;
			} else
				logger.info("Company does not have that many shares");
			return 0;
		} else
			logger.info("Company could not be identified please try with different company symbol");
		return 0;
	}

	@Override
	public int sellShares(int sharesToBeSold, int indexOfCustomer) {
		logger.info("--------------------Sell Share Prices------------------------");
		logger.info("please enter company symbol to whom you want to sell: ");
		companySymbol = InputUtility.stringVal();

		logger.info("-------------------------Validating-----------------------------");
		logger.info("--------------Validating company-----------------");
		for (int i = 0; i < companyList.size(); i++) {
			if (companySymbol.equals(companyList.get(i).getCompanySymbol())) {
				companyPresent2 = true;
				indexOfCompany = i;
			}
		}
		if (companyPresent2) {
			logger.info(
					"----------------------Details of the company to which the shares are being selled---------------------");
			logger.info("The company you selected is: " + companyList.get(indexOfCompany).getCompanyName());
			logger.info("number of company shares are : " + companyList.get(indexOfCompany).getCompanyShares());
			logger.info(
					"The company share price value is : " + companyList.get(indexOfCompany).getCompanySharePrices());
			int newBalance = sharesToBeSold * companyList.get(indexOfCompany).getCompanySharePrices();
			
			
			companyList.get(indexOfCompany).setCompanyShares(companyList.get(indexOfCompany).getCompanyShares() + sharesToBeSold);
			companyList.get(indexOfCompany).setCompanyTotalSharePriceValue(companyList.get(indexOfCompany).getCompanySharePrices()* companyList.get(indexOfCompany).getCompanyShares());
			customerList.get(indexOfCustomer).setCustomerBalance(newBalance);
			customerList.get(indexOfCustomer).setCustomerShares(customerList.get(indexOfCustomer).getCustomerShares() + sharesToBeSold);
			
			companyModel.setCompanySharesInformation(companyList);
			customerModel.setCustomerInformation(customerList);
			
			try {
				repo.writeToJSONFile(filePath + companyFileName, companyModel);
				repo.writeToJSONFile(filePath + customerFileName, customerModel);
				String transactionID = dateTimeFormatter2.format(now)+customerList.get(indexOfCustomer).getCustomerSymbol()+companyList.get(indexOfCompany).getCompanySymbol();
				Transaction transaction = new Transaction();
				transaction.setTransactionID(transactionID);
				transaction.setSharesBuyerName(companyList.get(indexOfCompany).getCompanyName());
				transaction.setSharesSellerName(customerList.get(indexOfCustomer).getCustomerName());
				transaction.setTransactionAmount(sharesToBeSold * companyList.get(indexOfCompany).getCompanySharePrices());
				transaction.setDateAndTimeOfTransaction(dateTimeFormatter.format(now));
				transactionList.add(transaction);
				transactionModel.setTransactionInformation(transactionList);
				repo.writeToJSONFile(filePath+transactionFileName, transactionModel);	
			} catch (FileNotFoundException e1) {
				logger.error(e1);
			}
			return newBalance;
		} else
			return 0;// returns the amount obtained by selling shares
	}

	@Override
	public void saveTransactionDetails(String fileName) throws FileNotFoundException {
		repo.writeToJSONFile(filePath + fileName, transactionModel);
	}

	@Override
	public void printReport(int customerID) {
		logger.info(
				"--------------------------------Printing procedure started---------------------------------------------");
		logger.info("Enter file name");
		String fileName = InputUtility.stringVal();
		String content = InputUtility.readFileToString(filePath + fileName);
		logger.info(content);
		logger.info("--------------------------Successfully printed------------------------");
	}

}
