package com.in28minutes.unittesting.unittesting.business;

import java.util.Arrays;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int CalculateSum(int [] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0); //-> programacion funcional
//		int sum = 0;
//		for(int value:data) {
//			sum += value;
//		}
//		return sum;  
	}
	
	public int CalculateSumUsingDataService() {
		int sum = 0;
		int [] data = someDataService.retrieveAllData();
		for(int value:data) {
			sum += value;
		}
		return sum;  
	}
}
