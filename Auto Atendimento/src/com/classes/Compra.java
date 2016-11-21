package com.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.util.Datas;

public class Compra {
	
	private Long codigo;
	private Pessoa cliente;
	private List<Produto> listaProdutos;
	private Date dataAtendimentoIn, dataAtendimentoFim;
	
	public Compra(Pessoa cliente, Date dataAtedimentoIn, Long codigo) {
		super();
		this.cliente = cliente;
		this.dataAtendimentoIn = new Date();
		this.codigo =  codigo;
	}
	
	public Compra(){
		super();
		cliente = new Pessoa();
		listaProdutos = new ArrayList<>();
		this.dataAtendimentoIn = new Date();
	}

	public Pessoa getCliente() {
		return cliente;
	}
	
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public Date getDataAtendimentoIn() {
		return dataAtendimentoIn;
	}

	public void setDataAtendimentoIn(Date dataAtendimentoIn) {
		this.dataAtendimentoIn = dataAtendimentoIn;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataAtendimentoFim() {
		return dataAtendimentoFim;
	}

	public void setDataAtendimentoFim(Date dataAtendimentoFim) {
		this.dataAtendimentoFim = dataAtendimentoFim;
	}
/*
 * Talvez desnecessário
 * 
 * public void atendimento(Pessoa pessoa){
 * 		
 * }
*/	
	public void insereProduto(Produto produto, List<Produto> listaProdutos){
		
	}
	
	public void removeProduto(Produto produto, List<Produto> listaProdutos){
		
	}
	
	public String Cupom(Pessoa cliente, List<Produto> listaProdutos){
		StringBuilder cupom = new StringBuilder();
		
		return cupom.toString();
	}
	
	public double calculaTotal(List<Produto> listaProdutos){
		double total=0;
		for(Produto p: listaProdutos){
			total+=(p.getQuantidade()*p.getValor());
		}
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compra [cliente=");
		builder.append(cliente.toString());
		builder.append(", código=");
		builder.append(codigo);
		builder.append(", listaProdutos=");
		for(Produto p : listaProdutos)
			builder.append(p.toString());
		builder.append(", dataAtendimentoIn=");
		builder.append(Datas.DataForStringPadrao(dataAtendimentoIn));
		builder.append(", dataAtendimentoFim=");
		builder.append(Datas.DataForStringPadrao(dataAtendimentoFim));
		builder.append("]");
		return builder.toString();
	}
	
}
