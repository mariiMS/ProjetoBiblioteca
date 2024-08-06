package com.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Cliente;
import com.biblioteca.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	    @GetMapping
	    public List<Cliente> listarProdutos() {
	        return clienteRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Cliente> buscarProduto(@PathVariable Long id) {
	        Optional<Cliente> produto = clienteRepository.findById(id);
	        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Cliente inserirProduto(@RequestBody Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
	        return clienteRepository.findById(id)
	                .map(clienteExistente -> {
	                	clienteExistente.setNome(cliente.getNome());
	                    Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
	                    return ResponseEntity.ok(clienteExistente);
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

//	    @DeleteMapping("/{id}")
//	    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
//	        return clienteRepository.findById(id)
//	                .map(cliente -> {
//	                	clienteRepository.delete(cliente);
//	                	
//	                    return ResponseEntity.noContent().build();
//	                })
//	                .orElseGet(() -> ResponseEntity.notFound().build());
//	    }

}
