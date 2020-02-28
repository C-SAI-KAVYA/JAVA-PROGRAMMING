package com.bridgelabz.testbasicprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.PrimeFactorsCannotBeFoundForZeroAndOneException;

public class TestPrimeFactors {
	
	@Test(expected = PrimeFactorsCannotBeFoundForZeroAndOneException.class)
	public void testPrimeFactors_PrimeFactorsCannotBeFoundForZeroAndOneException_0() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		Utility.primeFactors(0);
	}
	
	@Test(expected = PrimeFactorsCannotBeFoundForZeroAndOneException.class)
	public void testPrimeFactors_PrimeFactorsCannotBeFoundForZeroAndOneException_1() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		Utility.primeFactors(1);
	}
	
	@Test()
	public void testPrimeFactors_FiveSeven_ThirtyFive() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Arrays.asList(5,7);
			assertThat(expected, is(Utility.primeFactors(35)));
	}
	
	@Test()
	public void testPrimeFactors_ArraySizeSix_900() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Utility.primeFactors(900);
			assertThat(expected, hasSize(6));
	}	
	
	@Test()
	public void testPrimeFactors_EmptyList_NewList() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		assertThat(new ArrayList<>(),IsEmptyCollection.empty());
	}
	
	@Test()
	public void testPrimeFactors_TwoTwoTwoSevenAreInOrder_56() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Utility.primeFactors(56);
		assertThat(expected, contains(2, 2, 2, 7));
	}

	@Test()
	public void testPrimeFactors_TwoTwoTwoSevenAreInAnyOrder_56() throws PrimeFactorsCannotBeFoundForZeroAndOneException {
		List<Integer> expected = Utility.primeFactors(56);
		assertThat(expected, containsInAnyOrder(2, 7, 2, 2));
	}
	
}
