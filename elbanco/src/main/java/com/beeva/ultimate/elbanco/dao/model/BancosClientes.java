package com.beeva.ultimate.elbanco.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bancosclientes")
public class BancosClientes {

    private int id, idcliente, idbanco;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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