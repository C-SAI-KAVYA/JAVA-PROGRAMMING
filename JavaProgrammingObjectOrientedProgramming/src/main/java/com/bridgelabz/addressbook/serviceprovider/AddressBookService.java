package com.bridgelabz.addressbook.serviceprovider;

import java.io.FileNotFoundException;

public interface AddressBookService {
	
	public void readJsonFile();
	public void createNewAddressBook() throws FileNotFoundException;
	public void addNewPersonDetails();
	public void editPersonDetails();
	public void deletePersonDetails();
	public void sortByFirstName();
	public void sortByLastName();
	public void sortByZip();
	public void openAddressBook(String fileName);
	public void saveAddressBook();
	public void saveAs() throws FileNotFoundException;
	
}
