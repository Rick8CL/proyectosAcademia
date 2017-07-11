package com.beeva.ultimate.elbanco.dao.inter;

import com.beeva.ultimate.elbanco.dao.model.BancosClientes;

public abstract class BancosClientesDAO {
	public abstract void save(BancosClientes bc);
	public abstract BancosClientes getBancoById(int id);
}