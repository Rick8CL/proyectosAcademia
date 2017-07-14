package com.beeva.ultimate.elbanco.dao.inter;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase Abstracta para acceder a los metodos que registran y consultan
 * datos en la tabla bancosclientes de la BD
 * 
 */

import com.beeva.ultimate.elbanco.dao.model.BancosClientes;

public abstract class BancosClientesDAO {
	public abstract void save(BancosClientes bc);
	public abstract BancosClientes getBancosclientesById(int id);
	public abstract BancosClientes getIdBancoByIdCliente(int id);
}