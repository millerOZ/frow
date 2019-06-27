package com.sofka.frowFinal;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sofka.frowFinal.controlador.ProductoControlador;
import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoServicio;
import com.sofka.frowFinal.servicio.ProductoRepositorio;
import com.sofka.frowFinal.servicio.impl.ProductoServicioImpl;

import junit.framework.Assert;

//@SuppressWarnings("deprecation")	
//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
@SuppressWarnings("unused")
public class ProductoAplicacionTest {
	@Mock
	private ProductoRepositorio productoRepositorio;
	@Mock
	private ProductoServicio productoservicio;
	
    @Autowired
	ProductoControlador productoControlador;
	
    @Before
    public void setUp() {
    	productoservicio = new ProductoServicioImpl(productoRepositorio);
    }
    @Test
    public void testBuscarTodo() {
    	List<Producto> listaProducto =new ArrayList<>();
    	Producto producto = new Producto();
    	listaProducto.add(producto);
    	
    	Mockito.when(productoRepositorio.findAll())
    			.thenReturn(listaProducto);
    	Assertions.assertThat(productoservicio.getProductos()).isEqualTo(listaProducto);
    }
    @Test
    public void testListaProductoVacia() {
    	List<Producto> listaProducto =new ArrayList<>();
    	
    	Mockito.when(productoRepositorio.findAll())
		.thenReturn(listaProducto);
    	
    	Assertions.assertThat(productoservicio.getProductos()).isEmpty();
    }
    @Test
    public void testGuardarProducto() {
    	Producto producto = new Producto("CAMISA AZUL MEDIO","S","azul","$123.000");
    	
    	Mockito.when(productoRepositorio.save(producto))
    	       .thenReturn(producto);
    	Assertions.assertThat(productoservicio.guardar(producto));
    }
    
//    @Test
//    public void testTamanioListaProducto() {
//    	List<Producto> listaProducto = new ArrayList<>();
//    	Producto producto = new Producto();
//    	listaProducto.add(producto);
//    	
//    	Mockito.when(productoRepositorio.findAll())
//		.thenReturn(listaProducto);
//    	Assertions.(productoInterfaz.getProductos());
//    	
//    	
//    }
    
    
    @Test
    public void testeditarProducto() {}
    
    
}
