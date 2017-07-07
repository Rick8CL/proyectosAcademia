package com.beeva.springBankApp.bankapp.dao;

public class Inyector {
	private Cliente cliente;
	
	public void Inyecta(){
		System.out.println("Inyecta Cliente "+cliente.getNombre()+" "+cliente.getApellido()+" con una cuenta de "+cliente.getCuenta().getTipoCuenta()+" y con Saldo de $"+cliente.getCuenta().getBalance());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
