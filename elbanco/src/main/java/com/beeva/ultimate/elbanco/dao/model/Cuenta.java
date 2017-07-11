package com.beeva.ultimate.elbanco.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuenta")
public class Cuenta {
	
	protected int id, idcliente, idtipocuenta;
    protected double balance;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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