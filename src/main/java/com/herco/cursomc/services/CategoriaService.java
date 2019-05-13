package com.herco.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herco.cursomc.domain.Categoria;
import com.herco.cursomc.exception.ObjectNotFoundException;
import com.herco.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	// isso quer dizer que essa dependencia será instanciada pelo spring
	@Autowired
	private CategoriaRepository repo;
	
	// capas de buscar por codigo
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
