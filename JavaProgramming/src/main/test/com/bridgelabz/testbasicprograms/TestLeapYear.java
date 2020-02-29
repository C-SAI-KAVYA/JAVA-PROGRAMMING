package com.bridgelabz.testbasicprograms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.exceptions.NumberNotInRequiredFormatOrSizeException;

public class TestLeapYear {
	
	@Test(expected=NumberNotInRequiredFormatOrSizeException.class)
	public void testLeapYear_NumberNotInRequiredFormatOrSizeException_123() throws NumberNotInRequiredFormatOrSizeException, LessThanOrGreaterThanSpecifiedRangeException{
		Utility.isLeapYear(123);
	}
	
	@Test(expected=LessThanOrGreaterThanSpecifiedRangeException.class)
	public void testLeapYear_LessThanOrGreaterThanSpecifiedRangeException_1581() throws NumberNotInRequiredFormatOrSizeException, LessThanOrGreaterThanSpecifiedRangeException { 
		Utility.isLeapYear(1581);
	}	
	
	@Test(expected=NumberNotInRequiredFormatOrSizeException.class)
	public void testLeapYear_NumberNotInRequiredFormatOrSizeException_10000() throws NumberNotInRequiredFormatOrSizeException, LessThanOrGreaterThanSpecifiedRangeException {
		Utility.isLeapYear(10000);
	}
	
	@Test
	public void testLeapYear_True_2016() throws NumberNotInRequiredFormatOrSizeException, LessThanOrGreaterThanSpecifiedRangeException {
		assertTrue(Utility.isLeapYear(2016));
	}
	
	@Test
	public void testLeapYear_False_2001() throws NumberNotInRequiredFormatOrSizeException, LessThanOrGreaterThanSpecifiedRangeException {
		assertFalse(Utility.isLeapYear(2001));
	}
	
	@Test
	public void testLeapYear_True_2000() throws NumberNotInRequiredFormatOrSizeException, LessThanOrGreaterThanSpecifiedRangeException {
		assertEquals(true,Utility.isLeapYear(2000));
}
}
