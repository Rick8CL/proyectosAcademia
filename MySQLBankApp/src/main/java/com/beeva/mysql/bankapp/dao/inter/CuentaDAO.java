package com.beeva.mysql.bankapp.dao.inter;

import com.beeva.mysql.bankapp.dao.Cliente;

public interface CuentaDAO {
	public boolean deposito(Cliente cliente, double dinero);
	public boolean retiro(Cliente cliente, double dinero);
}