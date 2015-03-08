package cse591.web.dao;

import cse591.web.dto.RegisterUser;


public interface RegisterDao {

	public int insertUser(RegisterUser user) throws Exception;

	public boolean existsUser(String username); 
	
}
