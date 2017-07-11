package com.beeva.mongo.test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtils {
	
	MongoClient mc;
	public void conectar(String host, int puerto){
		try {
			
    		mc = new MongoClient(host,puerto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertar(String dbname, String collection, String nombre, String edad){
		DB db = mc.getDB("testdb");
		DBCollection table = db.getCollection("user");
		BasicDBObject document = new BasicDBObject();
		document.put("nombre", nombre);
		document.put("edad", edad);
		table.insert(document);
	}
}
