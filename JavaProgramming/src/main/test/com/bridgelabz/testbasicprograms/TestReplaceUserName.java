package com.bridgelabz.testbasicprograms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.NameNotFoundException;

public class TestReplaceUserName {
	@Test
	public void testReplaceUserName() {
		String expected="Hello cherry, How are you ??";
		try {
			assertEquals(expected,Utility.replaceUserName("Hello <<UserName>>, How are you ??","<<UserName>>","cherry"));
		} catch (NameNotFoundException e) {
			e.getMessage();
		}
	}
	
}
