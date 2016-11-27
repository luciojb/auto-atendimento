package DAO;

import DTO.ProdutoDTO;
import generic.GenericDAO;

public class ProdutoDAO extends GenericDAO<ProdutoDTO>{
	public ProdutoDAO() {
		super(ProdutoDTO.class);
	}
}
