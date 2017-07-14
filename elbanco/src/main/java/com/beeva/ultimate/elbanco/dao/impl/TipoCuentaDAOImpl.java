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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.inter.TipoCuentaDAO;
import com.beeva.ultimate.elbanco.dao.model.TipoCuenta;

@Repository
public class TipoCuentaDAOImpl extends TipoCuentaDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void save(TipoCuenta tc) {
		em.persist(tc);
		
	}

	@Override
	public TipoCuenta getTipoCuentaById(int id) {
		return em.find(TipoCuenta.class, id);
		
	}

	
}
