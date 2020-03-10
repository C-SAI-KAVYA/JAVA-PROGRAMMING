package com.bridgelabz.addressbook.serviceprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.model.PersonAddress;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.bridgelabz.addressbook.utils.InputUtility;
import com.bridgelabz.addressbook.utils.OutputUtility;

public class AddressBookServiceProviderImpl implements AddressBookService{
	Logger logger = Logger.getLogger(AddressBookServiceProviderImpl.class);
	
	int count = 0; 
	private final String filePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\static\\";
	private String saveFilePath = filePath;
	int indexOfPerson = 0;
	String search;
	String stateName;
	PersonAddress address = new PersonAddress();
	AddressBookModel model = new AddressBookModel();
	AddressBookRepository repo = new AddressBookRepository();
	
	static ArrayList<PersonDetails> personDetails = new ArrayList<>();
	
	@Override
	public void readJsonFile(){
		String initialFileName = "InitialAddressBook.json";
		String initialFilePath=filePath+initialFileName;
		File file = new File(initialFilePath);
		if(file.exists() && file.length() != 0) {
			try {
					model = (AddressBookModel) repo.readFromJSONFile(initialFilePath, AddressBookModel.class);
			} catch (ParseException|ClassNotFoundException e) {
				logger.error(e);
			}
			personDetails.addAll(model.getPersons());
			count = personDetails.size();
		}
	}
	
	@Override
	public void createNewAddressBook() throws FileNotFoundException {
		logger.info("---------------------New Address Book-----------------------------");
		logger.info("Enter a new file name for your address book with .json extension for example AddressBook.json");
		String fileName = InputUtility.stringVal();
		String createFilePath = filePath+fileName;
		
		if(new File(createFilePath).exists()) {
			throw new FileNotFoundException("Cannot re-write exsisting file");
		}
		openAddressBook(fileName);
		model.setPersons(personDetails);
		repo.writeToJSONFile(filePath, model);
		logger.info("---------------New File created with the name given and the details entered were also added successfully-----------------");	
	}

	@Override
	public void addNewPersonDetails() {
		logger.info("Add person details");
		PersonDetails person = new PersonDetails();
		
		logger.info("Enter person's ID");
		person.setPersonID(InputUtility.intVal());
		
		logger.info("Enter person's first name");
		person.setFirstName(InputUtility.stringVal());
		
		logger.info("Enter person's last name");
		person.setLastName(InputUtility.stringVal());
		
		logger.info("Enter person's mobile number");
		person.setMobile(InputUtility.longVal());
		
		logger.info("Enter person's local address");
		address.setLocalAddress(InputUtility.stringAllVal());
		InputUtility.stringVal();
		
		logger.info("Enter person's city");
		address.setCity(InputUtility.stringAllVal());
		InputUtility.stringVal();
		
		logger.info("Enter State name ");
		address.setState(InputUtility.stringVal());
		//InputUtility.stringVal();
		
		logger.info("Enter Zip");
		address.setZip(InputUtility.intVal());
		
		person.setAddress(address);
		
		personDetails.add(person);
		
		logger.info("Person details added successfully");
		saveAddressBook();
		count++;
		
	}

	@Override
	public void editPersonDetails() {
		if(count > 0) {
			logger.info("Enter Person ID whose details you want to edit");
			int id = InputUtility.intVal();
			indexOfPerson = 0;
			boolean personFound = false;
			
			for(int i=0; i<personDetails.size(); i++) {
				if(id == personDetails.get(i).getPersonID()) {
					personFound = true;
					indexOfPerson = i;
					break;
				}
			}
			
			if(personFound) {
				
				logger.info("Enter new mobile number");
				personDetails.get(indexOfPerson).setMobile(InputUtility.longVal());
				
				logger.info("Enter new Address");
				personDetails.get(indexOfPerson).getAddress().setLocalAddress(InputUtility.stringVal());
				
				logger.info("Enter new city name");
				personDetails.get(indexOfPerson).getAddress().setCity(InputUtility.stringVal());
				
				logger.info("Enter new Zip code");
				personDetails.get(indexOfPerson).getAddress().setZip(InputUtility.intVal());
				
				logger.info("Successfully Editted person with "+id+" details" );
				
			}else 
				logger.info("Person ID does not exsists in the address book");
		}else {
			logger.info("Address Book is empty");
		}
		
	}

	@Override
	public void deletePersonDetails() {
		if(count > 0) {
			logger.info("Enter persons ID you want to delete");
			int id = InputUtility.intVal();
			indexOfPerson = 0;
			boolean personFound = false;
			for(int i = 0; i <personDetails.size(); i++ ) {
				if(id == personDetails.get(i).getPersonID()) {
					personFound = true;
					indexOfPerson = i;
					break;
				}
			}
			
			if(personFound) {
				personDetails.remove(indexOfPerson);
				count--;
				OutputUtility.println();
				logger.info("Person Details with id "+id+" successfully deleted");
			}else
				logger.info("Id does not exsists");
		}else
			logger.info("Addressbook is empty");
	}

	@Override
	public void sortByFirstName() {
		if(count > 1) {
			personDetails.sort((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
			logger.info("Address book successfully sorted based on First Name");
		}else {
			logger.info("Required minimum two records to sort");
		}
	}

	@Override
	public void sortByLastName() {
		if(count > 1) {
			personDetails.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
			logger.info("Address book successfully sorted based on Last Name");
		}else {
			logger.info("Required minimum two records to sort");
		}		
	}

	@Override
	public void sortByZip() {
		if(count > 1) {
			personDetails.sort((p1, p2) -> String.valueOf(p1.getAddress().getZip()).compareTo(String.valueOf(p2.getAddress().getZip())));
			logger.info("Address book successfully sorted based on Zip");
		}else {
			logger.info("Required minimum two records to sort");
		}	
	}

	@Override
	public void openAddressBook(String openFileName) {
		String openFilePath = filePath+openFileName;
		saveFilePath = filePath+openFileName;
		logger.info("-----------------open address book-----------------");
			boolean close = false;
			
			while(!close) {
				logger.info("Choose an option what operation you would like to do with the address book");
				logger.info("\n1. Add Person Details\n2. Edit Address Book\n3. delete Person Details\n4. Sort The Address Book By First Name\n5. Sort The Address Book By Last Name\n6. Sort The Address Book By Zip\n7. Print The Address Book\n8. Close Address Book ");
				
				switch(InputUtility.intVal()) {
				case 1:
					//Adding Person Details
					addNewPersonDetails();
					break;
				case 2:
					//Editing Person Details
					editPersonDetails();
					break;
				case 3:
					//Delete Person Details
					deletePersonDetails();
					break;
				case 4:
					//Sort By First Name
					sortByFirstName();
					break;
				case 5:
					//Sort By Last Name
					sortByLastName();
					break;
				case 6:
					//Sort By Zip
					sortByZip();
					break;
				case 7:
					//Print the Address Book content
					printPersonDetails(openFilePath);
					break;
				case 8:
					//quit
					logger.info("Closing address book");
					close = true;
					logger.info("------------Successfully exited-------------");
					break;
				default:
					logger.info("Selected Invalid option");
				}
			}
		}

	@Override
	public void saveAddressBook() {
		logger.info(saveFilePath);
		logger.info("-------------------Save Address Book----------------");
		model.setPersons(personDetails);
		try {
			repo.writeToJSONFile(saveFilePath, model);
			logger.info("Writing into File successfull");	
		} catch (FileNotFoundException e) {
			logger.error(e);
		}
		
		
	}

	@Override
	public void saveAs() throws FileNotFoundException {
		
		logger.info("----------------------------Save As Address Book------------------------");
		logger.info("Required New File Path");
		logger.info("Enter y to continue or n ");
		
		if(InputUtility.charVal() == 'y') {
			String newFilePath = "F:\\BridgeLabzFellowship\\JavaProgrammingObjectOrientedProgramming\\";
			logger.info("Enter new File Name with .json extension example AddressBook.json");
			newFilePath+=InputUtility.stringVal();
			
			if(new File(newFilePath).exists()) {
				throw new FileNotFoundException("Cannot re-write exsisting file");
			}else {
				//wrting into file
				logger.info("-----------Saving address book into file------------");
				model.setPersons(personDetails);
				repo.writeToJSONFile(newFilePath, model);
				logger.info("Writing successfull");
			}
		}
	}
	
	public void printPersonDetails(String filePath) {
		logger.info(filePath);
		String content = InputUtility.readFileToString(filePath);
		logger.info("The File contains the following content");
		logger.info(content);
	}

}
