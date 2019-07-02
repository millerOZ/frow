package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"nombre\":\"ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void testjsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"nombre\":\"ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	@Test
	public void testjsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"nombre\":\"ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	@Test
	public void testjsonAssert_WithtEscapeChacters() throws JSONException {
		String expectedResponse = "{id: 1,nombre:ball,price:10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
}
