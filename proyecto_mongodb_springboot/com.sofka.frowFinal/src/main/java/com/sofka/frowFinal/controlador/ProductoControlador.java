package com.sofka.frowFinal.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sofka.frowFinal.modelo.Producto;
import com.sofka.frowFinal.servicio.ProductoInterfaz;
import com.sofka.frowFinal.util.CampoErrorMensaje;

@CrossOrigin
@RestController
@RequestMapping("/producto")
public class ProductoControlador {
	@Autowired
	private ProductoInterfaz productoInterfaz;
	
	@GetMapping
	public List<Producto> getProductos(){
		return productoInterfaz.getProductos();
	}
	@GetMapping("/{idproducto}")
	public Optional<Producto> consultaProducto(@PathVariable(value = "idproducto") ObjectId idproducto) {
		return  productoInterfaz.consultaProducto(idproducto);
	}
	@PostMapping
	public void agregarProducto(@Valid @RequestBody Producto producto) {
		productoInterfaz.agregarProducto(producto);
	}
	@PutMapping("/editar/{idproducto}")
	public void editarProducto(@PathVariable(value = "idproducto") ObjectId idproducto, @RequestBody Producto producto) {
		productoInterfaz.editarProducto(idproducto, producto);
	}
	@DeleteMapping("/{idproducto}")
	public void eliminarProducto(@PathVariable(value = "idproducto") ObjectId idproducto){
		productoInterfaz.eliminarProducto(idproducto);
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	List<CampoErrorMensaje> exceptionHandler(MethodArgumentNotValidException e){
		List<FieldError> camposError = e.getBindingResult().getFieldErrors();
		List<CampoErrorMensaje> camposErrorMensaje = camposError.stream().map(campoError -> new CampoErrorMensaje(campoError.getField(),campoError.getDefaultMessage())).collect(Collectors.toList());
		return camposErrorMensaje;
	}
	
	
}
