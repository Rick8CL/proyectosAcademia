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

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.model.Cuenta;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;

public class CuentaDAOImplCheques extends CuentaDAO {
	@PersistenceContext
	EntityManager em;
	
	public Cuenta deposito(Cuenta cuenta, double dinero) {
		boolean flag=false;
		int dia=0;
		double saldo=cuenta.getBalance();
		Date hoy = new Date();
		
		dia=hoy.getDay();
		//dia=6;
		
		if(dia==6 || dia==7){
			System.out.println("No puedes depositar efectivo los fines de semana");
			flag=false;
		}else{
			saldo = saldo + dinero;
			cuenta.setBalance(saldo);
			flag=true;
		}
		
		return cuenta;
	}

	public Cuenta retiro(Cuenta cuenta, double dinero) {
		boolean flag=false;
		int dia=0;
		double saldo=cuenta.getBalance();
		Date hoy = new Date();
		
		dia=hoy.getDay();
		//dia=6;
		
		if(dia==6 || dia==7){
			System.out.println("No puedes retirar efectivo los fines de semana");
			flag=false;
		}else{
			saldo = saldo - dinero;
			cuenta.setBalance(saldo);
			flag=true;
		}
		
		return cuenta;
	}

	@Transactional
	public void save(Cuenta cuenta) {
		em.persist(cuenta);
		
	}

	public Cuenta getCuentaById(int id) {
		System.out.println("Khé!?");
		return em.find(Cuenta.class, id);
	}

	@Override
	public Cuenta getCuentaByIdCliente(int idcliente) {
		Cuenta cu;
		for(int i=1;i<100;i++){
			if(em.find(Cuenta.class, i) != null){
				cu = (Cuenta) em.find(Cuenta.class, i);
				if(idcliente==cu.getIdcliente()){
					return cu;
				}
			}
		}
		return null;
	}

	@Override
	public List<Cuenta> getCuentasByCliente(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}