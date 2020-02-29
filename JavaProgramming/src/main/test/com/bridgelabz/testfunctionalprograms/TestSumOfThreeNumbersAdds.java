package com.bridgelabz.testfunctionalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.ArraySizeDoesNotSatisfyRequiredLengthException;
import com.bridgelabz.functionalprograms.utils.Utility;

public class TestSumOfThreeNumbersAdds {
	// for byte array
	@Test(expected = ArraySizeDoesNotSatisfyRequiredLengthException.class)
	public void testSumOfThreeNumbersAdds_ArraySizeDoesNotSatisfyRequiredLengthException_Minus1And1()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		byte[] inputArray = { -1, 1 };
		Utility.findTriplets(inputArray);
	}

	@Test
	public void testSumOfThreeNumbersAdds_2_BytesMinus1AndOneAndZeroAndThreeAndMinusThree()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		byte[] inputArray = { -1, 1, 0, 3, -3 };
		int expectedCount = 2;
		assertEquals(expectedCount, Utility.findTriplets(inputArray));
	}

	// for short array
	@Test(expected = ArraySizeDoesNotSatisfyRequiredLengthException.class)
	public void testSumOfThreeNumbersAdds_ArraySizeDoesNotSatisfyRequiredLengthException_Minus34And12()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		short[] inputArray = { -34, 12 };
		Utility.findTriplets(inputArray);
	}

	@Test
	public void testSumOfThreeNumbersAdds_2_Short1AndMinus2And0And5AndMinus1AndMinus4()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		short[] inputArray = { 1, -2, 0, 5, -1, -4 };
		int expectedCount = 2;
		assertEquals(expectedCount, Utility.findTriplets(inputArray));
	}

	// for int array
	@Test(expected = ArraySizeDoesNotSatisfyRequiredLengthException.class)
	public void testSumOfThreeNumbersAdds_ArraySizeDoesNotSatisfyRequiredLengthException_Minus26And35()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int[] inputArray = { -26, 35 };
		Utility.findTriplets(inputArray);
	}

	@Test
	public void testSumOfThreeNumbersAdds_2_Ints1AndMinus2And0And5AndMinus1AndMinus4()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		int[] inputArray = { 11, -22, 0, 55, -11, -44 };
		int expectedCount = 2;
		assertEquals(expectedCount, Utility.findTriplets(inputArray));
	}
	// for long array
	@Test(expected = ArraySizeDoesNotSatisfyRequiredLengthException.class)
	public void testSumOfThreeNumbersAdds_ArraySizeDoesNotSatisfyRequiredLengthException_26AndMinus44() throws ArraySizeDoesNotSatisfyRequiredLengthException {
		long[] inputArray = { 26, -44 };
		Utility.findTriplets(inputArray);
	}

	@Test
	public void testSumOfThreeNumbersAdds_2_IntsMinus2222222222And1111111111And0And5555555555AndMinus11111111111AndMinus4444444444()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		long[] inputArray = { -2222222222l, 1111111111l, 0l, 5555555555l, -1111111111l, -4444444444l };
		int expectedCount = 2;
		assertEquals(expectedCount, Utility.findTriplets(inputArray));
	}

	// for float array
	@Test(expected = ArraySizeDoesNotSatisfyRequiredLengthException.class)
	public void testSumOfThreeNumbersAdds_ArraySizeDoesNotSatisfyRequiredLengthException_26point23AndMinus44point14()
			throws ArraySizeDoesNotSatisfyRequiredLengthException {
		float[] inputArray = { 26.23f, -44.14f };
		Utility.findTriplets(inputArray);
	}

	@Test
	public void testSumOfThreeNumbersAdds_2_FloatsMinus22point22And11point11And0point00And55point55AndMinus11point11AndMinus44point44() throws ArraySizeDoesNotSatisfyRequiredLengthException {
		float[] inputArray = { -22.22f, 11.11f, 0.00f, 55.55f, -11.11f, -44.44f };
		int expectedCount = 2;
		assertEquals(expectedCount, Utility.findTriplets(inputArray));
	}

	// for double array
	@Test(expected = ArraySizeDoesNotSatisfyRequiredLengthException.class)
	public void testSumOfThreeNumbersAdds_ArraySizeDoesNotSatisfyRequiredLengthException_26point35555AndMinus44point12346() throws ArraySizeDoesNotSatisfyRequiredLengthException {
		double[] inputArray = { 26.35555 -44.12346 };
		Utility.findTriplets(inputArray);
	}

	@Test
	public void testSumOfThreeNumbersAdds_2_DoublesMinus22point22222222And11point11111111And0And55point55555555AndMinus11point111111111AndMinus44point44444444() throws ArraySizeDoesNotSatisfyRequiredLengthException {
		double[] inputArray = { -22.22222222, 11.11111111, 0, 55.55555555, -11.11111111, -44.44444444 };
		int expectedCount = 2;
		assertEquals(expectedCount, Utility.findTriplets(inputArray));
	}

}
