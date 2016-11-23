package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.Datas;

public class CompraDTO {
	
	private Long codigo;
	private PessoaDTO cliente = new PessoaDTO();
	private List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();
	private Date dataAtendimentoIn, dataAtendimentoFim;
	/*
	public CompraDTO(PessoaDTO cliente, Date dataAtedimentoIn, Long codigo) {
		super();
		this.cliente = cliente;
		this.dataAtendimentoIn = new Date();
		this.codigo =  codigo;
	}
	
	public CompraDTO(){
		super();
		cliente = new PessoaDTO();
		listaProdutos = new ArrayList<>();
		this.dataAtendimentoIn = new Date();
	}
	*/

	public PessoaDTO getCliente() {
		return cliente;
	}
	
	public void setCliente(PessoaDTO cliente) {
		this.cliente = cliente;
	}
	
	public List<ProdutoDTO> getListaProdutos() {
		return listaProdutos;
	}
	
	public void setListaProdutos(List<ProdutoDTO> listaProdutos) {
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
	public void insereProduto(ProdutoDTO produto, List<ProdutoDTO> listaProdutos){
		
	}
	
	public void removeProduto(ProdutoDTO produto, List<ProdutoDTO> listaProdutos){
		
	}
	
	public String Cupom(PessoaDTO cliente, List<ProdutoDTO> listaProdutos){
		StringBuilder cupom = new StringBuilder();
		
		return cupom.toString();
	}
	
	public double calculaTotal(List<ProdutoDTO> listaProdutos){
		double total=0;
		for(ProdutoDTO p: listaProdutos){
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
		for(ProdutoDTO p : listaProdutos)
			builder.append(p.toString());
		builder.append(", dataAtendimentoIn=");
		builder.append(Datas.DataForStringPadrao(dataAtendimentoIn));
		builder.append(", dataAtendimentoFim=");
		builder.append(Datas.DataForStringPadrao(dataAtendimentoFim));
		builder.append("]");
		return builder.toString();
	}
	
}
