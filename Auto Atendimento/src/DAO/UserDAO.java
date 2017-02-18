package DAO;

import DTO.UserDTO;
import generic.GenericDAO;

public class UserDAO extends GenericDAO<UserDTO>{
	public UserDAO(){
		super(UserDTO.class);
	}
}
