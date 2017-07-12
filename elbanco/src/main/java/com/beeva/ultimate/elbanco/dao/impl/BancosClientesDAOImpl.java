package com.beeva.ultimate.elbanco.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.inter.BancosClientesDAO;
import com.beeva.ultimate.elbanco.dao.model.Banco;
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
	public BancosClientes getBancosclientesById(int id) {
		BancosClientes bc = (BancosClientes) em.find(BancosClientes.class, id);
		return bc;
		
	}
	
	
	public BancosClientes getIdBancoByIdCliente(int idcliente){
		BancosClientes bc;
		for(int i=1;i<100;i++){
			if(em.find(BancosClientes.class, i) != null){
				bc = (BancosClientes) em.find(BancosClientes.class, i);
				if(idcliente==bc.getIdcliente()){
					return bc;
				}
			}
		}
		return null;
		
	}

	
}
