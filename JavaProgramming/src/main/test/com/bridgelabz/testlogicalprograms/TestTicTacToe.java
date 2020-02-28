package com.bridgelabz.testlogicalprograms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.errors.UnspecifiedOptionSelectedError;
import com.bridgelabz.logicalprograms.utils.Utility;

public class TestTicTacToe {
	
	@Test(expected = UnspecifiedOptionSelectedError.class)
	public void testTicTacToe_UnspecifiedOptionSelectedError_3And4() {
		Utility.playTicTacToe();
	}
	
	@Test
	public void testTicTacToe_playerWon_1And0And0And0And2And0() {
		String expected = "player won";
		assertEquals(expected, Utility.playTicTacToe());
	}

}
