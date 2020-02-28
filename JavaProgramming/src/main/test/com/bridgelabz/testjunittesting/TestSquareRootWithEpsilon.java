package com.bridgelabz.testjunittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.junittesting.utils.Utility;

public class TestSquareRootWithEpsilon {
	
	@Test(expected = NegativeOrZeroNumberFoundException.class)
	public void testSquareRootWithEpsilon_NegativeOrZeroNumberFoundException_minus25point34() throws NegativeOrZeroNumberFoundException {
		Utility.sqrt(-25.34);
	}
	
	@Test(expected = NegativeOrZeroNumberFoundException.class)
	public void testSquareRootWithEpsilon_NegativeOrZeroNumberFoundException_0() throws NegativeOrZeroNumberFoundException {
		Utility.sqrt(0);
	}
	
	@Test
	public void testSquareRootWithEpsilon_7point000000000000002_49() throws NegativeOrZeroNumberFoundException {
		assertEquals(7.000000000000002,Utility.sqrt(49),Math.E);
	}
	
	@Test
	public void testSquareRootWithEpsilon_12point041594578792296_145() throws NegativeOrZeroNumberFoundException {
		assertEquals(12.041594578792296,Utility.sqrt(145),Math.E);
	}
	
}
