package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessTest {
	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.CalculateSum(new int [] {1,2,3});
		int expectedResultado = 6;
		assertEquals(expectedResultado, actualResult);
	}
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.CalculateSum(new int [] {});
		int expectedResultado = 0;
		assertEquals(expectedResultado, actualResult);
	}
	@Test
	public void calculateSum_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.CalculateSum(new int [] {5});
		int expectedResultado = 5;
		assertEquals(expectedResultado, actualResult);
	}
}
