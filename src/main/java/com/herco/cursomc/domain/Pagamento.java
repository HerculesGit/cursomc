package com.herco.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.herco.cursomc.domain.enums.EstadoPagamento;


/*
 * Tem duas abordagens para o Inheritance => Criar um tabelao, que é o que está, ou criar uma tabela para cada classe
 * Se tiver muitos atributos criar uma tabela para cada, senao, faz uma juncao
 * 
 * */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // para mapeamento em heranca
public abstract class Pagamento implements Serializable { // nao precisa colocar implements nas subclasses apenas o numero de versao
	private static final long serialVersionUID = 1L;
	
	@Id // nao colocamos aquei generate e tals porque o pagamento tem que ter o id dele sendo o mesmo do pedido correspondente
	private Integer id;
	private Integer estado; // o estado aqui é inteiro,
	
	// isso tudo garantimos que o id do pagamento seja o mesmo que o id do pedido
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
