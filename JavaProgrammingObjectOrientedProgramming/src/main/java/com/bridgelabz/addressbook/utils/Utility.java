package com.bridgelabz.addressbook.utils;

import java.util.List;

public class Utility {
	
	private Utility() {
		
	}
	
	// Generic Bubble Sort in ascending order for wrapper class datatypes like Integer Character String 
		/**
		 * This method performs bubble sort on the array of type generic (can be used
		 * for any primitive type)
		 * 
		 * @param array
		 * @return Sorted values of "T" type array
		 * @throws CustomizedException
		 */
		public static <T extends Comparable<T>> List<T> genericBubbleSortA(List<T> array){
			T temp;
			if (array.size() > 1) {
				// taking each value in the array
				for (int i = 0; i < array.size(); i++) {
					// taking values from "1" to "length-i"
					for (int j = i + 1; j < array.size(); j++) {
						// if numbers[j] > numbers[j+1], swap the elements
						if (array.get(i).compareTo(array.get(j)) > 0) {
							temp = array.get(j);
							array.set(j, array.get(i));
							array.set(i, temp);
						}
					}
				}
			} 
			return array;
		}

}
