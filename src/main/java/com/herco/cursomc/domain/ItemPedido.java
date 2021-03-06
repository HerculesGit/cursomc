package com.herco.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/*
 * Lembrando que essa classe é foi criada porque sao 1 para muitos ou muitos para muitos
 * Foi criada da relacao produto e pedido
 * */ 
@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	// o id dela é a classe auxiliar; É um atributo composto
	@EmbeddedId // id embutido em um tipo auxiliar
	private ItemPedidoPK id = new ItemPedidoPK(); 
	
	private double desconto;
	private double preco;
	private Integer quantidade;
	
	
	public ItemPedido() { }
	
	public ItemPedido(Pedido pedido, Produto produto, double desconto, double preco, Integer quantidade) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}

	public Produto getProduto() {
		return id.getProduto();
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
