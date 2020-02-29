package com.bridgelabz.testbasicprograms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.CannotCalculateZeroPowerException;

public class TestPowerOfTwo {
	
	@Test(expected = CannotCalculateZeroPowerException.class)
	public void testPowerOfTwo_CannotCalculateZeroPowerException_00() throws CannotCalculateZeroPowerException {
		Utility.powerOfTwo(0, 0);
	}
	
	@Test
	public void testPowerOfTwo_OneFourSixteen_PlusthreePlusFour() throws CannotCalculateZeroPowerException {
		double[] expected = {1.0, 4.0, 16.0};
		assertArrayEquals(expected,Utility.powerOfTwo(3, 4),Math.E);
	}
	
	@Test
	public void testPowerOfTwo_OnepointzeroZeropointtwofiveZerozerosixtwofive_MinusthreePlusfour() throws CannotCalculateZeroPowerException {
		double[] expected = {1.0, 0.25, 0.0625};
		assertArrayEquals(expected,Utility.powerOfTwo(-3, 4),Math.E);
	}
	
	@Test
	public void testPowerOfTwo_OnepointzeroMinusfourpointzeroSixteenpointzero_PlusthreeMinusFour() throws CannotCalculateZeroPowerException {
		double[] expected = {1.0, -4.0, 16.0};
		assertArrayEquals(expected,Utility.powerOfTwo(3, -4),Math.E);
	}
	
	@Test
	public void testPowerOfTwo_OnepointzeroMinuszeropointtwofiveZeropoinzerosixtwofive_MinusthreeMinusfour() throws CannotCalculateZeroPowerException {
		double[] expected = {1.0, -0.25, 0.0625};
		assertArrayEquals(expected,Utility.powerOfTwo(-3, -4),Math.E);
	}
	
}
