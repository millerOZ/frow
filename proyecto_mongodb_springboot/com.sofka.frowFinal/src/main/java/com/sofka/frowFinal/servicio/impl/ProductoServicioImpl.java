package com.sofka.frowFinal.servicio.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoInterfaz;
import com.sofka.frowFinal.servicio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoInterfaz{
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	@Override
	public void agregarProducto(Producto producto) {
		productoRepositorio.save(producto);
	}

	@Override
	public void editarProducto(ObjectId id, Producto producto) {
		
	}

	@Override
	public List<Producto> getProductos() {
		return productoRepositorio.findAll();
	}

}
