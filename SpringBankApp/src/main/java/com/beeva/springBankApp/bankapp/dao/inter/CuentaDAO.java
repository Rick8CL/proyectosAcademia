package com.beeva.springBankApp.bankapp.dao.inter;

import com.beeva.springBankApp.bankapp.dao.Cliente;

public interface CuentaDAO {
	public boolean deposito(Cliente cliente, double dinero);
	public boolean retiro(Cliente cliente, double dinero);
}