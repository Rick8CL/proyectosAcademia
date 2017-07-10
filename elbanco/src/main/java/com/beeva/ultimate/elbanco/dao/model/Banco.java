package com.beeva.ultimate.elbanco.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banco")
public class Banco {

    private int id;
	private String nombre;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Banco(String nom){
    	nombre=nom;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}