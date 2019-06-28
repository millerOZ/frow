package com.sofka.frowFinal.servicio.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

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
			productoRepositorio.save(producto);
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
	public Producto guardar(Producto producto) {
		return productoRepositorio.save(producto);
	}

//	@Override
//	public Optional<Producto> consultaPorId(ObjectId id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Optional<Producto> consultaProductoId(ObjectId idproducto) {
		return productoRepositorio.findById(idproducto);
	}

	@Override
	public Producto findByNombre(String nombre) {
		return productoRepositorio.findByNombre(nombre);
	}
 
}
