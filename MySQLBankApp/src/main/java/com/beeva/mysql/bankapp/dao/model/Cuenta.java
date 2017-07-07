package com.beeva.mysql.bankapp.dao.model;
/**
 * Clase que declara una Cuenta
 * Ricardo Castillo Lara
 * 03/07/2017
 */
public class Cuenta {

    protected double balance = 0;
    protected String tipoCuenta = "";
    
    public Cuenta(double balance, String tipoCuenta){
		this.balance=balance;
		this.tipoCuenta=tipoCuenta;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
    
}