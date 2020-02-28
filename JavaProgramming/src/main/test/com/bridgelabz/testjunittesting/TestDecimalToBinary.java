package com.bridgelabz.testjunittesting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.junittesting.utils.Utility;

public class TestDecimalToBinary {
	
	@Test(expected = NegativeOrZeroNumberFoundException.class)
	public void testDecimalToBinary_NegativeOrZeroNumberFoundException_0() throws NegativeOrZeroNumberFoundException {
		Utility.toBinary(0);
	}
	
	@Test
	public void testDecimalToBinary_01001100_76() throws  NegativeOrZeroNumberFoundException {
		int[] expectedBinaryArray = {0,0,1,1,0,0,1,0};
		assertArrayEquals(expectedBinaryArray,Utility.toBinary(76));
	}
	
	@Test
	public void testDecimalToBinary_01100100_100() throws  NegativeOrZeroNumberFoundException {
		int[] expectedBinaryArray = {0,0,1,0,0,1,1,0};
		assertArrayEquals(expectedBinaryArray,Utility.toBinary(100));
	}	
	
	@Test
	public void testDecimalToBinary_11001000_200() throws  NegativeOrZeroNumberFoundException {
		int[] expectedBinaryArray = {0,0,0,1,0,0,1,1};
		assertArrayEquals(expectedBinaryArray,Utility.toBinary(200));
	}	
	
}
