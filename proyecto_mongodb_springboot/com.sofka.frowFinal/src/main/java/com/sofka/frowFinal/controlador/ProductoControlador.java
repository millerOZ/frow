package com.sofka.frowFinal.controlador;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoServicio;

@CrossOrigin
@RequestMapping("/producto") 
@RestController
public class ProductoControlador {
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping
	public List<Producto> getProductos(){
		return productoServicio.getProductos();
	}
	@GetMapping("/{idproducto}")
	public Optional<Producto> consultaProducto(@PathVariable(value = "idproducto") ObjectId idproducto) {
		return  productoServicio.consultaProductoId(idproducto);
	}
	@GetMapping("/getNombre/{nombre}")
	public Producto consultaProductoPorNombre(@PathVariable(value = "nombre") String nombre) {
		return  productoServicio.findByNombre(nombre);
	}
	@GetMapping("/hello-world")
	public String helloWorld() {
		 return "Hello World";
	}
	@PostMapping
	public void agregarProducto(@RequestBody Producto producto) {
		productoServicio.agregarProducto(producto);
	}
	@PutMapping("/editar/{idproducto}")
	public void editarProducto(@PathVariable(value = "idproducto") ObjectId idproducto, @RequestBody Producto producto) {
		productoServicio.editarProducto(idproducto, producto);
	}
	@DeleteMapping("/{idproducto}")
	public void eliminarProducto(@PathVariable(value = "idproducto") ObjectId idproducto){
		productoServicio.eliminarProducto(idproducto);
	}
	
	
}
