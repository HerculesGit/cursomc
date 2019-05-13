package com.herco.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herco.cursomc.domain.Cliente;
import com.herco.cursomc.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value= "/clientes") // o nome seria o nome da classe só que no plural. Esse é nosso end-point
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	// GET -  obter dados
	// POST - salvar ou criar novo recurso
	// REMOVE - remover
	
	// esse nosso endpoint terá assim:
	// /categorias/id
	@RequestMapping(value="/{id}", method = RequestMethod.GET) // para isso ser uma funcao REST temos que associar ela com um dos verbos http
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException { // ele saiba que o id da url vá para o id da variavel usamos pathVariable
		
		Cliente obj = service.buscar(id);
		
		// estamos dizendo que a resposta foi ok e que o corpo dela será nosso objeto Cliente
		return ResponseEntity.ok().body(obj);
	}
	
	
}
