package com.in28minutes.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":10000,\"name\":\"pencil\",\"quantity\":5}," + 
				"{\"id\":10001,\"name\":\"pen\",\"quantity\":15}," + 
				"{\"id\":10002,\"name\":\"Erase\",\"quantity\":10}" + 
				"]";
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		
		assertThat(ids).containsExactly(10000,10001,10002);
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Erase')]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
	}
}	
