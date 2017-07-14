package com.beeva.ultimate.elbanco.dao.impl;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Implementación de su clase Abstracta
 * Recibe los parámetros enviados desde el Main a traves de sus Abstracciones
 * y los procesa para manipular los datos de la BD, básicamente registros
 * y consultas.
 * 
 * Cuenta con anotaciones para ser identificados como Contextos de Persistencia,
 * Repositorios, métodos Transaccionales, y Override para acceder a los métodos
 * de sus padres Abstractos
 * 
 */

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
