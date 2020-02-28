package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.basicprogramming.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LinkedList;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.OutputUtility;

public class OrderedList {
	
	public OrderedList() {
		
	}

	public static void main(String[] args) {
		LogsUtility.setLog("OrderedList");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "OrderedList.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Ordered Linked List");
		LinkedList<Integer> listOfIntegers = new LinkedList<Integer>();
		String fileName = "F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\OrderedList.txt";
		
		//reading from a file and storing inside the linked list
		logger.info("reading the text from the file");
		listOfIntegers = listOfIntegers.textFileToIntLinkedList(fileName);
		listOfIntegers.display();
		
		//sorting the linked list in ascending order
		logger.info("sorting the read data");
		listOfIntegers.sortLinkedList(listOfIntegers.length());
		listOfIntegers.display();
		
		//Taking the user input
		logger.info("Enter the integer to check whether it is present in the list or no");
		Integer userInt = InputUtility.intVal();
		boolean present = listOfIntegers.checkNodeIsPresentOrNo(userInt);
		
		//checking whether present or no
		if(present) {
			logger.info("present so popping it out from the list");
			listOfIntegers.deleteAt(userInt);
			listOfIntegers.display();
		}// if present then delete and print the list
		else {
			logger.info("Not present so pushing it to the list");
			listOfIntegers.insert(userInt);
			listOfIntegers.display();
		}// if not present then add and print the list
		
		//writing the linked list content back to the file
		String modifiedContent = listOfIntegers.linkedListToString();
		logger.info(modifiedContent);
		OutputUtility.writeToFile(modifiedContent, fileName);
	}

}
