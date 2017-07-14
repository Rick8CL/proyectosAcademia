package com.beeva.ultimate.elbanco.dao.model;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase POJO para la tabla tipocuenta
 * Contiene anotaciones para su implementación como Entidad a la BD
 * 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipocuenta")
public class TipoCuenta {

    private int idtipocuenta;
	private String nombre;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}