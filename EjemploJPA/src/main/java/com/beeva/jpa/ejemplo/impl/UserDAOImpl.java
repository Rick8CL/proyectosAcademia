package com.beeva.jpa.ejemplo.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.jpa.ejemplo.dao.UserDAO;
import com.beeva.jpa.ejemplo.model.User;
@Repository
public class UserDAOImpl extends UserDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void save(User user) {
		em.persist(user);
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
