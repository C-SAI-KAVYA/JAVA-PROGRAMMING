package com.bridgelabz.testalgorithmprograms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bridgelabz.algorithmprograms.utils.InputUtility;
import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.SelectedStringDoesNotExsistsException;

public class TestBinaryWordSearch {
	
	@Test(expected = SelectedStringDoesNotExsistsException.class)
	public void testBinaryWordSearch_SelectedStringDoesNotExsistsException_EmptyString() throws SelectedStringDoesNotExsistsException {
		String content = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\BinaryWordSearch.txt");
		String[] words = content.split("\\s+");
		Utility.binaryWordsearch("", words);
	}
	
	@Test
	public void testBinaryWordSearch_Found_binary() throws SelectedStringDoesNotExsistsException {
		String content = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\BinaryWordSearch.txt");
		String[] words = content.split("\\s+");
		assertTrue(Utility.binaryWordsearch("binary", words) > 0);// if greater than zero the value is found
	}
	
	@Test
	public void testBinaryWordSearch_NotFound_Cherry() throws SelectedStringDoesNotExsistsException {
		String content = InputUtility.readFileToString("F:\\BridgeLabzFellowship\\JavaProgramming\\textfiles\\BinaryWordSearch.txt");
		String[] words = content.split("\\s+");
		assertTrue(Utility.binaryWordsearch("Cherry", words) < 0);// if less than zero the value is not found
	}
}
