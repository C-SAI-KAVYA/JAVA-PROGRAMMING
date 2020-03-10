package com.bridgelabz.addressbook.controller;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.addressbook.serviceprovider.AddressBookServiceProviderImpl;
import com.bridgelabz.addressbook.utils.InputUtility;
import com.bridgelabz.addressbook.utils.LogsUtility;

public class AddressBookController {
	
	public static void main(String[] args) {
		LogsUtility.setLog("AddressBookController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"AddressBookController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		
		AddressBookServiceProviderImpl impl = new AddressBookServiceProviderImpl();
		boolean exitFromMenu = false;
		impl.readJsonFile();
		
		logger.info("Welcome to Address Book Controller Panel");
		
		logger.info("Select what you want to do from the following");
		while(!exitFromMenu) {
		logger.info("\n1. Create New Address Book\n2. Open Exsisting Address Book\n3. Save Address Book\n4. SaveAs Address Book\n5. Quit");
			switch(InputUtility.intVal()) {
			case 1:
				//new address book
				try {
					impl.createNewAddressBook();
				} catch (FileNotFoundException e1) {
					logger.info(e1);
				}
				break;
			case 2:
				//open address book
				logger.info("Enter the file name with .json extension which you want to open for example AddressBook.json");
				String fileName = InputUtility.stringVal();
				impl.openAddressBook(fileName);
				break;
			case 3:
				//save address book
				impl.saveAddressBook();
				break;
			case 4:
				//save as address book
				try {
					impl.saveAs();
				} catch (FileNotFoundException e) {
					logger.info(e);
				}
				break;
			case 5:
				//quit
				logger.info("Quiting from address book");
				exitFromMenu = true;
				logger.info("------------Successfully exited-------------");
				break;
			default:
				logger.info("Selected Option does not exsists");
				break;
			}
		}
	}

}
