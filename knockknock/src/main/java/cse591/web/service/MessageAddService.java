
package cse591.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cse591.web.dao.MessageDao;
import cse591.web.dto.Messages;

@Service
public class MessageAddService{

	@Autowired
	private MessageDao messageDao;
	
	
	@Transactional
 	public String addMsg (Messages message) {
	 	try {		

	 		messageDao.insertMsg(message);
	 		
	 		return "Message Added Successfully";
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 		return "Message Could not be added!!";
	 	}	
	
	
 	}
	
	@Transactional
	public List<Messages> showMessages(){
		return messageDao.showMessages();
	}


}