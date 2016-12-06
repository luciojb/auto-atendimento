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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity @Table(name="pessoa")
public class PessoaDTO {
	
	@Id
	@GeneratedValue
	@Column(nullable=false)
	private long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column
	private String email;
	
	@Column(nullable=false)
	private long cpf;
	
	@Column(nullable=false)
	private long rg;
	
	@Column
	private int idade;
	
	@Column
	private int telefone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="endereco_id", referencedColumnName="id")  
	private EnderecoDTO endereco;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="cartao_id", referencedColumnName="id")  
	private List<CartaoDTO> listaCartao = new ArrayList<CartaoDTO>();
	
	/*
	public PessoaDTO(String nome, String email, String cpf, String rg, int idade, Date dataNascimento, EnderecoDTO endereco,
			CartaoDTO cartao, long id) {
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

	public PessoaDTO() {
		super();
		endereco = new EnderecoDTO();
		cartao = new CartaoDTO();
	}
	*/
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

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<CartaoDTO> getCartao() {
		return listaCartao;
	}

	public void setCartao(List<CartaoDTO> listaCartao) {
		this.listaCartao = listaCartao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
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
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", endereco=");
		builder.append(endereco.toString());
		builder.append(", cartões=");
		for (CartaoDTO cd : listaCartao){
			builder.append(cd.toString());
		}		
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
