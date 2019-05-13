package com.herco.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herco.cursomc.domain.Cidade;

@Repository 											// type, tipoDoatributoIdentificador
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	// Esse objeto do pode fazer operações de acesso a dado referente ao objeto catedoria
}
