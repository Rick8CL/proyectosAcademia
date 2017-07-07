package com.beeva.mysql.bankapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	private Cliente cliente;
	private int idcliente, idbanco, idtipocuenta, ultimocliente;
	private Connection connection = null;
	
	public void iniciarConexion(){
        
        try{
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp?&useSSL=false","root","toor");
        	
        }catch(SQLException e){
        	System.err.println("Error "+e);
        	e.printStackTrace();
        }
        
        if(connection == null){
        	System.out.println("Conexión Fallida...");
        }
	}
	
	public void cerrarConexion(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Insertar(String querry){

		iniciarConexion();
		
		if(connection!=null){
			try {
				connection.prepareStatement(querry).executeUpdate();
				System.out.println("Inserción correcta!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		cerrarConexion();
	}
	
	public void insertarCliente(){
		
		String querry, querry2, querry3;
		
		querry="insert into cliente(nombre,apellido) values('"+cliente.getNombre()+"','"+cliente.getApellido()+"');";
		querry2="insert into bancosclientes(idcliente,idbanco) values('"+idcliente+"','"+idbanco+"');";
		querry3="insert into cuenta(balance,idtipocuenta,idcliente) values('"+cliente.getCuenta().getBalance()+"','"+idtipocuenta+"','"+idcliente+"');";
		
		iniciarConexion();
		
		if(connection!=null){
			try {
				connection.prepareStatement(querry).executeUpdate();
				connection.prepareStatement(querry2).executeUpdate();
				connection.prepareStatement(querry3).executeUpdate();
				System.out.println("Inserción correcta desde XML!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		cerrarConexion();
	}
	
	public void Consultar(String querry){
		iniciarConexion();
		
		if(connection!=null){
			try {
				ResultSet rs = connection.prepareStatement(querry).executeQuery();
				
				while(rs.next()){
					String cn = rs.getString("cliente.nombre");
					String ca = rs.getString("cliente.apellido");
					String bn = rs.getString("banco.nombre");
					String tn = rs.getString("tipocuenta.nombre");
					Double cb = rs.getDouble("cuenta.balance");
					
					System.out.println(cn + " " + ca +" del Banco " + bn + " tiene una cuenta de " + tn + " y un saldo de " + cb);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		cerrarConexion();
	}

	public void ultimoCliente(){
		ultimocliente=0;
		iniciarConexion();
		
		if(connection!=null){
			try {
				ResultSet rs = connection.prepareStatement("select * from cliente").executeQuery();
				
				while(rs.next()){
					ultimocliente++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		cerrarConexion();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdbanco() {
		return idbanco;
	}

	public void setIdbanco(int idbanco) {
		this.idbanco = idbanco;
	}

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public int getUltimocliente() {
		return ultimocliente;
	}

	public void setUltimocliente(int ultimocliente) {
		this.ultimocliente = ultimocliente;
	}
	
	
}
