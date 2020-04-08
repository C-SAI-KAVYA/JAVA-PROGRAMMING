package com.bridgelabz.java8.lambdaexpressions;

/**
 * 1) Lambda expressions can have zero one or more parameters
 * 2) Type of the parameters can be explicitly declared or it can be infered from the context
 * 3) Multiple parameters are enclosed in mandatory parenthesis and separated by commas. 
 * 	->Empty parenthesis are used to represent an empty set of parameters
 * 4) When there is a single parameters, if its type is inferred, it is not mandatory to use parentheses 
 * 5) The body of the lambda expressions can contain zero, one or more statements.
 * 6) If body of lambda expression has single statement curly brackets are not mandatory and
 * 	->the return type of the anonymous function is the same as that of the body expression. 
 * 	->When there is more than one statement in the body than these must be enclosed in curly brackets.
 * @author DELL
 *
 */
@FunctionalInterface
interface Greetings{
	String hello(String name1, String name2);
}

public class LambdaExpressions {
	public static void main(String[] args) {
		
		Greetings greetings = (name1, name2)-> "hi "+name1+name2;
		System.out.println(greetings.hello("Cherry","Dcruz"));
	
	}
}
