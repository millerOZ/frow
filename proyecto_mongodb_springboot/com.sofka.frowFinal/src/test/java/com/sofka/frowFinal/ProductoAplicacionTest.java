package com.sofka.frowFinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.sofka.frowFinal.controlador.ProductoControlador;
import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoRepositorio;
import com.sofka.frowFinal.servicio.ProductoServicio;
import com.sofka.frowFinal.servicio.impl.ProductoServicioImpl;


//@RunWith(SpringRunner.class)
@WebMvcTest(ProductoControlador.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductoAplicacionTest {
	
	@Mock
	private ProductoRepositorio productoRepositorio;
	
	@Mock
	private ProductoServicio productoservicio ;
	
    @Before
    public void setUp() {
    	productoservicio = new ProductoServicioImpl(productoRepositorio);
    }
    
    List<Producto> listaProducto =new ArrayList<>();
    
    @Test
    public void testBuscarTodo() {
    	Producto producto = new Producto();
    	listaProducto.add(producto);
    	
    	when(productoRepositorio.findAll())
    			.thenReturn(listaProducto);
    	
    	Assertions.assertThat(productoservicio.getProductos()).isEqualTo(listaProducto);
    }
    @Test
    public void testListaProductoVacia() {
    	when(productoRepositorio.findAll())
				.thenReturn(listaProducto);
    	
    	Assertions.assertThat(productoservicio.getProductos()).isEmpty();
    }
    
    @Test
    public void testBuscarProductoNombre() {
    	Producto producto = new Producto("CAMISA VERDE","S","verde","$70.000");
    	listaProducto.add(producto);
    	
    	when(productoRepositorio.findByNombre(producto.getNombre()))
    	     .thenReturn(producto);
    	
    	assertEquals("CAMISA VERDE", productoservicio.findByNombre(producto.getNombre()).getNombre() );
    }
    @Test
    public void testBuscarProductoTalla() {
    	Producto producto = new Producto("CAMISA VERDE","S","verde","$70.000");
    	listaProducto.add(producto);
    	
    	when(productoRepositorio.findByNombre(producto.getTalla()))
    	     .thenReturn(producto);
    	
    	assertEquals("S", productoservicio.findByNombre(producto.getTalla()).getTalla());
    }
    @Test
    public void testCampoVacioProducto() {
    	Producto producto = new Producto("CAMISA VERDE","S",null,"$70.000");
    	listaProducto.add(producto);
    	
    	when(productoRepositorio.findByNombre(producto.getColor()))
    	     .thenReturn(producto);
    	
    	assertEquals(null, productoservicio.findByNombre(producto.getColor()).getColor());
    }
    @Test
    public void testGuardarProducto() {
    	Producto producto = new Producto("CAMISA AZUL MEDIO","S","azul","$123.000");
    	
    	when(productoRepositorio.save(producto))
    	       .thenReturn(producto);
    	
    	Assertions.assertThat(productoservicio.guardar(producto));
    }
    
	@Test
    public void testTamanioListaProducto() {
		List<Producto> listaProductos =new ArrayList<>();
		Producto producto = new Producto("CAMISA VERDE","S","verde","$70.000");
		Producto producto2 = new Producto();
    	listaProductos.add(producto);
    	listaProductos.add(producto2);
    	
    	when(productoRepositorio.findAll())
    	     .thenReturn(listaProductos);
    	
    	assertEquals(2, productoservicio.getProductos().size());
	}
    
    @Test
    public void testeditarProducto() {}
    
    
}
