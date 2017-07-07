package com.beeva.mysql.bankapp.dao.impl;

import java.util.Date;

import com.beeva.mysql.bankapp.dao.Cliente;
import com.beeva.mysql.bankapp.dao.inter.CuentaDAO;

public class CuentaDAOImplCheques implements CuentaDAO {

	public boolean deposito(Cliente cliente, double dinero) {
		boolean flag=false;
		double saldo=cliente.getCuenta().getBalance();
		saldo = saldo + dinero;
		cliente.getCuenta().setBalance(saldo);
		flag = true;
		return flag;
	}

	public boolean retiro(Cliente cliente, double dinero) {
		boolean flag=false;
		int dia=0;
		double saldo=cliente.getCuenta().getBalance();
		Date hoy = new Date();
		
		dia=hoy.getDay();
		//dia=6;
		
		if(dia==6 || dia==7){
			System.out.println("No puedes retirar efectivo los fines de semana");
			flag=false;
		}else{
			saldo = saldo - dinero;
			cliente.getCuenta().setBalance(saldo);
			flag=true;
		}
		
		return flag;
	}
	
}