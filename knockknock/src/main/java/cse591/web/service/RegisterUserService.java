package cse591.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cse591.web.dao.RegisterDao;
import cse591.web.dto.RegisterUser;

@Service
public class RegisterUserService{

	@Autowired
	private RegisterDao registerDao;
	
	
	@Transactional
 	public String addUser (RegisterUser user) {
	 	try {		
	 			 		
	 		
	 		// Inserting user into the db
	 		registerDao.insertUser(user);
	 		
	 		return "User Created Successfully";
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 		return "User Cannot be Created !!";
	 	}	
	
	
 	}

	@Transactional
	public boolean existsUser(String username) {

			return registerDao.existsUser(username);
	}
}