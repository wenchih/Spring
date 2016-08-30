
package com.cs.spring.dao;

import java.util.List;

import com.cs.spring.model.User;

public interface UserDAO {

	public void add(User p);
	public void update(User p);
	public List<User> list();
	public User getById(int id);
	public List<User> getByUserid(int userid);
	public void removeAll();
	public void removeById(int id);
}
