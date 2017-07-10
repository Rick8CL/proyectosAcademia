package com.beeva.otrojpa.demo.dao;

import com.beeva.otrojpa.demo.model.User;

public abstract class UserDAO {
	public abstract void save(User user);
	public abstract User getUser(int id);
}
