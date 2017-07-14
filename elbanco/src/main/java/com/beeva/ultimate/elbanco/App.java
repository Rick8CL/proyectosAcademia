package com.beeva.ultimate.elbanco;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase Principal, contiene un menú que manda a llamar a todos los métodos
 * asignandoles sus respectivos parámetros.
 * Instancia los contextos requeridos para la manipulación de los datos.
 * Cuenta con un básico y primitivo control de Excepciones para el desplazo
 * por el menú.
 * 
 * No cuenta con interfaz gráfica.
 * Se puede iniciar una cuenta con 0 pesos
 * Para asignar Tipo de Cuenta y Banco debe esccribirse el nombre completo,
 * no es Case Sensitive.
 * 
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.ultimate.elbanco.MongoUtils;
import com.beeva.ultimate.elbanco.dao.inter.BancoDAO;
import com.beeva.ultimate.elbanco.dao.inter.BancosClientesDAO;
import com.beeva.ultimate.elbanco.dao.inter.ClienteDAO;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;
import com.beeva.ultimate.elbanco.dao.inter.TipoCuentaDAO;
import com.beeva.ultimate.elbanco.dao.impl.ClienteDAOImpl;
import com.beeva.ultimate.elbanco.dao.model.Banco;
import com.beeva.ultimate.elbanco.dao.model.BancosClientes;
import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;
import com.beeva.ultimate.elbanco.dao.model.TipoCuenta;

public class App {
	
    public static void main( String[] args ){
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("context-core.xml");
    	
        ClienteDAO clientedao = (ClienteDAO) context.getBean(ClienteDAOImpl.class);
        CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAO.class);
        BancosClientesDAO bcdao = (BancosClientesDAO) context.getBean(BancosClientesDAO.class);
        BancoDAO bancodao = (BancoDAO) context.getBean(BancoDAO.class);
        TipoCuentaDAO tipocuentadao = (TipoCuentaDAO) context.getBean(TipoCuentaDAO.class);
        
        MongoUtils mongo = (MongoUtils) context.getBean("mongoBean");
        
        Cliente cli = new Cliente();
        Cuenta cu = new Cuenta();
        BancosClientes bc = new BancosClientes();
        Banco b = new Banco();
        TipoCuenta tc = new TipoCuenta();
        
        //Agregamos manualmente los Bancos y los Tipos de Cuenta
        if(bancodao.getBancoById(1)==(null)){
        	b = new Banco();
            b.setNombre("BANCOMER");        
            bancodao.save(b);
        }else{
        	System.out.println("Ya existe el banco "+bancodao.getBancoById(1).getNombre());
        }
        if(bancodao.getBancoById(2)==(null)){
        	b = new Banco();
            b.setNombre("BANAMEX");
            bancodao.save(b);
    	}else{
        	System.out.println("Ya existe el banco "+bancodao.getBancoById(2).getNombre());
        }
        if(tipocuentadao.getTipoCuentaById(1)==(null)){
        	tc = new TipoCuenta();
            tc.setNombre("AHORROS");
            tipocuentadao.save(tc);
        }else{
        	System.out.println("Ya existe el tipo de cuenta "+tipocuentadao.getTipoCuentaById(1).getNombre());
        }
        if(tipocuentadao.getTipoCuentaById(2)==(null)){
        	tc = new TipoCuenta();
            tc.setNombre("CHEQUES");
            tipocuentadao.save(tc);
        }else{
        	System.out.println("Ya existe el tipo de cuenta "+tipocuentadao.getTipoCuentaById(2).getNombre());
        }
        
        Scanner lector;
        int opc = 0, x = 0;
        double dinero = 0;
        String nom = "", ape = "", tipoCuenta="", banco="";

        try {
            System.out.println("Bienvenido!!! Selecciona una opcion del siguiente menu:");
            System.out.println("Si no conoces los IDs, te sugerimos la opcion 9");
            do {
                lector = new Scanner(System.in);
                System.out.println("\n|--------------------------------------|\n|1.  Agregar Cliente                   |\n|2.  Buscar Cliente                    |\n|3.  Agregar Cuenta a Cliente Existente|\n|4.  Cantidad de Clientes              |\n|5.  Saldo                             |\n|6.  Deposito                          |\n|7.  Retiro                            |\n|9.  Ver ID de Clientes                |\n|10. Ejecutar Batch                    |\n|0.  Salir                             |\n|--------------------------------------|\n");
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
                    	
                    	Pattern pat = Pattern.compile("[a-zA-Z]+");

                        lector = new Scanner(System.in);
                        System.out.println("Nombre");
                        nom = lector.nextLine();
                        lector = new Scanner(System.in);
                        System.out.println("Apellido");
                        ape = lector.nextLine();
                        Matcher mnom = pat.matcher(nom);
                        Matcher mape = pat.matcher(ape);
                        
                        if(mnom.matches() && mape.matches()){
                        	cli.setNombre(nom);
                            cli.setApellido(ape);
                            clientedao.save(cli);
                        }else{
                        	System.out.println("Error de tipo de dato... No es un nombre valido!");
                        	break;
                        }
                        
                        
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
                        System.out.println("Deposito Inicial: (Puede ser 0)");
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
                        	Date hoy = new Date();
                        	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        	String fecha = formato.format(hoy);
                        	System.out.println(fecha);
                        	cuentadao.save(cu);
                        	bcdao.save(bc);
                        	System.out.println("Cliente Agregado Exitosamente!");
                        	mongo.insertarCliente(cli.getIdcliente(), cli.getNombre(), cli.getApellido(),fecha);
                        	mongo.insertarCuenta(cu.getIdcuenta(), cu.getBalance(), cu.getIdcliente(), cu.getIdtipocuenta(),fecha);
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
                        	cli = clientedao.getClienteById(x);
                        	bc = bcdao.getIdBancoByIdCliente(x);
                        	b = bancodao.getBancoById(bc.getIdbanco());
                            System.out.println("Cliente encontrado: " + cli.getNombre()+" "+cli.getApellido()+" del Banco "+b.getNombre());
                        } else {
                            System.out.println("Cliente no Encontrado");
                        }
                        break;
                    
                    case 3:
                    	cu = new Cuenta();
                    	bc = new BancosClientes();
                        lector = new Scanner(System.in);
                        System.out.println("# de Cliente existente");
                        
                        String v6 = lector.nextLine();
                        if(isInt(v6)){
                        	x = Integer.parseInt(v6);
                        }else{
                        	System.out.println("Error de datos! Transascción cancelada...");
                        	break;
                        }
                        
                        
                        if (clientedao.getClienteById(x)!=null) {
                        	cli = clientedao.getClienteById(x);
                        	bc = bcdao.getIdBancoByIdCliente(x);
                        	b = bancodao.getBancoById(bc.getIdbanco());
                            System.out.println("Cliente encontrado: " + cli.getNombre()+" "+cli.getApellido()+" del Banco "+b.getNombre());
                            
                            System.out.println("Generando nueva cuenta...");
                            int nuevoid2=cli.getIdcliente();
                            
                            lector = new Scanner(System.in);
                            System.out.println("Tipo de Cuenta: AHORROS || CHEQUES");
                            tipoCuenta = lector.nextLine().toUpperCase();
                            if(tipoCuenta.equals("AHORROS")){
                            	cu.setIdtipocuenta(1);
                            }else if(tipoCuenta.equals("CHEQUES")){
                            	cu.setIdtipocuenta(2);
                            }else{
                            	System.out.println("Opcion no valida! Transascción cancelada...");
                            	break;
                            }
                            
                            lector = new Scanner(System.in);
                            System.out.println("Deposito Inicial: (Puede ser 0)");
                            String paso2=lector.nextLine();
                            if(isDouble(paso2)){
                            	dinero = Double.parseDouble(paso2);
                            	cu.setBalance(dinero);
                                cu.setIdcliente(nuevoid2);
                            }else{
                            	System.out.println("Error de datos! Transascción cancelada...");
                            	clientedao.delete(cli.getIdcliente());
                            	break;
                            }
                            
                            cu.setBalance(dinero);
                            cu.setIdcliente(nuevoid2);
                            
                            flag=true;
                            
                            if(flag==true){
                            	cuentadao.save(cu);
                            	Date hoy = new Date();
                            	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            	String fecha = formato.format(hoy);
                            	System.out.println(fecha);
                            	System.out.println("Nueva Cuenta Agregada Exitosamente!");
                            	mongo.insertarCuenta(cu.getIdcuenta(), cu.getBalance(), cu.getIdcliente(), cu.getIdtipocuenta(), fecha);
                            }else{
                            	clientedao.delete(cli.getIdcliente());
                            	System.out.println("Fallo el Registro de la Nueva Cuenta...");
                            }
                            
                        } else {
                            System.out.println("Cliente no Encontrado");
                        }
                    	break;
                        
                    case 4:
                    	
                    	System.out.println("Actualmente hay " + clientedao.getNClientes() + " clientes en el banco");
                        break;
                        
                    case 5:
                    	List<Cuenta> list;
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
                        	System.out.println(cli.getNombre()+" Estas son tus cuentas disponibles: ");
                        	list=cuentadao.getCuentasByCliente(x);
                        	
                        	
                        	int y;
                        	lector = new Scanner(System.in);
                        	System.out.println("Numero de Cuenta:");
                        	String v7 = lector.nextLine();
                            if(isInt(v7)){
                            	y = Integer.parseInt(v7);
                            }else{
                            	System.out.println("Error de datos! Transascción cancelada...");
                            	break;
                            }
                            
                            boolean estuya=false;
                            for(int k=0;k<list.size();k++){
                        		int w = list.get(k).getIdcuenta();
                        		
                        		if(y==w){
                        			cu = cuentadao.getCuentaById(y);
                        			estuya=true;
                        			break;
                        		}else{
                        			estuya=false;
                        		}
                        	}
                            if(estuya){
                            	System.out.println("Cliente: " + cli.getNombre() + " con un saldo de: $" + cu.getBalance());
                            }else{
                            	System.out.println("Cuenta incorrecta para este cliente");
                            }
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                        
                    case 6:
                    	cu = new Cuenta();
                    	List<Cuenta> listdd;
                    	lector = new Scanner(System.in);
                        System.out.println("Numero de Cliente:");
                        String v0 = lector.nextLine();
                        if(isInt(v0)){
                        	x = Integer.parseInt(v0);
                        }else{
                        	System.out.println("Error de datos! Transascción cancelada...");
                        	break;
                        }
                        if (clientedao.getClienteById(x)!=null) {
                        	cli = clientedao.getClienteById(x);
                        	System.out.println(cli.getNombre()+" Estas son tus cuentas disponibles: ");
                        	listdd=cuentadao.getCuentasByCliente(x);
                        	
                        	int y;
                        	lector = new Scanner(System.in);
                        	System.out.println("Numero de Cuenta:");
                        	String v8 = lector.nextLine();
                            if(isInt(v8)){
                            	y = Integer.parseInt(v8);
                            }else{
                            	System.out.println("Error de datos! Transascción cancelada...");
                            	break;
                            }
                        	
                            boolean estuya=false;
                            for(int k=0;k<listdd.size();k++){
                        		int w = listdd.get(k).getIdcuenta();
                        		
                        		if(y==w){
                        			cu = cuentadao.getCuentaById(y);
                        			estuya=true;
                        			break;
                        		}else{
                        			estuya=false;
                        		}
                        	}
                            if(estuya){
                            	System.out.println("Cliente: " + cli.getNombre() + " con un saldo de: $" + cu.getBalance());
                            	lector = new Scanner(System.in);
                                System.out.println("Monto del Deposito:");
                                String paso2=lector.nextLine();
                                if(isDouble(paso2)){
                                	dinero = Double.parseDouble(paso2);
                                	if(dinero>0){
                                		try{
                                			String tcuenta;
                                        	KieServices ks = KieServices.Factory.get();
                                        	KieContainer kContainer = ks.getKieClasspathContainer();
                                        	KieSession kSession = kContainer.newKieSession("ksession-rules");
                                        	
                                        	Drool drool = new Drool();
                                        	drool.setDeposito(dinero);
                                        	drool.setSaldo(cu.getBalance());
                                        	if(cu.getIdtipocuenta()==1){
                                        		tcuenta="AHORROS";
                                        	}else if(cu.getIdtipocuenta()==2){
                                        		tcuenta="CHEQUES";
                                        	}else{
                                        		tcuenta="";
                                        	}
                                        	drool.setTipocuenta(tcuenta);

                                			FactHandle fact1;
                                        	       	
                                        	fact1 = kSession.insert(drool);
                                        	kSession.fireAllRules();
                                        	cuentadao.deposito(cu, dinero);
                                        	if(drool.getSospecha()==null){
                                        		System.out.println("Drool dice: Deposito listo!");
                                        	}else{
                                        		System.out.println("Drool dice: "+drool.getSospecha());
                                        	}
                                        }catch(Exception t){
                                        	t.printStackTrace();
                                        }
                                	}else{
                                		System.out.println("Cantidad inválida! Transascción cancelada...");
                                    	break;
                                	}
                                }else{
                                	System.out.println("Error de datos! Transascción cancelada...");
                                	break;
                                }
                            }else{
                            	System.out.println("Cuenta incorrecta para este cliente");
                            }
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;    
                    case 7:
                    	List<Cuenta> listr;
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
                        	System.out.println(cli.getNombre()+" Estas son tus cuentas disponibles: ");
                        	listr=cuentadao.getCuentasByCliente(x);
                        	
                        	int y;
                        	lector = new Scanner(System.in);
                        	System.out.println("Numero de Cuenta:");
                        	String v9 = lector.nextLine();
                            if(isInt(v9)){
                            	y = Integer.parseInt(v9);
                            }else{
                            	System.out.println("Error de datos! Transascción cancelada...");
                            	break;
                            }
                        	
                            boolean estuya=false;
                            for(int k=0;k<listr.size();k++){
                        		int w = listr.get(k).getIdcuenta();
                        		
                        		if(y==w){
                        			cu = cuentadao.getCuentaById(y);
                        			estuya=true;
                        			break;
                        		}else{
                        			estuya=false;
                        		}
                        	}
                            if(estuya){
                            	System.out.println("Cliente: " + cli.getNombre() + " con un saldo de: $" + cu.getBalance());
                            	lector = new Scanner(System.in);
                                System.out.println("Monto del Retiro:");
                                String paso2=lector.nextLine();
                                if(isDouble(paso2)){
                                	dinero = Double.parseDouble(paso2);
                                	if(dinero>0){
                                		cuentadao.retiro(cu, dinero);
                                		System.out.println("Saldo actual "+cu.getBalance());
                                	}else{
                                		System.out.println("Cantidad inválida! Transascción cancelada...");
                                    	break;
                                	}
                                }else{
                                	System.out.println("Error de datos! Transascción cancelada...");
                                	break;
                                }
                            }else{
                            	System.out.println("Cuenta incorrecta para este cliente");
                            }
                        } else {
                            System.out.println("Cliente no registrado");
                        }
                        break;
                    case 8:
                    	System.out.println("Zona de pruebas");
                    	Date hoy = new Date();
                    	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    	String fecha = formato.format(hoy);
                    	System.out.println(fecha);

                    	break;
                    case 9:
                    	clientedao.getAllClientes();
                    	break;
                    case 10:
                    	ApplicationContext contextJob = new ClassPathXmlApplicationContext("jobSimple.xml");
                    	JobLauncher jobLauncher = (JobLauncher) contextJob.getBean("jobLauncher");
                    	Job job = (Job) contextJob.getBean("processFileJob");
                    	try {
                			JobExecution exe = jobLauncher.run(job, new JobParameters());
                			System.out.println("status: "+exe.getStatus());
                		} catch (Exception e) {
                			System.out.println("Error al ejecutar el Batch...");
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
    		System.out.println("Error de tipo de dato...");
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
    		System.out.println("Error de tipo de dato...");
    		return flag;
    	}
    	
    }
}