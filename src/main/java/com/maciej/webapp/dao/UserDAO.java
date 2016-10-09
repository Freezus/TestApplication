package com.maciej.webapp.dao;

import java.util.List;

import com.maciej.webapp.model.User;

public interface UserDAO {

	public void save(User user);

	public List<User> list();
	
}
