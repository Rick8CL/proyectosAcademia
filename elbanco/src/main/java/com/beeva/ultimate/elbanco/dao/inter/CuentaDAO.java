package com.beeva.ultimate.elbanco.dao.inter;

import com.beeva.ultimate.elbanco.dao.model.Cuenta;

public abstract class CuentaDAO {
	public abstract Cuenta deposito(Cuenta cuenta, double dinero);
	public abstract Cuenta retiro(Cuenta cuenta, double dinero);
	public abstract void save(Cuenta cuenta);
	public abstract Cuenta getCuentaById(int id);
	public abstract Cuenta getCuentaByIdCliente(int id);
}