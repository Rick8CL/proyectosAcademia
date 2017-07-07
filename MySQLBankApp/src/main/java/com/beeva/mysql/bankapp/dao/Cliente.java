package com.beeva.mysql.bankapp.dao;

import com.beeva.mysql.bankapp.dao.model.Cuenta;

/**
 * Clase que declara un Cliente
 * Ricardo Castillo Lara
 * 03/07/2017
 */
public class Cliente{
	private String nombre="", apellido="";
	private Cuenta cuenta;

	public Cliente(String nom, String ape, Cuenta cue){
		nombre=nom;
		apellido=ape;
		cuenta=cue;
	}

	public String getNombre(){
		return nombre;
	}

	public String setNombre(String nombre){
		this.nombre=nombre;
		return nombre;
	}

	public String getApellido(){
		return apellido;
	}

	public String setApellido(String apellido){
		this.apellido=apellido;
		return apellido;
	}

	public Cuenta getCuenta(){
		return cuenta;
	}

	public Cuenta setCuenta(Cuenta cuenta){
		this.cuenta=cuenta;
		return cuenta;
	}
}
