package com.beeva.ultimate.elbanco.dao.inter;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase Abstracta para acceder a los metodos que registran y consultan
 * datos en la tabla cliente de la BD
 * 
 */

import com.beeva.ultimate.elbanco.dao.model.Cliente;

public abstract class ClienteDAO {
	public abstract void save(Cliente cliente);
	public abstract void delete(int id);
	public abstract void getAllClientes();
	public abstract Cliente getClienteById(int id);
	public abstract int getNClientes();
	public abstract String getClienteByNombre(String nombre);
}