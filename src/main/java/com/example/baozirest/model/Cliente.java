package com.example.baozirest.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String fone;

	private LocalDate clienteDesde;

	
	public Cliente() {
	}

	
	public Cliente(Long id, String name, String email, String fone, LocalDate clienteDesde) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.fone = fone;
		this.clienteDesde = clienteDesde;
	}


	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getFone() {
		return fone;
	}

	
	public void setFone(String fone) {
		this.fone = fone;
	}

	
	public LocalDate getClienteDesde() {
		return clienteDesde;
	}

	
	public void setClienteDesde(LocalDate clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(clienteDesde, email, fone, id, name);
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

		return Objects.equals(clienteDesde, other.clienteDesde)
				&& Objects.equals(email, other.email)
				&& Objects.equals(fone, other.fone)
				&& Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	
	@Override
	public String toString() {
		return "Cliente [id=" + id 
				+ ", name=" + name 
				+ ", email=" + email 
				+ ", fone=" + fone
				+ ", clienteDesde=" + clienteDesde 
				+ "]";
	}
}
