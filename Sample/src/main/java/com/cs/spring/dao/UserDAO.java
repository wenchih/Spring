
package com.cs.spring.dao;

import java.util.List;

import com.cs.spring.model.User;

public interface UserDAO {

	public void addPerson(User p);
	public void updatePerson(User p);
	public List<User> listPersons();
	public User getPersonById(int id);

	public void removePerson(int id);
}
