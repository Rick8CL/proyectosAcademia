package com.beeva.maven.bankapp.dao.inter;

import com.beeva.maven.bankapp.dao.Cliente;

public interface CuentaDAO {
	public boolean deposito(Cliente cliente, double dinero);
	public boolean retiro(Cliente cliente, double dinero);
}