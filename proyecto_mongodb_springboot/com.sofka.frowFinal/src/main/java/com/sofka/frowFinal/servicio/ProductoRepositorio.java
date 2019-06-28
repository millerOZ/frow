package com.sofka.frowFinal.servicio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sofka.frowFinal.modelo.Producto;

@Repository
public interface ProductoRepositorio extends MongoRepository<Producto, ObjectId> {

	Producto findByNombre(String nombre);
}
