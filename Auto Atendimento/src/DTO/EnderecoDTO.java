package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="endereco")
public class EnderecoDTO {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String pais;
	
	@Column
	private String estado;
	
	@Column
	private String cidade;
	
	@Column
	private String bairro;
	
	@Column
	private String rua;
	
	@Column
	private int numeroCasa;
	
	@Column
	private int cep;
	
	/*
	public EnderecoDTO(String pais, String estado, String cidade, String bairro, String rua, int numeroCasa, int cep) {
		super();
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numeroCasa = numeroCasa;
		this.cep = cep;
	}

	public EnderecoDTO() {
		super();
	}
	*/
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
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
		builder.append("Endereco [pais=");
		builder.append(pais);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append(", bairro=");
		builder.append(bairro);
		builder.append(", rua=");
		builder.append(rua);
		builder.append(", numeroCasa=");
		builder.append(numeroCasa);
		builder.append(", cep=");
		builder.append(cep);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
