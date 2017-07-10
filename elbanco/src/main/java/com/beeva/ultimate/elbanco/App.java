package com.beeva.ultimate.elbanco;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.ultimate.elbanco.dao.inter.ClienteDAO;
import com.beeva.ultimate.elbanco.dao.impl.ClienteDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Context del Cliente
    	ApplicationContext context = new ClassPathXmlApplicationContext("context-core.xml");
        ClienteDAO cliente = (ClienteDAO) context.getBean(ClienteDAOImpl.class);
    }
}
