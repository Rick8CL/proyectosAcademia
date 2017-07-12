package com.beeva.ultimate.elbanco;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        Banco b = new Banco();
        
        //cli = clientedao.getClienteById(1);
        //System.out.println(cli.getNombre());
        
        
        
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
                        }else{
                        	cu.setIdtipocuenta(2);
                        }
                        lector = new Scanner(System.in);
                        System.out.println("Deposito Inicial:");
                        dinero = lector.nextDouble();
                        cu.setBalance(dinero);
                        cu.setIdcliente(nuevoid);
                        cuentadao.save(cu);
                        
                        lector = new Scanner(System.in);
                    	System.out.println("Banco: BANCOMER || BANAMEX");
                        banco = lector.nextLine().toUpperCase();
                        if(banco.equals("BANCOMER")){
                        	bc.setIdbanco(1);
                        }else{
                        	bc.setIdbanco(2);
                        }
                        bc.setIdcliente(nuevoid);
                        bcdao.save(bc);
                        
                        flag=true;
                        
                        if(flag==true){
                        	System.out.println("Cliente Agregado Exitosamente!");
                        }else{
                        	System.out.println("Fallo el Registro del Cliente");
                        }
                        break;
                      
                    case 2:
                        lector = new Scanner(System.in);
                        System.out.println("# de Cliente a Buscar");
                        x = lector.nextInt();
                        if (clientedao.getClienteById(x)!=null) {
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
                        x = lector.nextInt();
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
                        x = lector.nextInt();
                        if (clientedao.getClienteById(x)!=null) {
                        	cli = clientedao.getClienteById(x);
                        	cu = cuentadao.getCuentaByIdCliente(cli.getIdcliente());
                        	
                        	lector = new Scanner(System.in);
                        	System.out.println("Monto del Deposito:");
                            dinero = lector.nextDouble();
                            
                            cuentadao.deposito(cu, dinero);
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;    
                    case 6:
                    	lector = new Scanner(System.in);
               
                    	System.out.println("Numero de Cliente:");
                        x = lector.nextInt();
                        if (clientedao.getClienteById(x)!=null) {
                        	cli = clientedao.getClienteById(x);
                        	cu = cuentadao.getCuentaByIdCliente(cli.getIdcliente());
                        	
                        	lector = new Scanner(System.in);
                        	System.out.println("Monto del Retiro:");
                            dinero = lector.nextDouble();
                            
                            cuentadao.retiro(cu, dinero);
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
            System.out.println("Error " + e);
        }
        //Query query = em.createQuery("select e "+"from Banco e");
        //List<Banco> list=(List<Banco>)query.getResultList());
        //ZorroX/SpringBatchDemo.git
    }
}