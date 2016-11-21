package com.classes;

import java.util.Date;

public class Pessoa {
	
	private long id;
	private String nome, email, cpf, rg;
	private int idade;
	private Date dataNascimento;
	private Endereco endereco;
	private Cartao cartao;
	
	public Pessoa(String nome, String email, String cpf, String rg, int idade, Date dataNascimento, Endereco endereco,
			Cartao cartao, long id) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cartao = cartao;
		this.id = id;
	}

	public Pessoa() {
		super();
		endereco = new Endereco();
		cartao = new Cartao();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", rg=");
		builder.append(rg);
		builder.append(", idade=");
		builder.append(idade);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", endereco=");
		builder.append(endereco.toString());
		builder.append(", cartao=");
		builder.append(cartao.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
