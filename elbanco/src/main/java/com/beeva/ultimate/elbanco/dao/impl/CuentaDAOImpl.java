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
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ultimate.elbanco.dao.model.BancosClientes;
import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;

@Repository
public class CuentaDAOImpl extends CuentaDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Cuenta deposito(Cuenta cuenta, double dinero) {
		int x = cuenta.getIdtipocuenta();
		if(x==1){
			System.out.println("Deposito en Cuenta de Ahorro");
			boolean flag=false;
			double saldo=cuenta.getBalance();
			System.out.println("Al saldo anterior "+saldo);
			saldo = saldo + dinero;
			System.out.println("Saldo despues del deposito "+saldo);
			
			cuenta.setBalance(saldo);
			
			em.merge(cuenta);
			
			flag = true;
			return cuenta;
		}else if(x==2){
			System.out.println("Deposito en Cuenta de Cheques");
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
				System.out.println("Al saldo anterior "+saldo);
				saldo = saldo + dinero;
				System.out.println("Saldo despues del deposito "+saldo);
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
			System.out.println("Retiro en Cuenta de Ahorro");
			boolean flag=false;
			double saldo=cuenta.getBalance();
			System.out.println("Al saldo anterior "+saldo);
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
			System.out.println("Retiro en Cuenta de Cheques");
			boolean flag=false;
			int dia=0;
			double saldo=cuenta.getBalance();
			Date hoy = new Date();
			
			dia=hoy.getDay();
			System.out.println(dia);
			//dia=6;
			
			if(dia==0 || dia==6){
				System.out.println("No puedes retirar efectivo los fines de semana");
				flag=false;
			}else{
				System.out.println("Al saldo anterior "+saldo);
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
	
	public List<Cuenta> getCuentasByCliente(int idcliente){
		Query query = em.createQuery("select cu "+"from Cuenta cu where idcliente='"+idcliente+"'");
        List<Cuenta> list=(List<Cuenta>)query.getResultList();
        
        for(int i=0;i<list.size();i++){
        	if(list.get(i).getIdtipocuenta()==1){
        		System.out.println(list.get(i).getIdcuenta()+" de AHORROS");
        	}else if(list.get(i).getIdtipocuenta()==2){
        		System.out.println(list.get(i).getIdcuenta()+" de CHEQUES");
        	}
        }
        return list;
	}
}