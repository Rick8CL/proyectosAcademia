package com.beeva.ultimate.elbanco.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.inter.ClienteDAO;
import com.beeva.ultimate.elbanco.dao.model.Cliente;

@Repository
public class ClienteDAOImpl extends ClienteDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void save(Cliente cliente, double dinero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getClienteById(Cliente cliente, double dinero) {
		// TODO Auto-generated method stub
		
	}
	
	

}
