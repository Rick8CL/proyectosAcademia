package com.beeva.ultimate.elbanco.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.beeva.ultimate.elbanco.dao.model.Cuenta;

@Entity
@Table(name="cliente")
public class Cliente{
	
	private int idcliente;
	private String nombre, apellido;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
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

}
