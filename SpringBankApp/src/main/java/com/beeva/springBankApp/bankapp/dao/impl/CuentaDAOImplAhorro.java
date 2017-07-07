package com.beeva.springBankApp.bankapp.dao.impl;

import com.beeva.springBankApp.bankapp.dao.Cliente;
import com.beeva.springBankApp.bankapp.dao.inter.CuentaDAO;

public class CuentaDAOImplAhorro implements CuentaDAO {

	public boolean deposito(Cliente cliente, double dinero) {
		boolean flag=false;
		double saldo=cliente.getCuenta().getBalance();
		saldo = saldo + dinero;
		cliente.getCuenta().setBalance(saldo);
		flag = true;
		return flag;
	}

	public boolean retiro(Cliente cliente, double dinero) {
		System.out.println("#");
		boolean flag=false;
		double saldo=cliente.getCuenta().getBalance();
		saldo = saldo - dinero;
		if(saldo<5000){
			System.out.println("No puedes tener menos de $5000");
			flag=false;
		}else{
			cliente.getCuenta().setBalance(saldo);
			flag=true;
		}
		return flag;
	}
}