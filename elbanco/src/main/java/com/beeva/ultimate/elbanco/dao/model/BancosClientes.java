package com.beeva.ultimate.elbanco.dao.model;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase POJO para la tabla bancosclientes
 * Contiene anotaciones para su implementación como Entidad a la BD
 * 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bancosclientes")
public class BancosClientes {

    private int idbancosclientes, idcliente, idbanco;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getIdbancosclientes() {
		return idbancosclientes;
	}

	public void setIdbancosclientes(int idbancosclientes) {
		this.idbancosclientes = idbancosclientes;
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
}