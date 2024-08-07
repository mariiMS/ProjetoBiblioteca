package com.biblioteca.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String titulo;

    @Column(nullable = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String autor;

    @Column(nullable = false)
    @NotNull
    private Integer anoPublicacao;

    @Column(nullable = false)
    @NotNull
    private Double preco;

    public Double getGenero() {
        return genero;
    }

    public void setGenero(Double genero) {
        this.genero = genero;
    }

    @Column(nullable = false)
    @NotNull
    private Double genero;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
