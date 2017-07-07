package com.beeva.springBankApp.bankapp.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.springBankApp.bankapp.dao.impl.CuentaDAOImplAhorro;

public class App {
	public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        
        Banco b = (Banco) context.getBean("prueba");
        Banco b2 = (Banco) context.getBean("prueba2");
        CuentaDAOImplAhorro b3 = (CuentaDAOImplAhorro) context.getBean("prueba3");
        //Inyector inyector = (Inyector) context.getBean("inyector");
    }
}
