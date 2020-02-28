package com.bridgelabz.testlogicalprograms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.bridgelabz.logicalprograms.utils.Utility;

public class TestGambler {
	
	@Test
	public void testGambler_0point0And0point0And0point0_50And50() {
		double[] expected = {0.0, 0.0, 0.0};
		assertArrayEquals(expected, Utility.gambler(50, 50),Math.E);
	}
	
	@Test
	public void testGambler_2And100point0And0point0_2And4() {
		double[] expected = {2.0, 100.0, 0.0};
		assertArrayEquals(expected, Utility.gambler(2, 4),Math.E);
	}

}
