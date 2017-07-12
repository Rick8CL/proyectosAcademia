package com.beeva.ultimate.elbanco.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.inter.ClienteDAO;
import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;

@Repository
public class ClienteDAOImpl extends ClienteDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);
		
	}

	@Override
	public Cliente getClienteById(int id) {
		Cliente c = (Cliente) em.find(Cliente.class, id);
		return c;
	}
	
	public int getNClientes(){
		Query query = em.createQuery("select c "+"from Cliente c");
        List<Cliente> list=(List<Cliente>)query.getResultList();
        return list.size();
	}

	public String getClienteByNombre(String nombre){
		return "Hola";
	}
}
