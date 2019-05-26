package com.herco.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herco.cursomc.domain.Pagamento;

// Apenas o pagamento da super classe, nao precisa da(s) subclasse(s)

@Repository 											// type, tipoDoatributoIdentificador
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	// Esse objeto do pode fazer operações de acesso a dado referente ao objeto catedoria
}
