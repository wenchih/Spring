package com.cs.spring.service;

import java.util.List;

import com.cs.spring.model.User;

public interface UserService {

	public void addPerson(User p);
	public void updatePerson(User p);
	public List<User> listPersons();
	public User getPersonById(int id);
	
	public void removePerson(int id);
	
}
