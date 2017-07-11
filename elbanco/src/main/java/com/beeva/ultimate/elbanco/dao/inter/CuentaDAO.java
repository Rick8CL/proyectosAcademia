package com.beeva.ultimate.elbanco.dao.inter;

import com.beeva.ultimate.elbanco.dao.model.Cuenta;

public abstract class CuentaDAO {
	public abstract boolean deposito(Cuenta cuenta, double dinero);
	public abstract boolean retiro(Cuenta cuenta, double dinero);
	public abstract void save(Cuenta cuenta);
	public abstract Cuenta getCuentaById(int id);
}