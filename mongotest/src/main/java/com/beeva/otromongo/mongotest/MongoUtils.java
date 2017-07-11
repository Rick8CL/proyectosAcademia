package com.beeva.otromongo.mongotest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtils {
	
	MongoClient mc;
	private String host, dbname, nombre, collection;
	private int puerto, edad;
	
	public void conectar(String host, int puerto){
		try {
			
    		mc = new MongoClient(host,puerto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertar(){
		conectar(host,puerto);
		DB db = mc.getDB(dbname);
		DBCollection table = db.getCollection(collection);
		BasicDBObject document = new BasicDBObject();
		document.put("nombre", nombre);
		document.put("edad", edad);
		table.insert(document);
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
