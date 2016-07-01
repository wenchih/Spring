package com.cs.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AbstractDaoImpl {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
		System.out.println();
	}
	
	protected Session currentSession(){
		return this.sessionFactory.getCurrentSession();
	}
}
