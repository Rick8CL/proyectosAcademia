package com.beeva.jpa.ejemplo.dao;

import com.beeva.jpa.ejemplo.model.*;

public abstract class UserDAO {
	public abstract void save(User user);
	public abstract User getUser(int id);
}
