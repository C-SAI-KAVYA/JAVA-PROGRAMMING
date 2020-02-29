package com.bridgelabz.testlogicalprograms;

import org.junit.Test;

import com.bridgelabz.exceptions.InvalidIntegerException;
import com.bridgelabz.logicalprograms.utils.Utility;

public class TestStopWatch {

	@Test(expected = InvalidIntegerException.class)
	public void testStopWatch_InvalidIntegerException_Minus1() throws InvalidIntegerException{
		Utility.stopWatch(-1);
	}
	
	@Test(expected = InvalidIntegerException.class)
	public void testStopWatch_InvalidIntegerException_0() throws InvalidIntegerException{
		Utility.stopWatch(0);
	}
}
