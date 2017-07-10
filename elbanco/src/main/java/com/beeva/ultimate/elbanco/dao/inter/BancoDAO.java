package com.beeva.ultimate.elbanco.dao.inter;

import com.beeva.ultimate.elbanco.dao.model.Banco;

public abstract class BancoDAO {
	public abstract void save(Banco banco);
	public abstract void getBancoById(int id);
}