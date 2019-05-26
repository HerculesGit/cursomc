package com.herco.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.herco.cursomc.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpfOuCnpj;
	private String email;
	
	// tipo cliente, internamente colocamos como inteiro, mas externamente ela vai mandar um TipoCliente
	private Integer tipo;
	
	// cleinte tem varios enderecos
	@JsonManagedReference // proteger contra serialização Json cíclica | /o cliente pode serelizar o endereco e lá na classe Endereco dizemos que o Endereco não pode serializar o Cliente
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	// cliente pode ter um ou mais telefones
	// Telefone tem apenas um atributo, então optou-se por não usar
	@ElementCollection // forma do spring mapear isso para o banco, essa entidade fraca
	@CollectionTable(name = "TELEFONE") // assim ele vai criar uma tabela telefone a partir da lista Set que temos a baixo
	private Set<String> telefones = new HashSet<>(); // Set é um conjunto, ele nao pode se repetir, então já estamos garantingo que não irá se repetir
	
	
	// cliente tem pedidos
	@OneToMany(mappedBy = "cliente") // foi mapeado pelo cliente
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {}

	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.setEmail(email);
		this.tipo = tipo.getCod();
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}
	
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
