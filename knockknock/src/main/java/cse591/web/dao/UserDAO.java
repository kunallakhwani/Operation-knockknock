package cse591.web.dao;

import cse591.web.dto.RegisterUser;


public interface UserDAO {

	public RegisterUser findUserByUserName(String username);



}
