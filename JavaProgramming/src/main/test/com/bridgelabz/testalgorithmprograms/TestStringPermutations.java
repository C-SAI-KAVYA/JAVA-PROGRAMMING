package com.bridgelabz.testalgorithmprograms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.bridgelabz.algorithmprograms.utils.Utility;
import com.bridgelabz.exceptions.PermutationsCannotBeFoundForNullOrZeroCharacterisedString;

public class TestStringPermutations {
	
	@Test(expected = PermutationsCannotBeFoundForNullOrZeroCharacterisedString.class)
	public void testStringPermutations_PermutationsCannotBeFoundForNullOrZeroCharacterisedString_String() throws PermutationsCannotBeFoundForNullOrZeroCharacterisedString {
		Utility.iterativePermutations("a");
	}
	
	@Test
	public void testStringPermutations_IterativePermutations_String() throws PermutationsCannotBeFoundForNullOrZeroCharacterisedString {
		List<String> iterative = Arrays.asList("tca","cta","cat","tac","atc","act");
		assertThat(iterative, is(Utility.iterativePermutations("cat")));
	}
	
	@Test
	public void testStringPermutations_IterativeAndRecursiveAreEqual_IterativeAndRecursivePermutations() throws PermutationsCannotBeFoundForNullOrZeroCharacterisedString {
		List<String> iterativeListOfPermutations = Utility.iterativePermutations("cat");
		String[] recursiveArrayOfPermutations = new String[100];
		recursiveArrayOfPermutations = Utility.recursivePermutations("", "cat");
		boolean equals = true;
		assertEquals(equals, Utility.checkIterativeAndRecursivePermutationEquals(iterativeListOfPermutations, recursiveArrayOfPermutations));
	}
	
	@Test
	public void testStringPermutations_IterativeAndRecursiveAreNotEqual_IterativeAndRecursivePermutations() throws PermutationsCannotBeFoundForNullOrZeroCharacterisedString {
		List<String> iterativeListOfPermutations = Utility.iterativePermutations("cat");
		String[] recursiveArrayOfPermutations = new String[100];
		recursiveArrayOfPermutations = Utility.recursivePermutations("", "Dog");
		boolean equals = false;
		assertEquals(equals, Utility.checkIterativeAndRecursivePermutationEquals(iterativeListOfPermutations, recursiveArrayOfPermutations));
}

}
