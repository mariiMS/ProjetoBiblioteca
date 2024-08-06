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
import com.biblioteca.model.Livro;
import com.biblioteca.repository.ClienteRepository;
import com.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("/clientes")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	    @GetMapping
	    public List<Livro> listarProdutos() {
	        return livroRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Livro> buscarProduto(@PathVariable Long id) {
	        Optional<Livro> produto = livroRepository.findById(id);
	        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Livro inserirProduto(@RequestBody Livro livro) {
	        return livroRepository.save(livro);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Livro> atualizarCliente(@PathVariable Long id, @RequestBody Livro livro) {
	        return livroRepository.findById(id)
	                .map(livroExistente -> {
	                	livroExistente.setTitulo(livro.getTitulo());
	                    Livro livroAtualizado = livroRepository.save(livro);
	                    return ResponseEntity.ok(livroExistente);
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }


}
