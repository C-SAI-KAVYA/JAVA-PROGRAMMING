package com.bridgelabz.testfunctionalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.UnsupportedValuesForEuclideanDistanceCalculationException;
import com.bridgelabz.functionalprograms.utils.Utility;

public class TestEuclideanDistance {
	
	@Test(expected = UnsupportedValuesForEuclideanDistanceCalculationException.class)
	public void testEuclideanDistance_UnsupportedValuesForEuclideanDistanceCalculationException_MinusTwoAndMinusThree() throws UnsupportedValuesForEuclideanDistanceCalculationException {
		Utility.euclideanDistance(-2, -3);
	}
	
	@Test(expected = UnsupportedValuesForEuclideanDistanceCalculationException.class)
	public void testEuclideanDistance_UnsupportedValuesForEuclideanDistanceCalculationException_MinusFourtyfiveAndSixtySeven() throws UnsupportedValuesForEuclideanDistanceCalculationException {
		Utility.euclideanDistance(-45, 67);
	}
	
	@Test(expected = UnsupportedValuesForEuclideanDistanceCalculationException.class)
	public void testEuclideanDistance_UnsupportedValuesForEuclideanDistanceCalculationException_FourtyfiveAndMinusSixtySeven() throws UnsupportedValuesForEuclideanDistanceCalculationException {
		Utility.euclideanDistance(45, -67);
	}
	
	@Test
	public void testEuclideanDistance_93point53608929178085_FourtyfiveAndEightyTwo() throws UnsupportedValuesForEuclideanDistanceCalculationException {
		double expected = 93.53608929178085;
		assertEquals(expected, Utility.euclideanDistance(45, 82),Math.E);
	}
	
	@Test
	public void testEuclideanDistance_47point16990566028302_SeventeenAndFourtyFour() throws UnsupportedValuesForEuclideanDistanceCalculationException {
		double expected = 47.16990566028302;
		assertEquals(expected, Utility.euclideanDistance(17, 44),Math.E);
	}
	@Test
	public void testEuclideanDistance_25point079872407968907_TweentyThreeAndTen() throws UnsupportedValuesForEuclideanDistanceCalculationException {
		double expected = 25.079872407968907;
		assertEquals(expected, Utility.euclideanDistance(23, 10),Math.E);
	}
	@Test
	public void testEuclideanDistance_20point591260281974_TenAndEighteen() throws UnsupportedValuesForEuclideanDistanceCalculationException {
		double expected = 20.591260281974;
		assertEquals(expected, Utility.euclideanDistance(10, 18),Math.E);
	}

}
