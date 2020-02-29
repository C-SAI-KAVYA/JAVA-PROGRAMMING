package com.bridgelabz.testjunittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.InvalidDateEnteredException;
import com.bridgelabz.junittesting.utils.Utility;

public class TestDayOfWeek {
	
	@Test(expected = InvalidDateEnteredException.class)
	public void testDayOfWeek_InvalidDateEnteredException_0And13And998() throws InvalidDateEnteredException {
		Utility.dayOfWeek(0, 13, 998);
	}
	
	@Test(expected = InvalidDateEnteredException.class)
	public void testDayOfWeek_InvalidDateEnteredException_01And12And998() throws InvalidDateEnteredException {
		Utility.dayOfWeek(01, 12, 998);
	}
	
	@Test(expected = InvalidDateEnteredException.class)
	public void testDayOfWeek_InvalidDateEnteredException_10And15And1998() throws InvalidDateEnteredException {
		Utility.dayOfWeek(10, 15, 1998);
	}
	
	@Test(expected = InvalidDateEnteredException.class)
	public void testDayOfWeek_InvalidDateEnteredException_00And12And1998() throws InvalidDateEnteredException {
		Utility.dayOfWeek(00, 12, 1998);
	}
	@Test(expected = InvalidDateEnteredException.class)
	public void testDayOfWeek_InvalidDateEnteredException_30And02And2016() throws InvalidDateEnteredException {
		Utility.dayOfWeek(30, 02, 2016);
	}
	@Test
	public void testDayOfWeek_4MeansThursday_20And02And2020() throws InvalidDateEnteredException {
		assertEquals(4,Utility.dayOfWeek(20, 02, 2020));
	}
	
}
