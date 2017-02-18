package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import util.Datas;


@Entity @Table(name="compra")
public class CompraDTO {
	
	@Id
	@GeneratedValue
	@Column(nullable=false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="cliente_id", referencedColumnName="id")
	private PessoaDTO cliente;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="compra_produto",  
              joinColumns={@JoinColumn(name="compra_id", 
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="produto_id", 
                referencedColumnName="id")}) 
	private List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_atendimento_in")
	private Date dataAtendimentoIn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_atendimento_fim")
	private Date dataAtendimentoFim;
	/*
	public CompraDTO(PessoaDTO cliente, Date dataAtedimentoIn, int codigo) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAtendimentoFim() {
		return dataAtendimentoFim;
	}

	public void setDataAtendimentoFim(Date dataAtendimentoFim) {
		this.dataAtendimentoFim = dataAtendimentoFim;
	}

	public void adicionaProduto(ProdutoDTO produto){
		this.listaProdutos.add(produto);
	}
	
	public void removeProduto(ProdutoDTO produto){
		this.listaProdutos.remove(produto);
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compra [cliente=");
		builder.append(cliente.toString());
		builder.append(", id=");
		builder.append(id);
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
