package com.bridgelabz.testfunctionalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.LessThanOrGreaterThanSpecifiedRangeException;
import com.bridgelabz.functionalprograms.utils.Utility;

public class TestWindChillTemperatureCalc {
	
	@Test(expected = LessThanOrGreaterThanSpecifiedRangeException.class)
	public void testWindChillTemperatureCalc_LessThanOrGreaterThanSpecifiedRangeException_53And2() throws LessThanOrGreaterThanSpecifiedRangeException {
		Utility.windChillTemperatureCalculator(53, 2);
	}
	
	@Test(expected = LessThanOrGreaterThanSpecifiedRangeException.class)
	public void testWindChillTemperatureCalc_LessThanOrGreaterThanSpecifiedRangeException_45And121() throws LessThanOrGreaterThanSpecifiedRangeException {
		Utility.windChillTemperatureCalculator(45, 121);
	}
	
	@Test(expected = LessThanOrGreaterThanSpecifiedRangeException.class)
	public void testWindChillTemperatureCalc_LessThanOrGreaterThanSpecifiedRangeException_56And115() throws LessThanOrGreaterThanSpecifiedRangeException {
		Utility.windChillTemperatureCalculator(56, 115);
	}
	
	@Test
	public void testWindChillTemperatureCalc_2point6842396738801426_45And115() throws LessThanOrGreaterThanSpecifiedRangeException {
		double expected = 2.6842396738801426;
		assertEquals(expected, Utility.windChillTemperatureCalculator(45, 115),Math.E);
	}
	@Test
	public void testWindChillTemperatureCalc_Minus16point220860373269048_23And100() throws LessThanOrGreaterThanSpecifiedRangeException {
		double expected = -16.220860373269048;
		assertEquals(expected, Utility.windChillTemperatureCalculator(23, 100),Math.E);
	}
	
	@Test
	public void testWindChillTemperatureCalc_Minus8point049636956168627_10And10() throws LessThanOrGreaterThanSpecifiedRangeException {
		double expected = -8.049636956168627;
		assertEquals(expected, Utility.windChillTemperatureCalculator(10, 10),Math.E);
	}

}
