package com.beeva.ultimate.elbanco.dao.impl;

import java.util.Date;

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
	
}