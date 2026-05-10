package com.example.baozirest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.baozirest.model.Produto;
import com.example.baozirest.repository.ProdutoRepository;

@RestController
@RequestMapping({ "/produtos" })
public class ProdutoController {

	private ProdutoRepository repository;

	
	public ProdutoController(ProdutoRepository repository) {
		this.repository = repository;
	}

	
	// LISTAR TODOS OS PRODUTOS
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}

	
	// BUSCAR PRODUTO POR ID
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {

		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	
	// CADASTRAR PRODUTO
	@PostMapping
	public Produto create(@RequestBody Produto produto) {
		return repository.save(produto);
	}

	
	// ATUALIZAR PRODUTO
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id,
			@RequestBody Produto produto) {

		return repository.findById(id).map(record -> {

			record.setNome(produto.getNome());
			record.setPreco(produto.getPreco());
			record.setEstoque(produto.getEstoque());

			Produto updated = repository.save(record);

			return ResponseEntity.ok().body(updated);

		}).orElse(ResponseEntity.notFound().build());
	}

	
	// DELETAR PRODUTO
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {

		return repository.findById(id).map(record -> {

			repository.deleteById(id);

			return ResponseEntity.ok().build();

		}).orElse(ResponseEntity.notFound().build());
	}
}