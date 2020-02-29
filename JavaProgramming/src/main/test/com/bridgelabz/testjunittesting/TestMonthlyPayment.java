package com.bridgelabz.testjunittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.junittesting.utils.Utility;

public class TestMonthlyPayment {
	
	@Test(expected = LessThanOrGreaterThanSpecifiedRangeException.class)
	public void testMonthlyPayment_LessThanOrGreaterThanSpecifiedRangeException_0And999And12() throws LessThanOrGreaterThanSpecifiedRangeException {
		Utility.monthlyPayment(0, 999, 12);//principalLoanAmount, year, rateOfInterest
	}
	
	@Test(expected = LessThanOrGreaterThanSpecifiedRangeException.class)
	public void testMonthlyPayment_LessThanOrGreaterThanSpecifiedRangeException_12point345And998And58point34() throws LessThanOrGreaterThanSpecifiedRangeException {
		Utility.monthlyPayment(12.345, 998, 58.34);
	}
	@Test
	public void testMonthlyPayment_0point4523_12And2016And45point23() throws LessThanOrGreaterThanSpecifiedRangeException {
		assertEquals(0.4523, Utility.monthlyPayment(12, 2016, 45.23),Math.E);
	}
	
	@Test
	public void testMonthlyPayment_0point4523_34point65And2020And12point3() throws LessThanOrGreaterThanSpecifiedRangeException {
		assertEquals(0.3551625, Utility.monthlyPayment(34.65, 2020, 12.3),Math.E);
	}
	
}
