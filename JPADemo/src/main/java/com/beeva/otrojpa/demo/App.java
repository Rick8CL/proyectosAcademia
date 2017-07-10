package com.beeva.otrojpa.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.otrojpa.demo.dao.UserDAO;
import com.beeva.otrojpa.demo.impl.UserDAOImpl;
import com.beeva.otrojpa.demo.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("context-core.xml");
        UserDAO userdao = (UserDAO) context.getBean(UserDAOImpl.class);
        
        User u = new User();
        u.setName("Clark Kent");
        u.setAddress("Smallville");
        
        //userdao.save(u);
        
        System.out.println("Correcto!");
        
        User usr = new User();
        usr = userdao.getUser(4);
        System.out.println(usr.getName());
    }
}
