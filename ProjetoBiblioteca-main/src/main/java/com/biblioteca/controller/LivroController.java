package com.biblioteca.controller;

import com.biblioteca.response.ApiResponse;
import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
@Validated
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<ApiResponse> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(new ApiResponse("Lista de livros", livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> buscarLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new ApiResponse("Livro encontrado", livro.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Livro não encontrado", null));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> inserirLivro(@Valid @RequestBody Livro livro) {
        Livro novoLivro = livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Livro criado com sucesso", novoLivro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> atualizarLivro(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        return livroRepository.findById(id)
                .map(livroExistente -> {
                    livroExistente.setTitulo(livro.getTitulo());
                    livroExistente.setAutor(livro.getAutor());
                    livroExistente.setAnoPublicacao(livro.getAnoPublicacao());
                    livroExistente.setGenero(livro.getGenero());
                    livroExistente.setPreco(livro.getPreco());
                    Livro livroAtualizado = livroRepository.save(livroExistente);
                    return ResponseEntity.ok(new ApiResponse("Livro atualizado com sucesso", livroAtualizado));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse("Livro não encontrado", null)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarLivro(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(livroExistente -> {
                    livroRepository.delete(livroExistente);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse("Livro não encontrado", null)));
    }
}
