package com.bridgelabz.testalgorithmprograms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.ArrayLengthDoesNotSatisfyTheRequiredLengthException;

public class TestGenericMergeSort {
	
	@Test(expected = ArrayLengthDoesNotSatisfyTheRequiredLengthException.class)
	public void testMergeSortGeneric_ArrayLengthDoesNotSatisfyTheRequiredLengthException_ArrayWith0Length () throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		Utility.genericMergeSortA(new Integer[0], 0, 0);
	}
	
	@Test
	public void testGenericMergeSort_ArraySortedInAscendingOrder_IntegerArray() throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		Integer[] expectedArray = {12, 34, 56, 78, 101};
		Integer[] inputArray = {101, 34, 78, 56, 12};
		assertArrayEquals(expectedArray, Utility.genericMergeSortA(inputArray, 0, inputArray.length-1));
	}
	
	@Test
	public void testGenericMergeSort_ArraySortedInDescendingOrder_IntegerArray() throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		Integer[] expectedArray = {101, 78, 56, 34, 12};
		Integer[] inputArray = {101, 34, 78, 56, 12};
		assertArrayEquals(expectedArray, Utility.genericMergeSortD(inputArray, 0, inputArray.length-1));
	}
	
	@Test
	public void testGenericMergeSort_ArraySortedInAscendingOrder_StringArray() throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		String[] expectedArray = {"at", "bad", "choice", "deletes", "life"};
		String[] inputArray = {"life", "bad", "deletes", "at", "choice"};
		assertArrayEquals(expectedArray, Utility.genericMergeSortA(inputArray, 0, inputArray.length-1));
	}
	
	@Test
	public void testGenericMergeSort_ArraySortedInDescendingOrder_StringArray() throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		String[] expectedArray = {"life", "deletes", "choice", "bad", "at"};
		String[] inputArray = {"life", "bad", "deletes", "at", "choice"};
		assertArrayEquals(expectedArray, Utility.genericMergeSortD(inputArray, 0, inputArray.length-1));
	}
	
	@Test
	public void testGenericMergeSort_ArraySortedInAscendingOrder_CharArray() throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		Character[] expectedArray = {'a', 'b', 'c', 'w', 'z'};
		Character[] inputArray = {'z', 'b', 'c', 'a', 'w'};
		assertArrayEquals(expectedArray, Utility.genericMergeSortA(inputArray, 0, inputArray.length-1));
	}
	
	@Test
	public void testGenericMergeSort_ArraySortedInDecendingOrder_CharArray() throws ArrayLengthDoesNotSatisfyTheRequiredLengthException {
		Character[] expectedArray = {'z', 'w', 'c', 'b', 'a'};
		Character[] inputArray = {'z', 'b', 'c', 'a', 'w'};
		assertArrayEquals(expectedArray, Utility.genericMergeSortD(inputArray, 0, inputArray.length-1));
	}
		
}
