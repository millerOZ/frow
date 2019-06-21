package com.sofka.frowFinal.modelo;

import javax.validation.constraints.NotBlank;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto")
public class Producto {
	@Id
	private ObjectId _id;
	@NotBlank
	private String nombre;
	private String talla;
	private String color;
	private String precio;
	
	public Producto() {}

	public Producto(ObjectId _id, String nombre, String talla, String color, String precio) {
		this._id = _id;
		this.nombre = nombre;
		this.talla = talla;
		this.color = color;
		this.precio = precio;
	}
	public Producto(String nombre, String talla, String color, String precio) {
		this.nombre = nombre;
		this.talla = talla;
		this.color = color;
		this.precio = precio;
	}
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
}
