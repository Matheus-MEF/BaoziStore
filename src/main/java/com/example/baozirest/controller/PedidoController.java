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

import com.example.baozirest.model.Pedido;
import com.example.baozirest.repository.PedidoRepository;

@RestController
@RequestMapping({ "/pedidos" })
public class PedidoController {

	private PedidoRepository repository;

	// Injeção de dependência
	PedidoController(PedidoRepository pedidoRepository) {
		this.repository = pedidoRepository;
	}

	// LISTAR TODOS OS PEDIDOS
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}

	// BUSCAR PEDIDO POR ID
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {

		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	// CADASTRAR PEDIDO
	@PostMapping
	public Pedido create(@RequestBody Pedido pedido) {
		return repository.save(pedido);
	}
	// ========================= ATUALIZAR PEDIDO =========================
	// A anotação @PutMapping indica que este método será chamado
	// O "/{id}" significa que a URL precisa receber um id. Exemplo:PUT http://localhost:8080/pedidos/1
	@PutMapping(value = "/{id}")
	// ResponseEntity<?> permite controlar a resposta HTTP.
	// Pode retornar:  - 200 OK ou  - 404 NOT FOUND
	public ResponseEntity<?> update(
	        // @PathVariable pega o valor da URL.
	        // Exemplo: /pedidos/1 -> id = 1
	        @PathVariable("id") long id,
	        // @RequestBody converte o JSON enviado no Postman
	        // em um objeto Java do tipo Pedido.
	        @RequestBody Pedido pedido) {

	    // repository.findById(id)  procura no banco um pedido com esse id.
	    // O retorno é um Optional<Pedido>, porque o pedido pode existir ou não.
	    return repository.findById(id).map(record -> {
	        // "record" representa o pedido encontrado no banco.
	        // Atualiza o clienteId do pedido encontrado
	        record.setClienteId(pedido.getClienteId());
	        // Atualiza o produtoId
	        record.setProdutoId(pedido.getProdutoId());
	        // Atualiza a quantidade
	        record.setQuantidade(pedido.getQuantidade());
	        
	        // repository.save(record)  salva as alterações no banco.
	        // Como o objeto já possui ID,
	        // o JPA entende que é uma atualização (UPDATE) e não um novo INSERT.
	        Pedido updated = repository.save(record);
	        // Retorna HTTP 200 OK  junto do objeto atualizado.	        
	        return ResponseEntity.ok().body(updated);
	    })

	    // Caso o id não exista no banco, retorna HTTP 404 NOT FOUND.	    
	    .orElse(ResponseEntity.notFound().build());
	}

	// ========================= DELETAR PEDIDO =========================
	// @DeleteMapping responde a requisições HTTP DELETE. Exemplo: DELETE http://localhost:8080/pedidos/1
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
	    // Procura o pedido pelo id.
	    return repository.findById(id).map(record -> {
	        // Se encontrou:  remove o registro do banco.
	        repository.deleteById(id);
	        // Retorna HTTP 200 OK sem conteúdo.
	        return ResponseEntity.ok().build();

	    })

	    // Caso o pedido não exista, retorna HTTP 404 NOT FOUND.
	    .orElse(ResponseEntity.notFound().build());
	}
}