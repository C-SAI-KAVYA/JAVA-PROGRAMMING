package com.bridgelabz.java8.lambdaexpressions;

import java.util.Arrays;

@FunctionalInterface
interface Check{
	void check(String names[]);
}

public class LambdaExpressionArrays {
	public static void main(String[] args) {
		Check check = (names)-> System.out.println(Arrays.toString(names));
		String names[] = {"cherry", "Dcruz"};
		check.check(names);
	}
}
