package com.example.baozirest.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Double preco;

	// true = possui estoque
	// false = sem estoque
	private Boolean estoque;

	
	public Produto() {
	}

	
	public Produto(Long id, String nome, Double preco, Boolean estoque) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Double getPreco() {
		return preco;
	}

	
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	public Boolean getEstoque() {
		return estoque;
	}

	
	public void setEstoque(Boolean estoque) {
		this.estoque = estoque;
	}

	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", estoque=" + estoque + "]";
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(estoque, id, nome, preco);
	}

	
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Produto other = (Produto) obj;

		return Objects.equals(estoque, other.estoque)
				&& Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}
}