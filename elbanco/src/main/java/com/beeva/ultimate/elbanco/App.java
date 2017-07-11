package com.beeva.ultimate.elbanco;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.ultimate.elbanco.dao.inter.BancosClientesDAO;
import com.beeva.ultimate.elbanco.dao.inter.ClienteDAO;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;
import com.beeva.ultimate.elbanco.dao.impl.ClienteDAOImpl;
import com.beeva.ultimate.elbanco.dao.model.BancosClientes;
import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;

public class App {
	
    public static void main( String[] args ){
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("context-core.xml");
    	
        ClienteDAO clientedao = (ClienteDAO) context.getBean(ClienteDAOImpl.class);
        CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAO.class);
        BancosClientesDAO bcdao = (BancosClientesDAO) context.getBean(BancosClientesDAO.class);
        
        
        Cliente cli = new Cliente();
        /*
        cli.setNombre("Ricardo");
        cli.setApellido("Castillo");
        clientedao.save(cli);        
        */
        
        Cuenta cu = new Cuenta();
        /*
        cu.setBalance(8000);
        cu.setIdcliente(3);
        cu.setIdtipocuenta(1);
        cuentadao.save(cu);        
        */
        
        
        BancosClientes bc = new BancosClientes();
        /*
        bc.setIdbanco(1);
        bc.setIdcliente(1);
        bcdao.save(bc);
        */
        
        cli = clientedao.getClienteById(1);
        System.out.println(cli.getNombre());
        
        /*
        Scanner lector;
        int opc = 0, x = 0;
        double dinero = 0;
        String nom = "", ape = "", tipoCuenta="", banco="";

        try {
            System.out.println("Bienvenido!!! Selecciona una opcion del siguiente menu:");
            do {
                lector = new Scanner(System.in);
                System.out.println("\n|-----------------------|\n|1. Agregar Cliente     |\n|2. Buscar Cliente      |\n|3. Cantidad de Clientes|\n|4. Saldo               |\n|5. Deposito            |\n|6. Retiro              |\n|0. Salir               |\n|-----------------------|\n");
                opc = lector.nextInt();
                switch (opc) {
                    case 1:
                    	boolean flag=false;
                    	
                        lector = new Scanner(System.in);
                        System.out.println("Nombre");
                        nom = lector.nextLine();
                        lector = new Scanner(System.in);
                        System.out.println("Apellido");
                        ape = lector.nextLine();
                        lector = new Scanner(System.in);
                        cli.setNombre(nom);
                        cli.setApellido(ape);
                        clientedao.save(cli);
                        System.out.println("Tipo de Cuenta: AHORROS || CHEQUES");
                        tipoCuenta = lector.nextLine().toUpperCase();
                        if(tipoCuenta.equals("AHORROS")){
                        	cu.setIdtipocuenta(1);
                        }else{
                        	cu.setIdtipocuenta(2);
                        }
                        lector = new Scanner(System.in);
                        System.out.println("Deposito Inicial:");
                        dinero = lector.nextDouble();
                        cu.setBalance(dinero);
                        cu.setIdcliente(idcliente);
                        cuentadao.save(cu);
                        
                        System.out.println("Cliente a Agregar");
                    	System.out.println("Banco: BANCOMER || BANAMEX");
                        banco = lector.nextLine().toUpperCase();
                        if(banco.equals("BANCOMER")){
                        	cu.setIdtipocuenta(1);
                        }else{
                        	cu.setIdtipocuenta(2);
                        }
                        
                        if(flag==true){
                        	System.out.println("Cliente Agregado Exitosamente!");
                        }else{
                        	System.out.println("Fallo el Registro del Cliente");
                        }
                        break;
                    /*    
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
        */
    }
}