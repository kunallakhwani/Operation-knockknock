package cse591.web.dao;

import java.util.List;

import cse591.web.dto.Messages;

public interface MessageDao {

	public int insertMsg(Messages msg) throws Exception;
	public List<Messages> showMessages();

}
