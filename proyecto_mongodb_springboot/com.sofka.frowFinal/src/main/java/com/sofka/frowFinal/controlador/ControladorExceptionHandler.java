package com.sofka.frowFinal.controlador;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sofka.frowFinal.util.ErrorMensage;

@ControllerAdvice
public class ControladorExceptionHandler {
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	ErrorMensage exceptionHandler(ValidationException e) {
		return new ErrorMensage("400",e.getMessage());
	}
}
