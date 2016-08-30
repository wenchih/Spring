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
	public void add(User p) {
		this.userDAO.add(p);
	}

	@Override
	@Transactional	
	//@CacheEvict(value="accountCache",key="#p.getId()")
	public void update(User p) {
		System.out.println("real query account2"); 
		this.userDAO.update(p);
	}

	@Override
	@Transactional
	//@Cacheable(value="accountCache2")
	public List<User> list() {
		System.out.println("real query account1."); 
		return this.userDAO.list();
	}

	@Override
	@Transactional
	//@Cacheable(value="accountCache")
	public User getById(int id) {
		
		return this.userDAO.getById(id);
	}
	
	@Override
	@Transactional
	public List<User> getByUserid(int userid){
		
		return this.userDAO.getByUserid(userid);
	}
	
	
	
	
	@Override
	@Transactional
	public void removeAll(){
		this.userDAO.removeAll();		
	}
	
	@Override
	@Transactional
	public void removeById(int id) {
		this.userDAO.removeById(id);
	}

}
