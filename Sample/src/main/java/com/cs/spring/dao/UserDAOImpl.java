package com.cs.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cs.spring.model.User;

@Repository
public class UserDAOImpl extends DaoImplExtend implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
//
//	private SessionFactory sessionFactory;
//	
//	public void setSessionFactory(SessionFactory sf){
//		this.sessionFactory = sf;
//		System.out.println();
//	}

	@Override
	public void add(User p) {
		//Session session = this.sessionFactory.getCurrentSession();
		currentSession().persist(p);
		logger.info(" saved successfully,  Details="+p);
	}

	@Override
	public void update(User p) {
	//	Session session = this.sessionFactory.getCurrentSession();
		currentSession().update(p);
		logger.info(" updated successfully,  Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
	//	Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList = currentSession().createQuery("from User").list(); //閬����
		for(User p : personsList){
			logger.info(" List::"+p);
		}
		return personsList;
	}

	@Override
	public User getById(int id) {
	//	Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) currentSession().load(User.class, new Integer(id));
		logger.info(" loaded successfully,  details="+p);
		return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByUserid(int userid){
		
		Query query =(Query) currentSession().createQuery("from User where userid = :userid"); 
		query.setParameter("userid",userid);
		
		List<User> personsList = query.list();

		for(User p : personsList){
			logger.info(" List::"+p);
		}
		return personsList;
		
	}
	
	
	
	@Override
	public void removeById(int id) {
//		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) currentSession().load(User.class, new Integer(id));
		if(null != p){
			currentSession().delete(p);
		}
		logger.info(" deleted successfully,  details="+p);
	}
	
//	@SuppressWarnings("unchecked")
	@Override
	public void removeAll() {
		//HQL not support Truncate, just use SQL
		 currentSession().createSQLQuery("TRUNCATE TABLE  USER").executeUpdate();
		
		
	}

}
