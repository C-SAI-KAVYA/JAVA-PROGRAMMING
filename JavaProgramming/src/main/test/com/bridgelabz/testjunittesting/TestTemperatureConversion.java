package com.bridgelabz.testjunittesting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.bridgelabz.exceptions.UnsupportedTemparatureEnteredException;
import com.bridgelabz.junittesting.ConvertedTemperatureWithType;
import com.bridgelabz.junittesting.utils.Utility;

public class TestTemperatureConversion {
	
	@Test(expected = UnsupportedTemparatureEnteredException.class)
	public void testTemperatureConversion_UnsupportedTemparatureEnteredException_45point76Anda() throws UnsupportedTemparatureEnteredException{
		Utility.temperaturConversion(45.76, 'a');
	}
	@Test
	public void testTemperatureConversion_Minus10point922222222222222Andc_12point34Andf() throws UnsupportedTemparatureEnteredException {
		ConvertedTemperatureWithType expected = new ConvertedTemperatureWithType(-10.922222222222222, 'c');
		ConvertedTemperatureWithType actual = Utility.temperaturConversion(12.34, 'f');
		assertThat(expected).isEqualToComparingFieldByField(actual);
	}
	
	@Test
	public void testTemperatureConversion_94point208Andf_34point56andc() throws UnsupportedTemparatureEnteredException {
		ConvertedTemperatureWithType expected = new ConvertedTemperatureWithType(94.208, 'f');
		ConvertedTemperatureWithType actual = Utility.temperaturConversion(34.56, 'c');
		assertThat(expected).isEqualToComparingFieldByField(actual);
	}

}
