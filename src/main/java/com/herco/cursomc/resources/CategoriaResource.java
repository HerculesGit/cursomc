package com.herco.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herco.cursomc.domain.Categoria;

@RestController
@RequestMapping(value= "/categorias") // o nome seria o nome da classe só que no plural. Esse é nosso end-point
public class CategoriaResource {
	
	// GET -  obter dados
	// POST - salvar ou criar novo recurso
	// REMOVE - remover
	@RequestMapping(method = RequestMethod.GET) // para isso ser uma funcao REST temos que associar ela com um dos verbos http
	public List<Categoria> listas() {
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
	
	
}
