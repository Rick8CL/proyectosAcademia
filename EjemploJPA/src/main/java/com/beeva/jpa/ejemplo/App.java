package com.beeva.jpa.ejemplo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.jpa.ejemplo.dao.UserDAO;
import com.beeva.jpa.ejemplo.impl.UserDAOImpl;
import com.beeva.jpa.ejemplo.model.User;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
    	UserDAO userdao = (UserDAO) context.getBean(UserDAOImpl.class);
    	
        User u = new User();
        u.setName("Ricardo");
        u.setAddress("Tultitlan");
        
        userdao.save(u);
        
        System.out.println("Usuario agregado!");
    }
}
