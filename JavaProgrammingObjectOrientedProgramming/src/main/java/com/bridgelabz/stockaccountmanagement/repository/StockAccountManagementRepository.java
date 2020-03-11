package com.bridgelabz.stockaccountmanagement.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.google.gson.Gson;

public class StockAccountManagementRepository {
	Logger logger = Logger.getLogger(AddressBookRepository.class);

	/**
	 * used to write a object into the file
	 * 
	 * @param <T>
	 * @param filePath
	 * @param object
	 */
	public void writeToJSONFile(String filePath, Object object) throws FileNotFoundException {
		Gson gson = new Gson();
		try {
			logger.info("Writing JSON Object to file");
			String jsonObject = gson.toJson(object);
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.write(jsonObject);
			fileWriter.flush();
			fileWriter.close();
			logger.info("successfully written");
		} catch (IOException ioe) {
			logger.error(ioe);
		}
	}

	/**
	 * used to read text file content to string
	 * 
	 * @param fileNameWithPath
	 * @return
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object readFromJSONFile(String filePath, Class clazz) throws ClassNotFoundException, ParseException {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			Object o = gson.fromJson(br, clazz);
			logger.info("successfully read");
			return o;
		} catch (IOException ioe) {
			logger.error(ioe);
			return null;
		}
	}

}
