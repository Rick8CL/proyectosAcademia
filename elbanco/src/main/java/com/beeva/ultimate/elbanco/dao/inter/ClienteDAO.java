package com.beeva.ultimate.elbanco.dao.inter;

import com.beeva.ultimate.elbanco.dao.model.Cliente;

public abstract class ClienteDAO {
	public abstract void save(Cliente cliente, double dinero);
	public abstract void getClienteById(Cliente cliente, double dinero);
}