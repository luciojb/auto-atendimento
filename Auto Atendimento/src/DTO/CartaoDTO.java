package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="cartao")
public class CartaoDTO {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="numero_cartao")
	private long numeroCartao;
	
	@Column
	private int agencia;
	
	@Column(name="numero_conta")
	private int numeroContaBancaria;
	
	@Column
	private int senha;
	
	@Column
	private String bandeira;
	
	@Column
	private double saldo;
	
	/*
	public CartaoDTO(long numeroCartao, int agencia, int numeroContaBancaria, String bandeira, double saldo, int senha) {
		super();
		this.numeroCartao = numeroCartao;
		this.agencia = agencia;
		this.numeroContaBancaria = numeroContaBancaria;
		this.bandeira = bandeira;
		this.saldo = saldo;
		this.senha = senha;
	}

	public CartaoDTO() {
		super();
	}
	*/

	public long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(long numeroCartao) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
