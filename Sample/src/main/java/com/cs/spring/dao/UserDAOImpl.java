package com.cs.spring.dao;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cs.spring.model.User;

@Repository
public class UserDAOImpl extends AbstractDaoImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
//
//	private SessionFactory sessionFactory;
//	
//	public void setSessionFactory(SessionFactory sf){
//		this.sessionFactory = sf;
//		System.out.println();
//	}

	@Override
	public void addPerson(User p) {
		//Session session = this.sessionFactory.getCurrentSession();
		currentSession().persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(User p) {
	//	Session session = this.sessionFactory.getCurrentSession();
		currentSession().update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listPersons() {
	//	Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList = currentSession().createQuery("from User").list(); //閬����
		for(User p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public User getPersonById(int id) {
	//	Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) currentSession().load(User.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}
	
	
	


	@Override
	public void removePerson(int id) {
//		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) currentSession().load(User.class, new Integer(id));
		if(null != p){
			currentSession().delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
