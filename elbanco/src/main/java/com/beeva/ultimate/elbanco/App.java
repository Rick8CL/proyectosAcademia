package com.beeva.ultimate.elbanco;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.ultimate.elbanco.MongoUtils;
import com.beeva.ultimate.elbanco.dao.factory.CuentaFactory;
import com.beeva.ultimate.elbanco.dao.inter.BancoDAO;
import com.beeva.ultimate.elbanco.dao.inter.BancosClientesDAO;
import com.beeva.ultimate.elbanco.dao.inter.ClienteDAO;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;
import com.beeva.ultimate.elbanco.dao.impl.ClienteDAOImpl;
import com.beeva.ultimate.elbanco.dao.model.Banco;
import com.beeva.ultimate.elbanco.dao.model.BancosClientes;
import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;

public class App {
	
    public static void main( String[] args ){
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("context-core.xml");
    	
        ClienteDAO clientedao = (ClienteDAO) context.getBean(ClienteDAOImpl.class);
        CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAO.class);
        BancosClientesDAO bcdao = (BancosClientesDAO) context.getBean(BancosClientesDAO.class);
        BancoDAO bancodao = (BancoDAO) context.getBean(BancoDAO.class);
        
        MongoUtils mongo = (MongoUtils) context.getBean("mongoBean");
        
        Cliente cli = new Cliente();
        Cuenta cu = new Cuenta();
        BancosClientes bc = new BancosClientes();
        Banco b = new Banco();
        Scanner lector;
        int opc = 0, x = 0;
        double dinero = 0;
        String nom = "", ape = "", tipoCuenta="", banco="";

        try {
            System.out.println("Bienvenido!!! Selecciona una opcion del siguiente menu:");
            System.out.println("Si no conoces los IDs, te sugerimos la opcion 9");
            do {
                lector = new Scanner(System.in);
                System.out.println("\n|-----------------------|\n|1. Agregar Cliente     |\n|2. Buscar Cliente      |\n|3. Cantidad de Clientes|\n|4. Saldo               |\n|5. Deposito            |\n|6. Retiro              |\n|9. Ver ID de Clientes  |\n|0. Salir               |\n|-----------------------|\n");
                String v = lector.nextLine();
                if(isInt(v)){
                	opc = Integer.parseInt(v);
                }else{
                	opc=99;
                }
                switch (opc) {
                    case 1:
                    	cli = new Cliente();
                    	cu = new Cuenta();
                    	bc = new BancosClientes();
                    	int nuevoid;
                    	boolean flag=false;

                        lector = new Scanner(System.in);
                        System.out.println("Nombre");
                        nom = lector.nextLine();
                        lector = new Scanner(System.in);
                        System.out.println("Apellido");
                        ape = lector.nextLine();
                        cli.setNombre(nom);
                        cli.setApellido(ape);
                        clientedao.save(cli);
                        
                        nuevoid=cli.getIdcliente();
                        
                        System.out.println(nuevoid);
                        
                        lector = new Scanner(System.in);
                        System.out.println("Tipo de Cuenta: AHORROS || CHEQUES");
                        tipoCuenta = lector.nextLine().toUpperCase();
                        if(tipoCuenta.equals("AHORROS")){
                        	cu.setIdtipocuenta(1);
                        }else if(tipoCuenta.equals("CHEQUES")){
                        	cu.setIdtipocuenta(2);
                        }else{
                        	System.out.println("Opcion no valida! Transascción cancelada...");
                        	clientedao.delete(cli.getIdcliente());
                        	break;
                        }
                        
                        lector = new Scanner(System.in);
                        System.out.println("Deposito Inicial:");
                        String paso=lector.nextLine();
                        if(isDouble(paso)){
                        	dinero = Double.parseDouble(paso);
                        	cu.setBalance(dinero);
                            cu.setIdcliente(nuevoid);
                        }else{
                        	System.out.println("Error de datos! Transascción cancelada...");
                        	clientedao.delete(cli.getIdcliente());
                        	break;
                        }
                        
                        cu.setBalance(dinero);
                        cu.setIdcliente(nuevoid);
                        
                        
                        lector = new Scanner(System.in);
                    	System.out.println("Banco: BANCOMER || BANAMEX");
                        banco = lector.nextLine().toUpperCase();
                        if(banco.equals("BANCOMER")){
                        	bc.setIdbanco(1);
                        }else if(banco.equals("BANAMEX")){
                        	bc.setIdbanco(2);
                        }else{
                        	clientedao.delete(cli.getIdcliente());
                        	System.out.println("Opcion no valida! Transascción cancelada...");
                        	break;
                        }
                        bc.setIdcliente(nuevoid);
                        
                        flag=true;
                        
                        if(flag==true){
                        	cuentadao.save(cu);
                        	bcdao.save(bc);
                        	System.out.println("Cliente Agregado Exitosamente!");
                        	mongo.insertarCliente(cli.getIdcliente(), cli.getNombre(), cli.getApellido());
                        	mongo.insertarCuenta(cu.getIdcuenta(), cu.getBalance(), cu.getIdcliente(), cu.getIdtipocuenta());
                        }else{
                        	clientedao.delete(cli.getIdcliente());
                        	System.out.println("Fallo el Registro del Cliente");
                        }
                        break;
                      
                    case 2:
                    	cu = new Cuenta();
                    	bc = new BancosClientes();
                        lector = new Scanner(System.in);
                        System.out.println("# de Cliente a Buscar");
                        
                        String v2 = lector.nextLine();
                        if(isInt(v2)){
                        	x = Integer.parseInt(v2);
                        }else{
                        	System.out.println("Error de datos! Transascción cancelada...");
                        	break;
                        }
                        
                        
                        if (clientedao.getClienteById(x)!=null) {
                        	System.out.println(clientedao);
                        	cli = clientedao.getClienteById(x);
                        	bc = bcdao.getIdBancoByIdCliente(x);
                        	b = bancodao.getBancoById(bc.getIdbanco());
                            System.out.println("Cliente encontrado: " + cli.getNombre()+" "+cli.getApellido()+" del Banco "+b.getNombre());
                        } else {
                            System.out.println("Cliente no Encontrado");
                        }
                        break;
                        
                    case 3:
                    	
                    	System.out.println("Actualmente hay " + clientedao.getNClientes() + " clientes en el banco");
                        break;
                        
                    case 4:
                    	lector = new Scanner(System.in);
                    	System.out.println("Numero de Cliente:");
                    	String v3 = lector.nextLine();
                        if(isInt(v3)){
                        	x = Integer.parseInt(v3);
                        }else{
                        	System.out.println("Error de datos! Transascción cancelada...");
                        	break;
                        }
                        if (clientedao.getClienteById(x)!=null) {
                        	cli = clientedao.getClienteById(x);
                        	cu = cuentadao.getCuentaByIdCliente(cli.getIdcliente());
                            System.out.println("Cliente: " + cli.getNombre() + " con un saldo de: $" + cu.getBalance());
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                        
                    case 5:
                    	lector = new Scanner(System.in);
                        System.out.println("Numero de Cliente:");
                        String v4 = lector.nextLine();
                        if(isInt(v4)){
                        	x = Integer.parseInt(v4);
                        }else{
                        	System.out.println("Error de datos! Transascción cancelada...");
                        	break;
                        }
                        if (clientedao.getClienteById(x)!=null) {
                        	cli = clientedao.getClienteById(x);
                        	cu = cuentadao.getCuentaByIdCliente(cli.getIdcliente());
                            
                            lector = new Scanner(System.in);
                            System.out.println("Monto del Deposito:");
                            String paso2=lector.nextLine();
                            if(isDouble(paso2)){
                            	dinero = Double.parseDouble(paso2);
                            	cuentadao.deposito(cu, dinero);
                            }else{
                            	System.out.println("Error de datos! Transascción cancelada...");
                            	break;
                            }
                            
                            
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;    
                    case 6:
                    	lector = new Scanner(System.in);
               
                    	System.out.println("Numero de Cliente:");
                    	String v5 = lector.nextLine();
                        if(isInt(v5)){
                        	x = Integer.parseInt(v5);
                        }else{
                        	System.out.println("Error de datos! Transascción cancelada...");
                        	break;
                        }
                        if (clientedao.getClienteById(x)!=null) {
                        	cli = clientedao.getClienteById(x);
                        	cu = cuentadao.getCuentaByIdCliente(cli.getIdcliente());
                        	
                        	lector = new Scanner(System.in);
                            System.out.println("Monto del Retiro:");
                            String paso2=lector.nextLine();
                            if(isDouble(paso2)){
                            	dinero = Double.parseDouble(paso2);
                            	cuentadao.retiro(cu, dinero);
                            }else{
                            	System.out.println("Error de datos! Transascción cancelada...");
                            	break;
                            }
                            
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                    case 9:
                    	clientedao.getAllClientes();
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
            System.out.println("Error " + e);
        }
        
        //ZorroX/SpringBatchDemo.git
    }
    
    public static boolean isDouble(String d){
    	boolean flag=false;
    	double dinero;
    	try{
    		dinero = Double.parseDouble(d);
    		flag = true;
    		return flag;
    	}catch(Exception e){
    		flag=false;
    		return flag;
    	}
    	
    }
    
    public static boolean isInt(String s){
    	boolean flag=false;
    	int num;
    	try{
    		num = Integer.parseInt(s);
    		flag = true;
    		return flag;
    	}catch(Exception e){
    		flag=false;
    		return flag;
    	}
    	
    }
}