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
	
	public boolean deposito(Cuenta cuenta, double dinero) {
		boolean flag=false;
		double saldo=cuenta.getBalance();
		saldo = saldo + dinero;
		cuenta.setBalance(saldo);
		flag = true;
		return flag;
	}

	public boolean retiro(Cuenta cuenta, double dinero) {
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
		
		return flag;
	}

	@Transactional
	public void save(Cuenta cuenta) {
		em.persist(cuenta);
		
	}

	public Cuenta getCuentaById(int id) {
		
		return em.find(Cuenta.class, id);
	}
	
}