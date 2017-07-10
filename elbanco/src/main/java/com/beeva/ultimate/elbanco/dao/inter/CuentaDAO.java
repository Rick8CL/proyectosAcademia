package com.beeva.ultimate.elbanco.dao.inter;

import com.beeva.ultimate.elbanco.dao.model.Cliente;

public interface CuentaDAO {
	public boolean deposito(Cliente cliente, double dinero);
	public boolean retiro(Cliente cliente, double dinero);
}