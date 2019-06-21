/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.sofka.frowFinal;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.sofka.frowFinal.controlador.ProductoControlador;
import com.sofka.frowFinal.modelo.Producto;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoAplicacionTest {
	
	@Autowired
	ProductoControlador productoControlador;
	
	@Test
    public void testErrorHandlingReturnBadRequest() {
    	RestTemplate restTemplate = new RestTemplate();
    	String url = "http://localhost:8080/producto";
    	try {
    		restTemplate.getForEntity(url,String.class);
    	}catch(HttpClientErrorException e){
    		Assert.assertEquals(HttpStatus.BAD_REQUEST,  e.getStatusCode());
    	}
    }
	
	@Test
	public void contextLoads() {
		Assert.assertNotNull(productoControlador);
	}
    @Test
    public void testCrearProducto() {
    	RestTemplate restTemplate = new RestTemplate();
    	String url = "http://localhost:8080/producto";
    	
    	Producto producto = new Producto("PantalonAzul","M","Azul","150000");
    	ResponseEntity<Producto> entity = restTemplate.postForEntity(url, producto, Producto.class);
    	
    	Producto[] productos = restTemplate.getForObject(url, Producto[].class);
    	Assertions.assertThat(productos).extracting(Producto::getNombre).containsOnly("PantalonAzul");
    	
//    	restTemplate.delete(url,"/"+entity.getBody().get_id());
//    	Assertions.assertThat(restTemplate.getForObject(url, Producto[].class)).isEmpty();
    }
    
    @Test
    public void testgetProducto() {}
    
    @Test
    public void testeditarProducto() {}
    @Test 
    public void testtAgregarProducto() {
        ProductoAplicacion classUnderTest = new ProductoAplicacion();
//        assertcTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
    
}
