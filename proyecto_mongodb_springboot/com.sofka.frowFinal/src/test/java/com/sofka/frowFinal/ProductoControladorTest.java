package com.sofka.frowFinal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sofka.frowFinal.controlador.ProductoControlador;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductoControlador.class)
public class ProductoControladorTest {
	@Autowired(required=true)
	private MockMvc mockMvc;
	 
    @Test
    public void testSaludoBienvenidos() throws Exception {
    	RequestBuilder request = MockMvcRequestBuilders
    			.get("/hello-world")
    			.accept(MediaType.APPLICATION_JSON);
    	
    	MvcResult result = mockMvc.perform(request).andReturn();
    	
    	assertEquals("Hello World", result.getResponse().getContentAsString());
//    	try {
//    		
//    	} catch(NullPointerException e) {
//    		System.out.println(e.getMessage());
//    	}
    }
}
