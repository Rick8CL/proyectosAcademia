package com.beeva.ultimate.elbanco.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;

@Repository
public class CuentaDAOImplAhorro extends CuentaDAO {

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
		double saldo=cuenta.getBalance();
		saldo = saldo - dinero;
		if(saldo<5000){
			System.out.println("No puedes tener menos de $5000");
			flag=false;
		}else{
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
		Cuenta cu = (Cuenta) em.find(Cuenta.class, id);
		return cu;
	}
}