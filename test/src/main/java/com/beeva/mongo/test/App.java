package com.beeva.mongo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.mongo.test.MongoUtils;;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        ApplicationContext context = new ClassPathXmlApplicationContext("springBean.xml");
        MongoUtils conecta = (MongoUtils) context.getBean("conecta");
        MongoUtils inserta = (MongoUtils) context.getBean("inserta");
        System.out.println("Exito!");
    }
}
