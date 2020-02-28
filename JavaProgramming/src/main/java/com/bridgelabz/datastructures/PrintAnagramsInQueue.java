package com.bridgelabz.datastructure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.datastructures.utils.LogsUtility;
import com.bridgelabz.datastructures.utils.QueueList;
import com.bridgelabz.datastructures.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class PrintAnagramsInQueue {

	public static void main(String[] args) {
		LogsUtility.setLog("PrimeAnagramsInQueue");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH + "PrimeAnagramsInQueue.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("Prime Anagrams using Queue");
		
		try {
			int[] primes = Utility.primeNumbersRange(1000);
			QueueList<Integer> queue = new QueueList<>();
			for(int i=primes.length-1; i>0;i--) {
				queue.enqueue(primes[i]);
			}
			QueueList<Integer> queueOfAnagrams = Utility.primeAnagramsQueue(queue);
			//first reverse and then print
			queueOfAnagrams.display();
			
			} catch (ArrayIndexOutOfBoundsException | PrimeFactorsCannotBeFoundForZeroAndOneException e) {
			e.printStackTrace();
		}

	}

}
