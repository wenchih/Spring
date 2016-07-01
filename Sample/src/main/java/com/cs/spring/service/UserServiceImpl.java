package com.cs.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.spring.dao.UserDAO;
import com.cs.spring.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addPerson(User p) {
		this.userDAO.addPerson(p);
	}

	@Override
	@Transactional	
	//@CacheEvict(value="accountCache",key="#p.getId()")
	public void updatePerson(User p) {
		System.out.println("real query account2"); 
		this.userDAO.updatePerson(p);
	}

	@Override
	@Transactional
	//@Cacheable(value="accountCache2")
	public List<User> listPersons() {
		System.out.println("real query account1."); 
		return this.userDAO.listPersons();
	}

	@Override
	@Transactional
	//@Cacheable(value="accountCache")
	public User getPersonById(int id) {
		
		return this.userDAO.getPersonById(id);
	}
	

	
	@Override
	@Transactional
	public void removePerson(int id) {
		this.userDAO.removePerson(id);
	}

}
