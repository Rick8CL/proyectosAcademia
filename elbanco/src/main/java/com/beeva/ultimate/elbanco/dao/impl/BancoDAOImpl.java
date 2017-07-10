package com.beeva.ultimate.elbanco.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.inter.BancoDAO;
import com.beeva.ultimate.elbanco.dao.model.Banco;

@Repository
public class BancoDAOImpl extends BancoDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void save(Banco banco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBancoById(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
