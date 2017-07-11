package com.beeva.ultimate.elbanco;

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
        
        /*
        Cliente cli = new Cliente();
        cli.setNombre("Joaquin");
        cli.setApellido("Ramirez");
        clientedao.save(cli);        
        */
        
        /*
        Cuenta cu = new Cuenta();
        cu.setBalance(5000);
        cu.setIdcliente(1);
        cu.setIdtipocuenta(1);
        cuentadao.save(cu);        
        */
        
        /*
        BancosClientes bc = new BancosClientes();
        bc.setIdbanco(1);
        bc.setIdcliente(1);
        bcdao.save(bc);
        */
        
        System.out.println("Sí sirvió!");
    }
}