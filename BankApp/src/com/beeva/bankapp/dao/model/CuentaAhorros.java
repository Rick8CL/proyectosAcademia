package com.beeva.bankapp.dao.model;


/**
 * Clase que declara una Cuenta de Ahorros, que hereda de Cuenta
 * Ricardo Castillo Lara
 * 04/07/2017
 */
public class CuentaAhorros extends Cuenta{
  public CuentaAhorros(int tipo, double bal) {
		super(tipo, bal);
		// TODO Auto-generated constructor stub
	}

public void retiro(double dinero, int pos) {
	  if(balance>5000){
      balance = balance -dinero;
    }
  }
}
