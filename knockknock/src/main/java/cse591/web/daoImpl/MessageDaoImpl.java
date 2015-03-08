package cse591.web.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import cse591.web.dao.MessageDao;
import cse591.web.dto.Messages;
import cse591.web.utils.KnockSequence;

@Repository("MessageDao")
public class MessageDaoImpl implements
		MessageDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSession(Session session) {
		this.sessionFactory = session.getSessionFactory();
	}
	
	@Override
	@Transactional
	public int insertMsg(Messages message) throws Exception {

		getSession().save(message);
		return 0;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Messages> showMessages() {
		Query query = null;
		if (KnockSequence.secret == 0)
		 query = getSession().createQuery("from Messages where secret=0");
		else if(KnockSequence.secret == 1)
			 query = getSession().createQuery("from Messages where secret=1");	
		return query.list();
	}

}
