package com.herco.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/categorias") // o nome seria o nome da classe só que no plural. Esse é nosso end-point
public class CategoriaResource {
	
	// GET -  obter dados
	// POST - salvar ou criar novo recurso
	// REMOVE - remover
	@RequestMapping(method = RequestMethod.GET) // para isso ser uma funcao REST temos que associar ela com um dos verbos http
	public String listas() {
		return "REST está funcionando!";
	}
	
	
}
