package com.beeva.maven.bankapp.dao;
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
}
