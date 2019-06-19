package com.sofka.frowFinal.controlador;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoInterfaz;

@CrossOrigin
@RestController
@RequestMapping("/producto")
public class ProductoControlador {
	@Autowired
	private ProductoInterfaz productoInterfaz;
	
	@GetMapping
	public List<Producto> getProducto(){
		return productoInterfaz.getProductos();
	}
	@PostMapping
	public void agregarProducto(@RequestBody Producto producto) {
		productoInterfaz.agregarProducto(producto);
	}
	@PutMapping("/editar/{idproducto}")
	public void editarProducto(@PathVariable(value = "idproducto") ObjectId idproducto, @RequestBody Producto producto) {
		productoInterfaz.editarProducto(idproducto, producto);
	}
}
