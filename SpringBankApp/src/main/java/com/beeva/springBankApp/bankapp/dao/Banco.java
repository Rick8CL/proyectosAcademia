package com.beeva.springBankApp.bankapp.dao;
/**
 * Clase que declara un Banco para manipular Clientes
 * Ricardo Castillo Lara
 * 03/07/2017
 */

public class Banco {

    private Cliente[] cliente = new Cliente[10];
    private int noclientes = 0;
    
    static int i = 0;
    

    public boolean addCliente(Cliente cli) {
    	boolean flag=false;
        if (i < 10) {
            cliente[i]=cli;
            System.out.println("Agrega Cliente "+cliente[i].getNombre()+" "+cliente[i].getApellido()+" con una cuenta de "+cliente[i].getCuenta().getTipoCuenta()+" y con Saldo de $"+cliente[i].getCuenta().getBalance());//Quita esto!
            i++;
            flag=true;
        } else {
            flag=false;
        }
        return flag;
    }

    public Cliente getCliente(int nocliente) {
        Cliente cli=null;
        if(nocliente<i){
        	cli=cliente[nocliente];
        }
        System.out.println("Saldo de "+cliente[nocliente].getNombre()+" "+cliente[nocliente].getApellido()+" con Saldo de $"+cliente[nocliente].getCuenta().getBalance());//Quita esto!
        return cli;
    }

    public int getClientes() {
        noclientes=0;
    	for(int w=0;w<10;w++){
        	if(cliente[w]!=null){
        		noclientes++;
        	}
        }
        return noclientes;
    }
//////////////////////////////////////////////////////
	public Cliente[] getCliente() {
		return cliente;
	}

	public void setCliente(Cliente[] cliente) {
		this.cliente = cliente;
	}
    
    
    
    
}
