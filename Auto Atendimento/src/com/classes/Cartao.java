package com.classes;

public class Cartao {
	private int numeroCartao, agencia, numeroContaBancaria, senha;
	private String bandeira;
	private double saldo;
	
	public Cartao(int numeroCartao, int agencia, int numeroContaBancaria, String bandeira, double saldo, int senha) {
		super();
		this.numeroCartao = numeroCartao;
		this.agencia = agencia;
		this.numeroContaBancaria = numeroContaBancaria;
		this.bandeira = bandeira;
		this.saldo = saldo;
		this.senha = senha;
	}

	public Cartao() {
		super();
	}

	public int getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroContaBancaria() {
		return numeroContaBancaria;
	}

	public void setNumeroContaBancaria(int numeroContaBancaria) {
		this.numeroContaBancaria = numeroContaBancaria;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cartao [numeroCartao=");
		builder.append(numeroCartao);
		builder.append(", agencia=");
		builder.append(agencia);
		builder.append(", numeroContaBancaria=");
		builder.append(numeroContaBancaria);
		builder.append(", bandeira=");
		builder.append(bandeira);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append("]");
		return builder.toString();
	}
	
}
