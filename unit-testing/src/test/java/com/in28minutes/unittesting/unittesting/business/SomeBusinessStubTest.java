package com.in28minutes.unittesting.unittesting.business;

import org.junit.Assert;
import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService{
	@Override
	public int[] retrieveAllData() {
		return new int [] {1,2,3};
	}
}

public class SomeBusinessStubTest {
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.CalculateSumUsingDataService();
		int expectedResult = 6;
		Assert.assertEquals(expectedResult, actualResult);
	}
}
