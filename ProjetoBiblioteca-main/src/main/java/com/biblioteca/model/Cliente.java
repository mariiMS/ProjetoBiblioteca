package com.biblioteca.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Cliente {

	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	private String nome;

	@NotNull
	@Size(min = 1, max = 100)
	private String email;

	@NotNull
	@Size(min = 1, max = 15)
	private String telefone;

	@NotNull
	@Size(min = 11, max = 11)  // Tamanho típico do CPF (11 dígitos)
	private String cpf;

	@NotNull
	@Size(min = 9, max = 9)  // Tamanho típico do RG (9 dígitos)
	private String rg;

	@NotNull
	private Date dataNascimento;
	private boolean maiorDeIdade;


	public boolean isMaiorDeIdade() {
		// Assume que maior de idade é a partir de 18 anos
		// Lógica simples para verificar maioridade
		long idade = new Date().getYear() - dataNascimento.getYear();
		return idade >= 18;
	}

	public void setMaiorDeIdade(boolean maiorDeIdade) {
		this.maiorDeIdade = maiorDeIdade;
	}


	@NotNull
	@Size(min = 8, max = 8)  // Tamanho típico do CEP (8 dígitos)
	private String cep;

	// Getters e Setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
