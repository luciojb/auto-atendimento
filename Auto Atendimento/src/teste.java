import java.util.List;
import DAO.CartaoDAO;
import DTO.CartaoDTO;
import generic.GenericDAO;



public class teste {
	public static void main(String[] args){
		CartaoDTO c = new CartaoDTO();
		c.setAgencia(54546);
		c.setBandeira("Visa");
		c.setNumeroCartao(12341234000L);
		c.setNumeroContaBancaria(66737);
		c.setSaldo(1000);
		c.setSenha(123456);
		
		CartaoDAO cd = new CartaoDAO();
		
		if (cd instanceof GenericDAO<?>){
			//cd.insert(c);
			List<CartaoDTO> cList = cd.findAll();
			for(Object ct : cList){
				System.out.println(((CartaoDTO) ct).getNumeroContaBancaria());
			}
		}
			
			
	}
}
