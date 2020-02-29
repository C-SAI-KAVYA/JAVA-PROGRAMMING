package com.bridgelabz.testjunittesting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
import com.bridgelabz.junittesting.utils.Utility;

public class TestBinary {
	
	@Test(expected = NegativeOrZeroNumberFoundException.class)
	public void testBinary_NegativeOrZeroNumberFoundException_Minus45() throws NegativeOrZeroNumberFoundException {
		Utility.toBinary(-45);
	}
	
	@Test(expected = NegativeOrZeroNumberFoundException.class)
	public void testBinary_NegativeOrZeroNumberFoundException_0() throws NegativeOrZeroNumberFoundException {
		Utility.toBinary(0);
	}
	
	@Test
	public void testBinary_And00000001And128AndTrue_8() throws NegativeOrZeroNumberFoundException {
		int[] expectedBinaryArray = {0,0,0,0,1,0,0,0};
		int[] swappedNibblesArray = {1,0,0,0,0,0,0,0}; 
		int decimalRepresentation = 128;
		boolean expectedBoolean = true;
		assertArrayEquals(expectedBinaryArray, Utility.toBinary(16));
		assertArrayEquals(swappedNibblesArray, Utility.swapNibbles(expectedBinaryArray));
		assertEquals(decimalRepresentation, Utility.toDecimal(swappedNibblesArray));
		assertEquals(expectedBoolean, Utility.powerOf2(decimalRepresentation));
	}
	
	@Test
	public void testBinary_01001000And10000100And33AndFalse_72() throws NegativeOrZeroNumberFoundException {
		int[] expectedBinaryArray = {0,0,0,1,0,0,1,0};
		int[] swappedNibblesArray = {0,0,1,0,0,0,0,1}; 
		int decimalRepresentation = 33;
		boolean expectedBoolean = false;
		assertArrayEquals(expectedBinaryArray, Utility.toBinary(72));
		assertArrayEquals(swappedNibblesArray, Utility.swapNibbles(expectedBinaryArray));
		assertEquals(decimalRepresentation, Utility.toDecimal(swappedNibblesArray));
		assertEquals(expectedBoolean, Utility.powerOf2(decimalRepresentation));
	}
}
