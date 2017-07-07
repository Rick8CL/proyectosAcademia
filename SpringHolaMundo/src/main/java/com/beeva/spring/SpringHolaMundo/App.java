package com.beeva.spring.SpringHolaMundo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.spring.saluda.Saludador;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        
        Saludador saludador = (Saludador) context.getBean("saludador");
    }
}