package com.bridgelabz.testalgorithmprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.CannotCheckAnagramForEmptyStringException;

public class TestStringAnagram {
	
	@Test(expected = CannotCheckAnagramForEmptyStringException.class)
	public void testInsertionSortGeneric_CannotCheckAnagramForEmptyStringException_StringsWith0Length () throws CannotCheckAnagramForEmptyStringException {
		Utility.isAnagram("","");
	}
	
	@Test
	public void testInsertionSortGeneric_true_TwoStrings() throws CannotCheckAnagramForEmptyStringException {
		String string1 = "ASTRONOMERS";
		String string2 = "NOMORESTARS";
		assertEquals(true, Utility.isAnagram( string1,string2));
}
	
	@Test
	public void testInsertionSortGeneric_false_TwoStrings() throws CannotCheckAnagramForEmptyStringException {
		String string1 = "Good";
		String string2 = "Going";
		assertEquals(false, Utility.isAnagram(string1,string2));
	}
	
	@Test
	public void testInsertionSortGeneric_false_TwoStringsFromFiles () throws CannotCheckAnagramForEmptyStringException {
		String string1 = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\StringAnagramText1.txt");;
		String string2 = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\StringAnagramText2.txt");;
		assertEquals(false, Utility.isAnagram(string1,string2));
	}
	
	@Test
	public void testInsertionSortGeneric_True_TwoStringsFromFiles () throws CannotCheckAnagramForEmptyStringException {
		String string1 = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\TestStringAnagram1.txt");;
		String string2 = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\TestStringAnagram2.txt");;
		assertEquals(true, Utility.isAnagram(string1,string2));
	}
	
	
	
}
