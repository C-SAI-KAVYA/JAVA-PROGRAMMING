package com.bridgelabz.testjunittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bridgelabz.exceptions.ChangeCannotBeCalculatedForZeroOrNegativeException;
import com.bridgelabz.junittesting.utils.Utility;


public class TestVendingMachine {
	
//	@Test
//	public void testVendingMachine_4_1023() throws ChangeCannotBeCalculatedForZeroOrNegativeException {
//		assertEquals(4, Utility.vendingMachine(1023, Utility.notes));
//	}
	
//	@Test
//	public void testVendingMachine_4_532() throws ChangeCannotBeCalculatedForZeroOrNegativeException {
//		assertEquals(4, Utility.vendingMachine(532, Utility.notes));
//	}
	
	@Test
	public void testVendingMachine_4_123() throws ChangeCannotBeCalculatedForZeroOrNegativeException {
		assertEquals(4, Utility.vendingMachine(123, Utility.notes));
	}
	
}
