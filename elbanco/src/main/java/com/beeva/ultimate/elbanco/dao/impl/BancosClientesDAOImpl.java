package com.beeva.ultimate.elbanco.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.inter.BancosClientesDAO;
import com.beeva.ultimate.elbanco.dao.model.BancosClientes;

@Repository
public class BancosClientesDAOImpl extends BancosClientesDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void save(BancosClientes bc) {
		em.persist(bc);
		
	}

	@Override
	public BancosClientes getBancoById(int id) {
		return em.find(BancosClientes.class, id);
		
	}

	
}
