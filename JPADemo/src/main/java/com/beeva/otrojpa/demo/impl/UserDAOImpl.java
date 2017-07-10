package com.beeva.otrojpa.demo.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.otrojpa.demo.dao.UserDAO;
import com.beeva.otrojpa.demo.model.User;

@Repository
public class UserDAOImpl extends UserDAO {
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void save(User user) {
		
		em.persist(user);
		
	}

	@Override
	public User getUser(int id) {
		
		return em.find(User.class, id);
	}

}
