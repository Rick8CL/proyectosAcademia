package com.beeva.bankapp.dao.model;
/**
 * Clase que declara una Cuenta
 * Ricardo Castillo Lara
 * 03/07/2017
 */
public class Cuenta {

    protected double balance = 0;
    protected int tipoCuenta = 0;
    
    public Cuenta(int tipo, double bal){
    	tipoCuenta=tipo;
    	balance=bal;
    }

    public double getBalance() {
        return balance;
    }

    public double deposito(double dinero) {
        balance = balance + dinero;
        return balance;
    }

    public void retiro(double dinero) {
        balance = balance - dinero;
    }

	public int getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(int tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
    
    
}
