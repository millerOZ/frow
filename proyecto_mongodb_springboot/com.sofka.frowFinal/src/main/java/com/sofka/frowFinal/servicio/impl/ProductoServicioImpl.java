package com.sofka.frowFinal.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoServicio;
import com.sofka.frowFinal.servicio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio{
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public ProductoServicioImpl(ProductoRepositorio productoRepositorio2) {
		 this.productoRepositorio = productoRepositorio2;
	}

	@Override
	public void agregarProducto(Producto producto) {
//		if(producto.getNombre() != null && producto.getColor() != null && producto.getTalla() != null && producto.getPrecio() != null)
			productoRepositorio.save(producto);
//		else throw new ValidationException("");
	}

	@Override
	public void editarProducto(ObjectId id, Producto producto) {
		productoRepositorio.findById(id).map(newProducto -> {
			newProducto.setNombre(producto.getNombre());
			newProducto.setTalla(producto.getTalla());
			newProducto.setColor(producto.getColor());
			newProducto.setPrecio(producto.getPrecio());
			return productoRepositorio.save(newProducto);
		});
	}

	@Override
	public List<Producto> getProductos() {
		return productoRepositorio.findAll();
	}

	@Override
	public void eliminarProducto(ObjectId id) {
		productoRepositorio.deleteById(id);
	}

	@Override
	public Optional<Producto> consultaProducto(ObjectId id) {
		return productoRepositorio.findById(id);
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoRepositorio.save(producto);
	}
 
}
