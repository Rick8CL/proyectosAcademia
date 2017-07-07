package com.beeva.springBankApp.bankapp.dao;
/**
 * Programa que simula el funcionamiento de un Banco
 * Ricardo Castillo Lara
 * 03/07/2017
 */
import java.util.Scanner;

import com.beeva.springBankApp.bankapp.dao.factory.CuentaFactory;
import com.beeva.springBankApp.bankapp.dao.inter.CuentaDAO;
import com.beeva.springBankApp.bankapp.dao.model.Cuenta;

public class Principal {

    public static void main(String[] args) {
        Scanner lector;
        int opc = 0, x = 0;
        double dinero = 0;
        String nom = "", ape = "", tipoCuenta="";
        Banco b = new Banco();

        try {
            System.out.println("Bienvenido!!! Selecciona una opcion del siguiente menu:");
            do {
                lector = new Scanner(System.in);
                System.out.println("\n|-----------------------|\n|1. Agregar Cliente     |\n|2. Buscar Cliente      |\n|3. Cantidad de Clientes|\n|4. Saldo               |\n|5. Deposito            |\n|6. Retiro              |\n|0. Salir               |\n|-----------------------|\n");
                opc = lector.nextInt();
                switch (opc) {
                    case 1:
                    	boolean flag=false;
                    	System.out.println("Cliente a Agregar");
                        lector = new Scanner(System.in);
                        System.out.println("Nombre");
                        nom = lector.nextLine();
                        lector = new Scanner(System.in);
                        System.out.println("Apellido");
                        ape = lector.nextLine();
                        lector = new Scanner(System.in);
                        System.out.println("Tipo de Cuenta: AHORROS || CHEQUES");
                        tipoCuenta = lector.nextLine().toUpperCase();
                        lector = new Scanner(System.in);
                        System.out.println("Deposito Inicial:");
                        dinero = lector.nextDouble();
                        if(tipoCuenta.equals("AHORROS")){
                        	if(dinero>=5000){
                        		Cuenta cu = new Cuenta(dinero, tipoCuenta);
                                Cliente cli = new Cliente(nom, ape, cu);
                                b.addCliente(cli);
                                flag=true;
                        	}else{
                        		System.out.println("Primer deposito minimo de $5000");
                        		flag=false;
                        	}
                        }else if(tipoCuenta.equals("CHEQUES")){
                        	Cuenta cu = new Cuenta(dinero, tipoCuenta);
                            Cliente cli = new Cliente(nom, ape, cu);
                            b.addCliente(cli);
                            flag=true;
                        }else{
                        	flag=false;
                        }
                        
                        if(flag==true){
                        	System.out.println("Cliente Agregado Exitosamente!");
                        }else{
                        	System.out.println("Fallo el Registro del Cliente");
                        }
                        break;
                        
                    case 2:
                        lector = new Scanner(System.in);
                        System.out.println("No Cliente a Buscar");
                        x = lector.nextInt();
                        if (b.getCliente(x)!=null) {
                            System.out.println("Cliente encontrado: " + b.getCliente(x).getNombre()+" "+b.getCliente(x).getApellido()+" con Cuenta de "+b.getCliente(x).getCuenta().getTipoCuenta());
                        } else {
                            System.out.println("Cliente no Encontrado");
                        }
                        break;
                        
                    case 3:
                        System.out.println("Actualmente hay " + b.getClientes() + " clientes en el banco");
                        break;
                        
                    case 4:
                    	lector = new Scanner(System.in);
                    	System.out.println("Numero de Cliente:");
                        x = lector.nextInt();
                        if (b.getCliente(x)!=null) {
                            System.out.println("Cliente: " + b.getCliente(x).getNombre() + " con un saldo de: $" + b.getCliente(x).getCuenta().getBalance());
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                        
                    case 5:
                    	lector = new Scanner(System.in);
                        System.out.println("Numero de Cliente:");
                        x = lector.nextInt();
                        if (b.getCliente(x)!=null) {
                        	lector = new Scanner(System.in);
                        	System.out.println("Monto del Deposito:");
                            dinero = lector.nextDouble();
                            CuentaFactory cF = new CuentaFactory();
                            CuentaDAO cDAO = cF.getImp(b.getCliente(x).getCuenta());
                            cDAO.deposito(b.getCliente(x), dinero);
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                    case 6:
                    	boolean status=false;
                    	lector = new Scanner(System.in);
                        System.out.println("Numero de Cliente:");
                        x = lector.nextInt();
                        if (b.getCliente(x)!=null) {
                        	lector = new Scanner(System.in);
                        	System.out.println("Monto del Retiro:");
                            dinero = lector.nextDouble();
                            CuentaFactory cF = new CuentaFactory();
                            CuentaDAO cDAO = cF.getImp(b.getCliente(x).getCuenta());
                            status=cDAO.retiro(b.getCliente(x), dinero);
                            if(status==true){
                            	System.out.println("Transaccion Exitosa!");
                            }else{
                            	System.out.println("Transaccion Cancelada");
                            }
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                    case 0:
                        System.out.println("Hasta Luego!");
                        break;
                    default:
                        System.out.println("Opcion no valida...");
                        break;
                }
            } while (opc != 0);
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
    }
	
}
