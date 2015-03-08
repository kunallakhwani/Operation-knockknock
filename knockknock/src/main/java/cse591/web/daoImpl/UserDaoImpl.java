package cse591.web.daoImpl;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cse591.web.dao.UserDAO;
import cse591.web.dto.RegisterUser;


@Repository("UserDAO")
public class UserDaoImpl implements UserDAO{

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
	public RegisterUser findUserByUserName(String username) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(RegisterUser.class);
		criteria.add(Restrictions.eq("username", username));
		RegisterUser user =(RegisterUser)criteria.uniqueResult();
		return user;
	}

	

}
