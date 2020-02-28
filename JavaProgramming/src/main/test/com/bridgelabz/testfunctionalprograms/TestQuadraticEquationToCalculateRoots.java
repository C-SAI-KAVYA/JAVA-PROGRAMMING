package com.bridgelabz.testfunctionalprograms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.bridgelabz.errors.QuadraticRootsCantBeFoundForZeroOrLessValuesError;
import com.bridgelabz.functionalprograms.utils.Utility;

public class TestQuadraticEquationToCalculateRoots {
	
	@Test(expected=QuadraticRootsCantBeFoundForZeroOrLessValuesError.class)
	public void testQuadraticEquationToCalculateRoots_QuadraticRootsCantBeFoundForZeroOrLessValuesError_ZeroAndThreeAndFive() {
		Utility.quadraticRootsCalculator(0, 3, 5);
	}
	
	@Test
	public void testQuadraticEquationToCalculateRoots_1Point0AndMinus0Point3333333333333333_3Andminus2Andminus1() {
		double[] expected = {1.0, -0.3333333333333333};
		assertArrayEquals(expected,Utility.quadraticRootsCalculator(3, -2, -1),Math.E);
	}
	
	@Test
	public void testQuadraticEquationToCalculateRoots_Minus0point6180339887498949And1point618033988749895_minus2And2And2() {
		double[] expected = {-0.6180339887498949, 1.618033988749895};
		assertArrayEquals(expected,Utility.quadraticRootsCalculator(-2, 2, 2),Math.E);
	}
	
	@Test
	public void testQuadraticEquationToCalculateRoots_Minus1point5And1point0_minus2Andminus1And3() {
		double[] expected = {-1.5, 1.0};
		assertArrayEquals(expected,Utility.quadraticRootsCalculator(-2, -1, 3),Math.E);
	}
	
	@Test
	public void testQuadraticEquationToCalculateRoots_Minus1point5AndMinus1point6583123951777_minus1Andminus3AndMinus5() {
		double[] expected = {-1.5, -1.6583123951777};
		assertArrayEquals(expected,Utility.quadraticRootsCalculator(-2, -1, 3),Math.E);
	}
	
	@Test
	public void testQuadraticEquationToCalculateRoots_Minus2point0And0Point8660254037844386_TwoAndTwoAndTwo() {
		double[] expected = {-2.0, 0.8660254037844386};
		assertArrayEquals(expected,Utility.quadraticRootsCalculator(2,2,2),Math.E);
	}	
	
}
