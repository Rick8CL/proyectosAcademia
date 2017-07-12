package com.beeva.ultimate.elbanco.dao.inter;

import com.beeva.ultimate.elbanco.dao.model.Cliente;

public abstract class ClienteDAO {
	public abstract void save(Cliente cliente);
	public abstract Cliente getClienteById(int id);
	public abstract int getNClientes();
	public abstract String getClienteByNombre(String nombre);
}