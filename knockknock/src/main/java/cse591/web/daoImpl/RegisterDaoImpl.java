package cse591.web.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cse591.web.dao.RegisterDao;
import cse591.web.dto.RegisterUser;

@Repository("RegisterDao")
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private PasswordEncoder passwordencoder;

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
	public int insertUser(RegisterUser user) throws Exception {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		getSession().save(user);
		return 0;
	}

	@Override
	public boolean existsUser(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				RegisterUser.class);
		criteria.add(Restrictions.eq("username", username));
		RegisterUser user = (RegisterUser) criteria.uniqueResult();

		if (user != null)
			return true;

		else
			return false;

	}

}
