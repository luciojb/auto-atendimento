package DTO;

public class ProdutoDTO {
	private long id;
	private double valor;
	private String descricao;
	private int quantidade;
	private long codigoBarras;
	/*
	public ProdutoDTO(long id, double valor, String descricao, int quantidade, long codigoBarras) {
		super();
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.codigoBarras = codigoBarras;
	}
	
	public ProdutoDTO() {
	}
	*/
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public long getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [id=");
		builder.append(id);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", codigoBarras=");
		builder.append(codigoBarras);
		builder.append("]");
		return builder.toString();
	}
	
}
