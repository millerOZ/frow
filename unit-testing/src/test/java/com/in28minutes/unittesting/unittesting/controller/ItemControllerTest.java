package com.in28minutes.unittesting.unittesting.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void testhelloWorld_basic() throws Exception {
		RequestBuilder resquest = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(resquest)
				.andExpect(status().is(200))
				.andExpect(content().json("{\"id\": 1,\"nombre\":\"ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
//		assertEquals("{\"id\":1,\"nombre\":\"ball\",\"price\":10,\"quantity\":100}", result.getResponse().getContentAsString());
	}
	@Test
	public void testFromBusinessService_basic() throws Exception {
		
		when(businessService.retreiveHardCodedItem())
				.thenReturn(new Item(2,"Item2",10,10));
		
		RequestBuilder resquest = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(resquest)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,nombre:Item2,price:10}"))
				.andReturn();
	}
	@Test
	public void testAllItems_basic() throws Exception {
		
		when(businessService.retrieveAllItems())
			.thenReturn(Arrays.asList(new Item(2,"Item2",10,10),
					    			  new Item(3,"Item3",20,20)));
			
		RequestBuilder resquest = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(resquest)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2,nombre:Item2,price:10},{id:3,nombre:Item3,price:20}]"))
				.andReturn();
	}
}
