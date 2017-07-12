package com.beeva.ultimate.elbanco.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.model.BancosClientes;
import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;

@Repository
public class CuentaDAOImplAhorro extends CuentaDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Cuenta deposito(Cuenta cuenta, double dinero) {
		int x = cuenta.getIdtipocuenta();
		if(x==1){
			System.out.println("Deposito en Ahorro");
			boolean flag=false;
			double saldo=cuenta.getBalance();
			System.out.println("Al saldo anterior "+saldo);
			saldo = saldo + dinero;
			System.out.println("Saldo despues del deposito "+saldo);
			
			cuenta.setBalance(saldo);
			
			em.merge(cuenta);
			
			System.out.println("Que tal ahora?");
			
			flag = true;
			return cuenta;
		}else if(x==2){
			System.out.println("Deposito en Cheques");
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
				System.out.println("Si deposita :v");
				saldo = saldo + dinero;
				cuenta.setBalance(saldo);
				em.merge(cuenta);
				flag=true;
			}
			
			return cuenta;
		}else{
			return null;
		}
	}

	@Transactional
	public Cuenta retiro(Cuenta cuenta, double dinero) {
		
		int x = cuenta.getIdtipocuenta();
		if(x==1){
			System.out.println("Ahorro!");
			boolean flag=false;
			double saldo=cuenta.getBalance();
			saldo = saldo - dinero;
			if(saldo<5000){
				System.out.println("No puedes tener menos de $5000");
				flag=false;
			}else{
				cuenta.setBalance(saldo);
				em.merge(cuenta);
				flag=true;
			}
			return cuenta;

		}else if(x==2){
			System.out.println("Cheques!");
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
				em.merge(cuenta);
				flag=true;
			}
			
			return cuenta;

		}else{
			return null;
		}
		
		
		
	}

	@Transactional
	public void save(Cuenta cuenta) {
		em.persist(cuenta);
		
	}

	public Cuenta getCuentaById(int id) {
		Cuenta cu = (Cuenta) em.find(Cuenta.class, id);
		return cu;
	}
	
	public Cuenta getCuentaByIdCliente(int idcliente){
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