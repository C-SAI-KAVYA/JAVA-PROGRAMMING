package com.bridgelabz.testalgorithmprograms;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class TestPrimeAnagramAndPalindrome {
	
	@Test(expected = PrimeFactorsCannotBeFoundForZeroAndOneException.class)
	public void testPrimeAnagramAndPalindrome_PrimeFactorsCannotBeFoundForZeroAndOneExceptionByPalindromeMethod_limit0() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		Utility.primePalindrome(0);
	}
	
	@Test(expected = PrimeFactorsCannotBeFoundForZeroAndOneException.class)
	public void testPrimeAnagramAndPalindrome_PrimeFactorsCannotBeFoundForZeroAndOneExceptionByAnagramMethod_limit0() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		Utility.primeAnagrams(0);
	}
	
	@Test
	public void testPrimeAnagramAndPalindrome_0to10PrimePalindromeNumbersExpected_limit10() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Arrays.asList(2,3,5,7);
		assertThat(expected, is(Utility.primePalindrome(10)));
	}
	
	@Test
	public void testPrimeAnagramAndPalindrome_0to100PrimePalindromeNumbersExpected_limit100() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Arrays.asList(2,3,5,7,11);
		assertThat(expected, is(Utility.primePalindrome(100)));
	}
	
	@Test
	public void testPrimeAnagramAndPalindrome_0to500PrimePalindromeNumbersExpected_limit500() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Arrays.asList(2,3,5,7,11,101,131,151,181,191,313,353,373,383);
		assertThat(expected, is(Utility.primePalindrome(500)));
	}
	
	@Test
	public void testPrimeAnagramAndPalindrome_0to1000PrimePalindromeNumbersExpected_limit1000() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Arrays.asList(2,3,5,7,11,101,131,151,181,191,313,353,373,383,727,757,787,797,919,929);
		assertThat(expected, is(Utility.primePalindrome(1000)));
	}

}
