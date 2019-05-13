package com.herco.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.herco.cursomc.exception.ObjectNotFoundException;

@ControllerAdvice // para exception. 
public class ResourceExceptionHandler { // nosso manipulador de erros
	
	// criamos um metodo que recebe um ObjectNotFound e que recebe um HttpServletRequest
	// Esse é o padrão dentro do framework
	@ExceptionHandler(ObjectNotFoundException.class) // indicando que é um tratador desse tipo de exception
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	
}
