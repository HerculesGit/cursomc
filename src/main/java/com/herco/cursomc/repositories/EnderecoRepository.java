package com.herco.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herco.cursomc.domain.Endereco;

@Repository 											// type, tipoDoatributoIdentificador
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	// Esse objeto do pode fazer operações de acesso a dado referente ao objeto catedoria
}
