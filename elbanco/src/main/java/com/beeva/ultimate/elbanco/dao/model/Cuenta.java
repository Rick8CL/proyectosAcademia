package com.beeva.ultimate.elbanco.dao.model;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase POJO para la tabla cuenta
 * Contiene anotaciones para su implementación como Entidad a la BD
 * 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuenta")
public class Cuenta {
	
	protected int idcuenta, idcliente, idtipocuenta;
    protected double balance;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	
}