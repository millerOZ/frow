package com.sofka.frowFinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoRepositorio;
import com.sofka.frowFinal.servicio.ProductoServicio;

@RunWith(SpringRunner.class)
public class ProductoServiciosTest {
	@Mock
	ProductoServicio productoServicio;
	
	@Mock
	ProductoRepositorio productoRepositorio;
	
	List<String> mock = mock(List.class);
	List<Producto> listaProducto =  new ArrayList<>();
	
	@Test
	public void testBusquedaNombre() {
    	Producto producto = new Producto("CAMISA VERDE","S","verde","$70.000");
		
    	when(productoServicio.findByNombre(producto.getNombre())).thenReturn(producto);
		
		assertEquals("CAMISA VERDE", producto.getNombre());
	}

	@Test
	public void testTamanioListaProducto() {
		Producto productoJuan = new Producto();
		Producto productoMiller = new Producto("CAMISA VERDE","S","verde","$70.000");
		 
		listaProducto.add(productoJuan);
		listaProducto.add(productoMiller);
		 
		when(mock.size()).thenReturn(2);
		
		assertEquals(2,listaProducto.size());
	}
	@Test
	public void testEliminarProducto() {
		Producto producto = new Producto("CAMISA VERDE","S","verde","$70.000");
		
		if(productoServicio.consultaProductoId(producto.get_id()).isPresent()) {
			 
			productoRepositorio.deleteById(producto.get_id() );
			   
			 verify(productoRepositorio,times(1)).deleteById(producto.get_id());
		
		}else {
			System.out.println("Error producto no existe");
		}
	}
	@Test
	public void testEliminarProductoDB() {
		Producto producto = new Producto("CAMISA VERDE","S","verde","$70.000");
		
		if(productoServicio.consultaProductoId(producto.get_id()).isPresent()) {
			 
			productoRepositorio.deleteById(producto.get_id() );
			   
			 verify(productoRepositorio,times(1)).deleteById(producto.get_id());
		
		}else {
			System.out.println("Error producto no existe");
		}
	}
	@Test
	public void testEliminarTodosProducto() {
		productoRepositorio.deleteAll();
	    verify(productoRepositorio,times(1)).deleteAll(); 
	}
	@Test
	public void testEditarProducto() {
		Producto producto = new Producto("CAMISA VERDE","S","verde","$70.000");
		ObjectId id = producto.get_id();
		
		producto.setNombre("CAMISA ROJA");
		
		productoServicio.editarProducto(id, producto);
		
		System.out.println(producto.getNombre());
		
		verify(productoServicio,times(1)).editarProducto(id,producto);
	}

}
