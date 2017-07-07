package com.beeva.bankapp.dao;
/**
 * Clase que declara un Banco para manipular Clientes
 * Ricardo Castillo Lara
 * 03/07/2017
 */
import java.util.ArrayList;

import com.beeva.bankapp.dao.model.Cuenta;

public class Banco {

    public ArrayList<Cliente> clienteA = new ArrayList<Cliente>();
    public int noclientes = 0;
    
    static int i = 0;
    static String nom = "", ape = "";
    static Cuenta cue;
    static double dinero=0;

    
    //Cuenta cu = new Cuenta(dinero);

    public void addCliente(String nombre, String apellido, Cuenta cuenta, int tipoCuenta) {
        if (i < 10) {
        	Cliente c = new Cliente(nom, ape, cue);
        	c.setNombre(nombre);
        	c.setApellido(apellido);
        	c.setCuenta(cuenta);
            clienteA.add(c);
            i++;
        } else {
            System.out.println("Banco lleno");
        }
    }

    public Cliente getCliente(int nocliente) {
        Cliente flag=null;
        if(nocliente<clienteA.size()){
        	if (!"".equals(clienteA.get(nocliente))) {
        		flag=clienteA.get(nocliente);
        	}
        }
        return flag;
    }

    public int getClientes() {
        int contador = 0;
        contador=clienteA.size();
        return contador;
    }
}
