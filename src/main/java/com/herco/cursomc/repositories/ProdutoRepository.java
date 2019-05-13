package com.herco.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herco.cursomc.domain.Produto;;

@Repository 											// type, tipoDoatributoIdentificador
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	// Esse objeto do pode fazer operações de acesso a dado referente ao objeto Produto
}
