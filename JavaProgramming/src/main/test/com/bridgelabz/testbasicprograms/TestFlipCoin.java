package com.bridgelabz.testbasicprograms;
import org.junit.Test;

import com.bridgelabz.basicprogramming.utils.Utility;
import com.bridgelabz.exceptions.NegativeOrZeroNumberFoundException;
public class TestFlipCoin {
	
	@Test(expected=NegativeOrZeroNumberFoundException.class)
	public void testFlipCoin_NegativeOrZeroNumberFoundException_0() throws NegativeOrZeroNumberFoundException {
		Utility.flipCoin(0);
	}
	
	@Test(expected=NegativeOrZeroNumberFoundException.class)
	public void testFlipCoin_NegativeOrZeroNumberFoundException_Negative2() throws NegativeOrZeroNumberFoundException {
		Utility.flipCoin(-2);
	}
	
}
