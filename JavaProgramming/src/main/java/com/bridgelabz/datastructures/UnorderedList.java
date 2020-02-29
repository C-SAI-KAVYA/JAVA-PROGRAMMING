package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LinkedList;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.OutputUtility;

public class UnorderedList {

	public static void main(String[] args) {
		//Setting up the loggers
		LogsUtility.setLog("UnorderedList");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "UnorderedList.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		//getting the file path
		logger.info("Unordered Linked List");
		String fileName = "F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\UnorderedList.txt";
		
		//reading the text file content to the list
		LinkedList<String> listOfStrings = new LinkedList<String>();
		listOfStrings = listOfStrings.textFileToStringLinkedList(fileName);
		listOfStrings.display();
		
		//taking the input from the user and checking whether it is present or no
		logger.info("Enter the String to check whether it is present or no and if not present it will be added");
		String userString = InputUtility.stringVal();
		boolean present = listOfStrings.checkNodeIsPresentOrNo(userString);
		logger.info(present);

		if (present) {
			listOfStrings.deleteAt(userString);// found so removing
			listOfStrings.display();
		} else {
			listOfStrings.insertAtEnd(userString);
			listOfStrings.display();
		}
		
		//writing back the modified linked list content to the file
		String modifiedContent = listOfStrings.linkedListToString(listOfStrings);
		OutputUtility.writeToFile(modifiedContent, fileName);

	}
}
