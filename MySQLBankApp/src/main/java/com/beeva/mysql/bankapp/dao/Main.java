package com.beeva.mysql.bankapp.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		JDBCUtils x = new JDBCUtils();
		String querry;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		
		JDBCUtils inserta = (JDBCUtils) context.getBean("inserta");
/*		
		//Insertar 2 Bancos
		querry="insert into banco(nombre) values('Bancomer');";
		x.Insertar(querry);
		querry="insert into banco(nombre) values('Banamex');";
		x.Insertar(querry);
		
		//Insertar en Bancomer 2 Clientes con Cuenta diferente
		querry="insert into cliente(nombre,apellido) values('Ricardo','Castillo');";
		x.Insertar(querry);
		querry="insert into cliente(nombre,apellido) values('Juan','Perez');";
		x.Insertar(querry);
		querry="insert into bancosclientes(idcliente,idbanco) values('1','1');";
		x.Insertar(querry);
		querry="insert into bancosclientes(idcliente,idbanco) values('2','1');";
		x.Insertar(querry);
		querry="insert into cuenta(balance,idtipocuenta,idcliente) values('8000','1','1');";
		x.Insertar(querry);
		querry="insert into cuenta(balance,idtipocuenta,idcliente) values('400','2','2');";
		x.Insertar(querry);
		
		//Insertar en Banamex 2 Clientes con Cuenta diferente
		querry="insert into cliente(nombre,apellido) values('Maria','Shanchez');";
		x.Insertar(querry);
		querry="insert into cliente(nombre,apellido) values('Ana','Mendez');";
		x.Insertar(querry);
		querry="insert into bancosclientes(idcliente,idbanco) values('3','2');";
		x.Insertar(querry);
		querry="insert into bancosclientes(idcliente,idbanco) values('4','2');";
		x.Insertar(querry);
		querry="insert into cuenta(balance,idtipocuenta,idcliente) values('6000','1','3');";
		x.Insertar(querry);
		querry="insert into cuenta(balance,idtipocuenta,idcliente) values('300','2','4');";
		x.Insertar(querry);
		
		//Consultar Clientes en Bancomer
		querry="select cliente.nombre, cliente.apellido, banco.nombre, tipocuenta.nombre, cuenta.balance from cliente, banco, tipocuenta, cuenta, bancosclientes where cliente.idcliente=cuenta.idcuenta and tipocuenta.idtipocuenta=cuenta.idtipocuenta and cliente.idcliente=bancosclientes.idcliente and banco.idbanco=bancosclientes.idbanco and banco.nombre='Bancomer';";
		x.Consultar(querry);
		
		//Consultar Clientes en Banamex
		querry="select cliente.nombre, cliente.apellido, banco.nombre, tipocuenta.nombre, cuenta.balance from cliente, banco, tipocuenta, cuenta, bancosclientes where cliente.idcliente=cuenta.idcuenta and tipocuenta.idtipocuenta=cuenta.idtipocuenta and cliente.idcliente=bancosclientes.idcliente and banco.idbanco=bancosclientes.idbanco and banco.nombre='Banamex';";
		x.Consultar(querry);
*/		
		//Consultar todos los Clientes
				querry="select cliente.nombre, cliente.apellido, banco.nombre, tipocuenta.nombre, cuenta.balance from cliente, banco, tipocuenta, cuenta, bancosclientes where cliente.idcliente=cuenta.idcuenta and tipocuenta.idtipocuenta=cuenta.idtipocuenta and cliente.idcliente=bancosclientes.idcliente and banco.idbanco=bancosclientes.idbanco;";
				x.Consultar(querry);
		
	}

}
