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
	@PersistenceContext
	EntityManager e;
	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);
		
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		em.remove(e.find(Cliente.class, id));
		
	}

	@Override
	public Cliente getClienteById(int id) {
		if(em.find(Cliente.class, id)!=null){
			Cliente c = (Cliente) em.find(Cliente.class, id);
			return c;
		}else{
			return null;
		}
		
	}
	
	public int getNClientes(){
		Query query = em.createQuery("select c "+"from Cliente c");
        List<Cliente> list=(List<Cliente>)query.getResultList();
        return list.size();
	}
	
	public void getAllClientes(){
		Query query = em.createQuery("select c "+"from Cliente c");
        List<Cliente> list=(List<Cliente>)query.getResultList();
        
        for(int i=0;i<list.size();i++){
        	System.out.println("ID "+list.get(i).getIdcliente()+" - "+list.get(i).getNombre()+" "+list.get(i).getApellido());
        }
	}

	public String getClienteByNombre(String nombre){
		return "Hola";
	}
}
