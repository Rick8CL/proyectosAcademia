package com.beeva.otromongo.mongotest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.otromongo.mongotest.MongoUtils;;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        ApplicationContext context = new ClassPathXmlApplicationContext("springBean.xml");
        MongoUtils inserta = (MongoUtils) context.getBean("mongoBean");
        System.out.println("Exito!");
    }
}
