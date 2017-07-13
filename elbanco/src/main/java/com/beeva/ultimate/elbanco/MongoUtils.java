package com.beeva.ultimate.elbanco;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtils {
	
	MongoClient mc;
	private String host, dbname, nombre, collection;
	private int puerto, edad;
	
	public void conectar(){
		try {
			
    		mc = new MongoClient(host,puerto);
    		System.out.println("Conectado a MongoDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertarCliente(int idcliente, String nombre, String apellido){
		conectar();
		DB db = mc.getDB(dbname);
		DBCollection table = db.getCollection("clientes");
		BasicDBObject document = new BasicDBObject();
		document.put("idcliente", idcliente);
		document.put("nombre", nombre);
		document.put("apellido", apellido);
		table.insert(document);
		System.out.println("Cliente insertado a MongoDB");
	}
	
	public void insertarCuenta(int idcuenta, double balance, int idcliente, int idtipocuenta){
		conectar();
		DB db = mc.getDB(dbname);
		DBCollection table = db.getCollection("cuentas");
		BasicDBObject document = new BasicDBObject();
		document.put("idcuenta", idcuenta);
		document.put("balance", balance);
		document.put("idcliente", idcliente);
		document.put("idtipocuenta", idtipocuenta);
		table.insert(document);
		System.out.println("Cuenta insertada a MongoDB");
	}

	public MongoClient getMc() {
		return mc;
	}

	public void setMc(MongoClient mc) {
		this.mc = mc;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}
	
	
}
