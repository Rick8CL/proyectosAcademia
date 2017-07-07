package com.beeva.mysql.prueba.pruebaMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App{
    public static void main( String[] args ){
    	
        Connection connection = null;
        
        try{
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","toor");
        	
        }catch(SQLException e){
        	System.err.println("Error "+e);
        	e.printStackTrace();
        }
        
        if(connection != null){
        	System.out.println("Conectado!!!");
        	//String insert = "insert into empleado(nombre) values('Ana');";
        	String select = "select * from empleado";
        	
        	
        	try {
				//connection.prepareStatement(insert).executeUpdate();
				ResultSet rs = connection.prepareStatement(select).executeQuery();
				
				while(rs.next()){
					System.out.println(rs.getString("nombre"));
				}
				
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }else{
        	System.out.println("Conexión Fallida...");
        }
    }
}