package com.sofka.frowFinal.servicio;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.sofka.frowFinal.modelo.Producto;
@Service
public interface ProductoServicio {
	
	public List<Producto> getProductos();
	public Producto guardar(Producto producto);
	public void agregarProducto(Producto producto);
	public void editarProducto(ObjectId id,Producto producto);
	public void eliminarProducto(ObjectId id);
	public Optional<Producto> consultaProductoId(ObjectId idproducto);
	public Producto findByNombre(String nombre);
}














