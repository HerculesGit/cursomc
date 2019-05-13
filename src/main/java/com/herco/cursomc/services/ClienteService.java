package com.herco.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herco.cursomc.domain.Cliente;
import com.herco.cursomc.exception.ObjectNotFoundException;
import com.herco.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	// isso quer dizer que essa dependencia será instanciada pelo spring
	@Autowired
	private ClienteRepository repo;
	
	// capas de buscar por codigo
	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
