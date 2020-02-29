package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.algorithmprograms.utils.OutputUtility;
import com.bridgelabz.datastructures.utils.HashMap;
import com.bridgelabz.datastructures.utils.InputUtility;
import com.bridgelabz.datastructures.utils.LinkedList;
import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.Utility;

public class HashingFunctionForSlots {

	public static void main(String[] args) {
		
		LogsUtility.setLog("HashingFunctionForSlots");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "HashingFunctionForSlots.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Hashing Function to Find Slots for the Numbers entered");
		String fileName = "F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\HashingFunction.txt";
		
		String values = InputUtility.readFileToString(fileName);
		
		Integer[] intArray = InputUtility.stringToIntArray(values);
		
		HashMap<Integer, LinkedList<Integer>> hashmap = new HashMap<>(intArray.length);
		
		Integer[] slots = Utility.hashingFunctionForSlot(intArray);
		
		OutputUtility.print1DIntegerArray(slots);
		
		OutputUtility.print1DIntegerArray(intArray);
			
		for(int i=0;i<intArray.length;i++) {
			if(hashmap.containsKey(slots[i])) {
				LinkedList<Integer> val = new LinkedList<>();
					val = hashmap.get(slots[i]);
					val.insert(intArray[i]);
					hashmap.put(slots[i], val);
				}else {
					LinkedList<Integer> list = new LinkedList<>();
					list.insert(intArray[i]);
					hashmap.put(slots[i], list);
				}
		}
		hashmap.display();
	}
}
