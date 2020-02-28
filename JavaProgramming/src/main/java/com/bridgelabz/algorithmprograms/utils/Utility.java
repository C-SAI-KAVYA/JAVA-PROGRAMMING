package com.bridgelabz.algorithmprograms.utils;//source of the file

//important libraries needed
import java.io.BufferedReader;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import com.bridgelabz.exceptions.ArrayLengthDoesNotSatisfyTheRequiredLengthException;
import com.bridgelabz.exceptions.CannotCheckAnagramForEmptyStringException;
import com.bridgelabz.exceptions.InvalidIntegerException;
import com.bridgelabz.exceptions.PermutationsCannotBeFoundForNullOrZeroCharacterisedString;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;
import com.bridgelabz.exceptions.SelectedStringDoesNotExsistsException;

public class Utility {

	public Utility() {
	}
	static Logger logger = Logger.getLogger("Utility.class");

	// StringPermutations
	/**
	 * iterative Method To find permutations
	 * 
	 * @param s
	 * @return
	 * @throws PermutationsCannotBeFoundForNullOrZeroCharacterisedString 
	 */
	public static List<String> iterativePermutations(String s) throws PermutationsCannotBeFoundForNullOrZeroCharacterisedString {
		
		if(s.length() == 0 || s.length() ==1) {
			throw new PermutationsCannotBeFoundForNullOrZeroCharacterisedString("please enter a string of minimum two characters");
		}
		else {
			// create an empty ArrayList to store permutations
			List<String> iterative = new ArrayList<>();
	
			// initialize the list with the first character of the string
			iterative.add(String.valueOf(s.charAt(0)));
	
			// do for every character of the specified string
			for (int i = 1; i < s.length(); i++) {
				// consider previously constructed partial permutation one by one
	
				// (iterate backwards to avoid ConcurrentModificationException)
				for (int j = iterative.size() - 1; j >= 0; j--) {
					// remove current partial permutation from the ArrayList
					String str = iterative.remove(j);
	
					// Insert next character of the specified string in all
					// possible positions of current partial permutation. Then
					// insert each of these newly constructed string in the list
	
					for (int k = 0; k <= str.length(); k++) {
						// Advice: use StringBuilder for concatenation
						iterative.add(str.substring(0, k) + s.charAt(i) + str.substring(k));
					}
				}
			}
	
			return iterative;
		}
	}

	// recursive method
	/**
	 * recursive method to find permutations
	 * 
	 * @param temp
	 * @param str
	 * @return
	 */
	public static String[] recursivePermutations(String temp, String str) {
		if (str.length() == 0) {
			OutputUtility.println(temp);
		}
		String[] arr = new String[7];
		for (int i = 0; i < str.length(); i++) {
			String newTemp = temp + str.charAt(i);

			String newStr = str.substring(0, i) + str.substring(i + 1);
			arr[i] = newTemp + newStr;
			recursivePermutations(newTemp, newStr);
		}
		return arr;
	}

	// Check whether iterative and recursive are equal or no
	/**
	 * this method is used to check whether the permutations generated using
	 * iterative and recursive are equal or no
	 * 
	 * @param listOfIterativePermutations
	 * @param arrayOfRecursivePermutations
	 * @return
	 */
	public static boolean checkIterativeAndRecursivePermutationEquals(List<String> listOfIterativePermutations, String[] arrayOfRecursivePermutations) {
		boolean equals = false;
		for (int i = 0; i < listOfIterativePermutations.size(); i++) {
			for (int j = i; j <= listOfIterativePermutations.size(); j++) {
				if (listOfIterativePermutations.get(i).equals(arrayOfRecursivePermutations[j])) {
					equals = true;
				}
			}
		}
		return equals;
	}

	// Binary Word Search
	/**
	 * Binary search for a required word in string
	 * 
	 * @param key
	 * @param a
	 * @return
	 * @throws SelectedStringDoesNotExsistsException
	 */
	// return the index of the key in the sorted array a[]; -1 if not found
	public static int binaryWordsearch(String key, String[] a) throws SelectedStringDoesNotExsistsException {
		if ("".equals(key) || a.length <= 0) {
			throw new SelectedStringDoesNotExsistsException(
					"Key cannot be null or string does not exsists in which you want to search");
		}
		return binaryWordsearch(key, a, 0, a.length);
	}

	/**
	 * Binary word search with low and high index values
	 * 
	 * @param key
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int binaryWordsearch(String key, String[] a, int lo, int hi) {
		if (hi <= lo)
			return -1;
		int mid = lo + (hi - lo) / 2;
		int cmp = a[mid].compareTo(key);
		if (cmp > 0)
			return binaryWordsearch(key, a, lo, mid);
		else if (cmp < 0)
			return binaryWordsearch(key, a, mid + 1, hi);
		else
			return mid;
	}

	// Generic Binary Search for wrapper class datatypes like Integer Character String 
	/**
	 * This method performs binary search on the array of type generic (can be used
	 * for any primitive type)
	 * 
	 * @param words
	 * @param key
	 * @return position of the word in an Array if it is found else "-1" will be
	 *         returned
	 * @throws CustomizedException
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] words, T key)
			throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		int low = 0;
		int high = words.length - 1;
		int mid;
		if (words.length > 1) {
			// checking until high value crosses the low value
			while (low <= high) {
				mid = (low + high) / 2;
				// if key word is found at mid returning mid value
				if (words[mid].compareTo(key) == 0)
					return mid;
				// if word at mid is less than key word,move the low to "mid+1" position
				else if (key.compareTo(words[mid]) < 0)
					high = mid - 1;
				else // if it is higher than key word,move the high to mid-1 position
					low = mid + 1;
			}
			return -1; // if it is not found returning "-1"
		} else {
			throw new ArrayLengthDoesNotSatisfyTheRequiredLengthException(
					"Enter atleast two inputs in order to searching");
		}
	}

	// Insertion Sort in ascending order only for strings
	/**
	 * This method is used to perform insertion sort on String array
	 * 
	 * @param array
	 * @return
	 */
	public static String[] insertionSortA(String array[]) {
		int f = array.length;
		String temp = "";
		for (int i = 0; i < f; i++) {
			for (int j = i + 1; j < f; j++) {
				if (array[i].compareToIgnoreCase(array[j]) > 0) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	// Generic Insertion Sort in ascending order for wrapper class datatypes like Integer Character String 
	/**
	 * This method performs Insertion sort on the array of type generic (can be used
	 * for any primitive type)
	 * 
	 * @param words
	 * @return Sorted array of given type
	 * @throws ArrayLengthDoesNotSatisfyTheRequiredLengthException
	 */
	public static <T extends Comparable<T>> T[] genericInsertionSortA(T[] words)
			throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		if (words.length > 1) {
			// start at the first index and iterate through to the end
			for (int i = 1; i < words.length; i++) {
				int currentIndex = i;
				// Check: 1. that currentIndex is at least 1 2. that the item directly before
				// the currentIndex is greater than the item at currentIndex
				// If both conditions are met, swap the indexes
				while (currentIndex > 0 && words[currentIndex - 1].compareTo(words[currentIndex]) > 0) {
					T temp = words[currentIndex];
					words[currentIndex] = words[currentIndex - 1];
					words[currentIndex - 1] = temp;
					currentIndex--;
				}
			}
			return words;
		} else {
			throw new ArrayLengthDoesNotSatisfyTheRequiredLengthException("Enter atleast two inputs in order to sort");
		}
	}
	// Insertion Sort in descending order only for String type
		/**
		 * This method is used to perform insertion sort on String array
		 * 
		 * @param array
		 * @return
		 */
		public static String[] insertionSortD(String array[]) {
			int f = array.length;
			String temp = "";
			for (int i = 0; i < f; i++) {
				for (int j = i + 1; j < f; j++) {
					if (array[i].compareToIgnoreCase(array[j]) < 0) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
			return array;
		}

		// Generic Insertion Sort descending order for wrapper class datatypes like Integer Character String 
		/**
		 * This method performs Insertion sort on the array of type generic (can be used
		 * for any primitive type)
		 * 
		 * @param words
		 * @return Sorted array of given type
		 * @throws ArrayLengthDoesNotSatisfyTheRequiredLengthException
		 */
		public static <T extends Comparable<T>> T[] genericInsertionSortD(T[] words)
				throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
			if (words.length > 1) {
				// start at the first index and iterate through to the end
				for (int i = 1; i < words.length; i++) {
					int currentIndex = i;
					// Check: 1. that currentIndex is at least 1 2. that the item directly before
					// the currentIndex is greater than the item at currentIndex
					// If both conditions are met, swap the indexes
					while (currentIndex > 0 && words[currentIndex - 1].compareTo(words[currentIndex]) < 0) {
						T temp = words[currentIndex];
						words[currentIndex] = words[currentIndex - 1];
						words[currentIndex - 1] = temp;
						currentIndex--;
					}
				}
				return words;
			} else {
				throw new ArrayLengthDoesNotSatisfyTheRequiredLengthException("Enter atleast two inputs in order to sort");
			}
		}

	// Bubble sort in ascending order only for int type
	/**
	 * This method performs bubble sort on array of type only integer
	 * 
	 * @param unsortedArray
	 * @return
	 */
	public static int[] bubbleSortA(int[] unsortedArray) {
		int n = unsortedArray.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (unsortedArray[j - 1] > unsortedArray[j]) {
					// swap elements
					temp = unsortedArray[j - 1];
					unsortedArray[j - 1] = unsortedArray[j];
					unsortedArray[j] = temp;
				}
			}
		}
		return unsortedArray;
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
	public static <T extends Comparable<T>> T[] genericBubbleSortA(T[] array)
			throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		T temp;
		if (array.length > 1) {
			// taking each value in the array
			for (int i = 0; i < array.length; i++) {
				// taking values from "1" to "length-i"
				for (int j = i + 1; j < array.length; j++) {
					// if numbers[j] > numbers[j+1], swap the elements
					if (array[i].compareTo(array[j]) > 0) {
						temp = array[j];
						array[j] = array[i];
						array[i] = temp;
					}
				}
			}
			return array;
		} else {
			throw new ArrayLengthDoesNotSatisfyTheRequiredLengthException("Enter atleast two inputs in order to sort");
		}
	}
	
	// Bubble sort in descending order only for int type
		/**
		 * This method performs bubble sort on array of type only integer
		 * 
		 * @param unsortedArray
		 * @return
		 */
		public static int[] bubbleSortD(int[] unsortedArray) {
			int n = unsortedArray.length;
			int temp = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (unsortedArray[j - 1] < unsortedArray[j]) {
						// swap elements
						temp = unsortedArray[j - 1];
						unsortedArray[j - 1] = unsortedArray[j];
						unsortedArray[j] = temp;
					}
				}
			}
			return unsortedArray;
		}

		// Generic Bubble Sort for wrapper class datatypes like Integer Character String 
		/**
		 * This method performs bubble sort on the array of type generic (can be used
		 * for any primitive type)
		 * 
		 * @param array
		 * @return Sorted values of "T" type array
		 * @throws CustomizedException
		 */
		public static <T extends Comparable<T>> T[] genericBubbleSortD(T[] array)
				throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
			T temp;
			if (array.length > 1) {
				// taking each value in the array
				for (int i = 0; i < array.length; i++) {
					// taking values from "1" to "length-i"
					for (int j = i + 1; j < array.length; j++) {
						// if numbers[j] > numbers[j+1], swap the elements
						if (array[i].compareTo(array[j]) < 0) {
							temp = array[j];
							array[j] = array[i];
							array[i] = temp;
						}
					}
				}
				return array;
			} else {
				throw new ArrayLengthDoesNotSatisfyTheRequiredLengthException("Enter atleast two inputs in order to sort");
			}
		}


	// Merge sort in ascending order only for strings
	/**
	 * This method performs merge sort on String array only
	 * 
	 * @param unsortedStringArray
	 * @return
	 */
	public static String[] mergeSortA(String[] unsortedStringArray) {
		String[] sorted = new String[unsortedStringArray.length];
		if (unsortedStringArray.length == 1) {
			sorted = unsortedStringArray;
		} else {
			int mid = unsortedStringArray.length / 2;
			String[] left = null;
			String[] right = null;
			if ((unsortedStringArray.length % 2) == 0) {
				left = new String[unsortedStringArray.length / 2];
				right = new String[unsortedStringArray.length / 2];
			} else {
				left = new String[unsortedStringArray.length / 2];
				right = new String[(unsortedStringArray.length / 2) + 1];
			}
			int x = 0;
			int y = 0;
			for (; x < mid; x++) {
				left[x] = unsortedStringArray[x];
			}
			for (; x < unsortedStringArray.length; x++) {
				right[y++] = unsortedStringArray[x];
			}
			left = mergeSortA(left);
			right = mergeSortA(right);
			sorted = mergeArrayA(left, right);
		}

		return sorted;
	}

	/**
	 * This method performs merging of the array of type String
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private static String[] mergeArrayA(String[] left, String[] right) {
		String[] merged = new String[left.length + right.length];
		int lIndex = 0;
		int rIndex = 0;
		int mIndex = 0;
		int comp = 0;
		while (lIndex < left.length || rIndex < right.length) {
			if (lIndex == left.length) {
				merged[mIndex++] = right[rIndex++];
			} else if (rIndex == right.length) {
				merged[mIndex++] = left[lIndex++];
			} else {
				comp = left[lIndex].compareTo(right[rIndex]);
				if (comp > 0) {
					merged[mIndex++] = right[rIndex++];
				} else if (comp < 0) {
					merged[mIndex++] = left[lIndex++];
				} else {
					merged[mIndex++] = left[lIndex++];
				}
			}
		}
		return merged;
	}
	
	// Merge sort in ascending order only for chars
		/**
		 * This method performs merge sort on String array only
		 * 
		 * @param unsortedStringArray
		 * @return
		 */
		public static char[] mergeSortA(char[] unsortedCharArray) {
			char[] sorted = new char[unsortedCharArray.length];
			if (unsortedCharArray.length == 1) {
				sorted = unsortedCharArray;
			} else {
				int mid = unsortedCharArray.length / 2;
				char[] left = null;
				char[] right = null;
				if ((unsortedCharArray.length % 2) == 0) {
					left = new char[unsortedCharArray.length / 2];
					right = new char[unsortedCharArray.length / 2];
				} else {
					left = new char[unsortedCharArray.length / 2];
					right = new char[(unsortedCharArray.length / 2) + 1];
				}
				int x = 0;
				int y = 0;
				for (; x < mid; x++) {
					left[x] = unsortedCharArray[x];
				}
				for (; x < unsortedCharArray.length; x++) {
					right[y++] = unsortedCharArray[x];
				}
				left = mergeSortA(left);
				right = mergeSortA(right);
				sorted = mergeArrayA(left, right);
			}

			return sorted;
		}

		/**
		 * This method performs merging of the array of type String
		 * 
		 * @param left
		 * @param right
		 * @return
		 */
		private static char[] mergeArrayA(char[] left, char[] right) {
			char[] merged = new char[left.length + right.length];
			int lIndex = 0;
			int rIndex = 0;
			int mIndex = 0;
			while (lIndex < left.length || rIndex < right.length) {
				if (lIndex == left.length) {
					merged[mIndex++] = right[rIndex++];
				} else if (rIndex == right.length) {
					merged[mIndex++] = left[lIndex++];
				} else {
					if (left[lIndex] > right[rIndex] ) {
						merged[mIndex++] = right[rIndex++];
					} else if (left[lIndex]< right[rIndex]) {
						merged[mIndex++] = left[lIndex++];
					} else {
						merged[mIndex++] = left[lIndex++];
					}
				}
			}
			return merged;
		}

	// Generic Merge sort in ascending order for wrapper class datatypes like Integer Character String 
	/**
	 * This method performs merge sort on the array of type generic (can be used for
	 * any primitive type)
	 * 
	 * @param <T>
	 * @param array
	 * @param l
	 * @param r
	 * @throws ArrayLengthDoesNotSatisfyTheRequiredLengthException
	 * @throws CustomizedException
	 */
	public static <T extends Comparable<T>> T[] genericMergeSortA(T[] sortArray, int left, int right) throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		if (sortArray.length > 1) {
			if (left < right) {
				// Find the middle point
				int middle = (left + right) / 2;

				// Sort first and second halves
				genericMergeSortA(sortArray, left, middle);
				genericMergeSortA(sortArray, middle + 1, right);

				// Merge the sorted halves
				sortArray= genericMergeArrayA(sortArray, left, middle, right);
			}
			return sortArray;
		} else {
			throw new ArrayLengthDoesNotSatisfyTheRequiredLengthException("Enter more than one input for sorting");
		}
	}

	/**
	 * This method performs merging of the array of type generic (can be used for
	 * any primitive type)
	 * 
	 * @param arr
	 * @return sorted array of given Strings
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> T[] genericMergeArrayA(T mergeSortArray[], int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
		// Create temporary arrays
		T leftArray[] = (T[]) new Comparable[n1];
		T rightArray[] = (T[]) new Comparable[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = mergeSortArray[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = mergeSortArray[mid + 1 + j];
		/* Merge the temporary arrays */
		// Initial indexes of first and second sub arrays
		int i = 0;
		int j = 0;
		// Initial index of merged sub array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i].compareTo(rightArray[j]) <= 0) {
				mergeSortArray[k] = leftArray[i];
				i++;
			} else {
				mergeSortArray[k] = rightArray[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of leftArray[] if any */
		while (i < n1) {
			mergeSortArray[k] = leftArray[i];
			i++;
			k++;
		}
		/* Copy remaining elements of rightArray[] if any */
		while (j < n2) {
			mergeSortArray[k] = rightArray[j];
			j++;
			k++;
		}
		return mergeSortArray;
	}

	
	// Merge sort in descending order for strings only
	/**
	 * This method performs merge sort on String array only
	 * 
	 * @param unsortedStringArray
	 * @return
	 */
	public static String[] mergeSortD(String[] unsortedStringArray) {
		String[] sorted = new String[unsortedStringArray.length];
		if (unsortedStringArray.length == 1) {
			sorted = unsortedStringArray;
		} else {
			int mid = unsortedStringArray.length / 2;
			String[] left = null;
			String[] right = null;
			if ((unsortedStringArray.length % 2) == 0) {
				left = new String[unsortedStringArray.length / 2];
				right = new String[unsortedStringArray.length / 2];
			} else {
				left = new String[unsortedStringArray.length / 2];
				right = new String[(unsortedStringArray.length / 2) + 1];
			}
			int x = 0;
			int y = 0;
			for (; x < mid; x++) {
				left[x] = unsortedStringArray[x];
			}
			for (; x < unsortedStringArray.length; x++) {
				right[y++] = unsortedStringArray[x];
			}
			left = mergeSortA(left);
			right = mergeSortA(right);
			sorted = mergeArrayD(left, right);
		}

		return sorted;
	}

	/**
	 * This method performs merging of the array of type String
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private static String[] mergeArrayD(String[] left, String[] right) {
		String[] merged = new String[left.length + right.length];
		int lIndex = 0;
		int rIndex = 0;
		int mIndex = 0;
		int comp = 0;
		while (lIndex < left.length || rIndex < right.length) {
			if (lIndex == left.length) {
				merged[mIndex++] = right[rIndex++];
			} else if (rIndex == right.length) {
				merged[mIndex++] = left[lIndex++];
			} else {
				comp = left[lIndex].compareTo(right[rIndex]);
				if (comp < 0) {
					merged[mIndex++] = right[rIndex++];
				} else if (comp > 0) {
					merged[mIndex++] = left[lIndex++];
				} else {
					merged[mIndex++] = left[lIndex++];
				}
			}
		}
		return merged;
	}

	// Generic Merge sort in descending order for wrapper class datatypes like Integer Character String 
	/**
	 * This method performs merge sort on the array of type generic (can be used for
	 * any primitive type)
	 * 
	 * @param <T>
	 * @param array
	 * @param l
	 * @param r
	 * @throws ArrayLengthDoesNotSatisfyTheRequiredLengthException
	 * @throws CustomizedException
	 */
	public static <T extends Comparable<T>> T[] genericMergeSortD(T[] sortArray, int left, int right) throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		if (sortArray.length > 1) {
			if (left < right) {
				// Find the middle point
				int middle = (left + right) / 2;

				// Sort first and second halves
				genericMergeSortD(sortArray, left, middle);
				genericMergeSortD(sortArray, middle + 1, right);

				// Merge the sorted halves
				sortArray= genericMergeArrayD(sortArray, left, middle, right);
			}
			return sortArray;
		} else {
			throw new ArrayLengthDoesNotSatisfyTheRequiredLengthException("Enter more than one input for sorting");
		}
	}

	/**
	 * This method performs merging of the array of type generic (can be used for
	 * any primitive type)
	 * 
	 * @param arr
	 * @return sorted array of given Strings
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> T[] genericMergeArrayD(T mergeSortArray[], int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
		// Create temporary arrays
		T leftArray[] = (T[]) new Comparable[n1];
		T rightArray[] = (T[]) new Comparable[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = mergeSortArray[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = mergeSortArray[mid + 1 + j];
		/* Merge the temporary arrays */
		// Initial indexes of first and second sub arrays
		int i = 0;
		int j = 0;
		// Initial index of merged sub array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i].compareTo(rightArray[j]) >= 0) {
				mergeSortArray[k] = leftArray[i];
				i++;
			} else {
				mergeSortArray[k] = rightArray[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of leftArray[] if any */
		while (i < n1) {
			mergeSortArray[k] = leftArray[i];
			i++;
			k++;
		}
		/* Copy remaining elements of rightArray[] if any */
		while (j < n2) {
			mergeSortArray[k] = rightArray[j];
			j++;
			k++;
		}
		return mergeSortArray;
	}

	// Generic Selection Sort
	/**
	 * This method performs selection sort on the array of type generic (can be used
	 * for any primitive type)
	 * 
	 * @param <E>
	 * @param sortArray
	 */

	public static <E extends Comparable<E>> void selectionSort(E[] sortArray) {
		for (int i = 0; i < sortArray.length; i++) {
			// find index of smallest element
			int smallest = i;
			for (int j = i + 1; j < sortArray.length; j++) {
				if (sortArray[j].compareTo(sortArray[smallest]) <= 0) {
					smallest = j;
				}
			}
			swap(sortArray, i, smallest); // swap smallest to front
		}
	}

	// 9)generic for search and sort
	private static <E> void swap(E[] swapArray, int i, int j) {
		if (i != j) {
			E temp = swapArray[i];
			swapArray[i] = swapArray[j];
			swapArray[j] = temp;
		}
	}

	// Anagram for String
	/**
	 * Function to check the two strings are anagrams or not
	 * 
	 * @param s1 the first string to check
	 * @param s2 the second string to check
	 * @return true if its string and vice-versa
	 * @throws CannotCheckAnagramForEmptyStringException 
	 * @throws CustomizedException
	 */
	public static boolean isAnagram(String string1, String string2) throws CannotCheckAnagramForEmptyStringException {
		if(string1.length() == 0 || string2.length() == 0) {
			throw new CannotCheckAnagramForEmptyStringException("Cannot make a anagram check for the empty strings");
		}else {
			String s1 = string1.replaceAll("\\s", "");
			String s2 = string2.replaceAll("\\s", "");
			boolean check = false;
			// if length not equal
			if (s1.length() != s2.length()) {
				check = false;
			} else {
				char[] str1 = s1.toLowerCase().toCharArray();
				char[] str2 = s2.toLowerCase().toCharArray();
	
				mergeSortA(str1);
				mergeSortA(str2);
	
				for (int i = 0; i < str1.length; i++) {
					if (str1[i] == str2[i])
						check = true;
				}
			}
			return check;
		}
	}

	// anagram for integer
	/**
	 * to check the values are anagrams or not
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static boolean isAnagram(int n1, int n2) {
		int[] n1count = count(n1);
		int[] n2count = count(n2);
		for (int i = 0; i < n2count.length; i++) {
			if (n1count[i] != n2count[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Function to count the value in given integer be place
	 * 
	 * @param n the integer value to count
	 * @return the integer array for the count value
	 */
	public static int[] count(int n) {
		int[] count = new int[10];
		int temp = n;
		while (temp != 0) {
			int remainder = temp % 10;
			count[remainder]++;
			temp = temp / 10;
		}
		return count;
	}

	// Prime from 0-1000
	/**
	 * Function to print the prime no between to 1 to 1000
	 * 
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException
	 * 
	 * @throws CustomizedException
	 */
	public static int[] primeNumbersRange(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		if (limit > 0) {
			// creating a temporary String to concatenate all strings
			String temp = "";

			// checking each value from min value to max value
			for (int i = 0; i <= limit; i++) {

				int factorialcount = 0; // initializing the count value to zero for each number

				// counting no of factors for each number
				for (int j = 1; j <= i; j++) {
					if (i % j == 0)
						factorialcount++;
				}
				if (factorialcount == 2) { // adding in to the list if it has only two factors
					temp = temp + i + " ";
				}
			}
			String[] primes = temp.split(" ");

			return stringToIntArray(primes); // converting String array into an int array
		} else {
			throw new PrimeFactorsCannotBeFoundForZeroAndOneException("limit cannot be less than zero");
		}
	}

	/**
	 * static method to convert of integer values into int array
	 * 
	 * @param primeNumbers
	 * @return int array of Prime Numbers
	 */
	private static int[] stringToIntArray(String[] primes) {
		int[] primeNumbers = new int[primes.length];
		// converting each value from String to int
		for (int i = 0; i < primes.length; i++) {
			primeNumbers[i] = Integer.parseInt(primes[i]);
		}
		return primeNumbers;
	}

	// print the generated prime numbers
	/**
	 * static method to print prime numbers in a given range
	 * 
	 * @param min
	 * @param max
	 * @param primes
	 */
	public static void printPrimes(int max, int[] primes) {
		logger.info("prime numbers in the range 1 and " + max + " are : ");
		for (int i = 0; i < primes.length; i++) { // printing prime numbers
			OutputUtility.print(primes[i] + " ");
		}
		OutputUtility.println();
	}

	// PrimeAnagram and PrimePalindrome
	/**
	 * Function helping prime() to check if prime is palindrome and print it
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException 
	 * 
	 */
	public static List<Integer> primePalindrome(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> primePalindromes = new ArrayList<Integer> ();
		if (limit > 0) {
			boolean flag;
			for (int j = 2; j <= limit; j++) {
				flag = true;
				for (int i = 2; i <= j/2; i++) {
					if (j % i == 0) {
						flag = false;
						break;
					}
					
				}
				if (flag && Utility.isPalindrome(j)) {
					primePalindromes.add(j);
				}
			}
			return primePalindromes;
		} else {
			throw new PrimeFactorsCannotBeFoundForZeroAndOneException("limit cannot be less than zero");
		}
	}

	// Prime Anagrams
	/**
	 * Function to check if no is anagram or not
	 * 
	 * @param limit
	 * @throws PrimeFactorsCannotBeFoundForZeroAndOneException 
	 */
	public static List<Integer> primeAnagrams(int limit) throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> array = new ArrayList<>();
		if (limit > 0) {
			boolean flag;
			for (int j = 2; j <= limit; j++) {
				flag = true;
				for (int i = 2; i < j / 2; i++) {
					if (j % i == 0) {
						flag = false;
						break;
					}
				}
				if (flag)
					array.add(j);
			}
			for (int i = 0; i < array.size(); i++) {
				for (int j = i + 1; j < array.size(); j++) {
					if (Utility.isAnagram(array.get(i), array.get(j))) {
						OutputUtility.println(array.get(i) + "  " + array.get(j));
					}
				}
			}
			return array;
		} else {
			throw new PrimeFactorsCannotBeFoundForZeroAndOneException("limit cannot be less than zero");
		}
	}

	// Prime palindromes check
	/**
	 * Function to find the is palindrome or not
	 * 
	 * @param n the integer which to check for palindrome
	 * @return true if its palindrome or false if its not
	 */
	public static boolean isPalindrome(int n) {
		int temp = n;
		int sum = 0;
		if (n > 9) {
			while (temp != 0) {
				int remainder = temp % 10;
				sum = sum * 10 + remainder;
				temp = temp / 10;
			}
			if (sum == n) {
				return true;
			}
			return false;
		} else
			return true;
	}

	// Magic Number
	/**
	 * this method tries to find the number that you are thinking off
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	// invariant: answer is in [lo, hi)
	public static int searchWord(int lo, int hi) {
		if ((hi - lo) == 1)
			return lo;
		int mid = lo + (hi - lo) / 2;
		logger.info("Is it less than " + mid + "?");
		logger.info("Enter true or false");
		if (InputUtility.booleanVal())
			return searchWord(lo, mid);
		else
			return searchWord(mid, hi);
	}

	// question to find your number where N = 2^n
	// invariant: answer is in [lo, hi)
	public static int search(int low, int high) throws InvalidIntegerException {
		if (high > low) {
			if ((high - low) == 1)
				return low;
			int mid = low + (high - low) / 2;
			OutputUtility.printf("enter true if it is only less than %d?  ", mid);
			if (InputUtility.booleanVal())
				return search(low, mid);
			else
				return search(mid, high);
		} else {
			throw new InvalidIntegerException("Enter valid integers to overcome this exception");
		}
	}

	// Registration and replace message using regex
	static BufferedReader br;
	private final static String REGEX_NAME = "<<name>>";
	private final static String REGEX_FULLNAME = "<<full name>> ";
	private final static String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private final static String REGEX_DATE = "12/06/2016";

	// constructor to initialize bufferedReader

	// Regex pattern matcher match the string and replace the regex pattern with
	// user details.
	public String convertString(UserDetails userDetails, String message) {
		Pattern p = Pattern.compile(REGEX_NAME);
		Matcher m = p.matcher(message);
		message = m.replaceAll(userDetails.getfName());
		p = Pattern.compile(REGEX_FULLNAME);
		m = p.matcher(message);
		message = m.replaceAll(userDetails.getfName() + " " + userDetails.getlName());
		p = Pattern.compile(REGEX_MOBILE_NO);
		m = p.matcher(message);
		message = m.replaceAll(userDetails.mobileNo());
		p = Pattern.compile(REGEX_DATE);
		m = p.matcher(message);
		message = m.replaceAll(userDetails.date());
		return message;
	}

	// take input word
	public String inputString() {
		try {
			return br.readLine();
		} catch (IOException ioe) {
			logger.info(ioe.getMessage());
		}
		return "";
	}

	// Take Integer Input
	public int inputInteger() {
		try {
			try {
				return Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				logger.info(nfe.getMessage());
			}
		} catch (IOException ioe) {
			logger.info(ioe.getMessage());
		}
		return 0;
	}

	// Take Double Input
	public double inputDouble() {
		try {
			try {
				return Double.parseDouble(br.readLine());
			} catch (NumberFormatException nfe) {
				logger.info(nfe.getMessage());
			}
		} catch (IOException ioe) {
			logger.info(ioe.getMessage());
		}
		return 0.0;
	}

	// Function take String in dd/mm/yyyy format and return Date Object
	public Date printDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			return sdf.parse(date);
		} catch (ParseException pe) {
			return null;
		}
	}

	// format date object in this format 25/01/2020
	public String getFormatedDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		return sdf.format(date);
	}

}