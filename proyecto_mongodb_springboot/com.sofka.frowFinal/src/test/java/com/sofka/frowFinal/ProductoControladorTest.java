package com.sofka.frowFinal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sofka.frowFinal.controlador.ProductoControlador;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ProductoControlador.class)
public class ProductoControladorTest {
	@Autowired
	private MockMvc mockMvc;
	 
    @Test
    public void testSaludoBienvenidos() throws Exception {
    	RequestBuilder request = MockMvcRequestBuilders
    			.get("/home")
    			.accept(MediaType.APPLICATION_JSON);
    	
    	MvcResult result = mockMvc.perform(request).andReturn();
    	
    	assertEquals("BIENVENIDOS", result.getResponse().getContentAsString());
    	try {
    		
    	} catch(NullPointerException e) {
    		System.out.println(e.getMessage());
    	}
    }
}
