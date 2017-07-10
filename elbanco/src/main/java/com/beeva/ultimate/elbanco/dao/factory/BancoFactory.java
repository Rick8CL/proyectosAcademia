package com.beeva.ultimate.elbanco.dao.factory;

import com.beeva.ultimate.elbanco.dao.impl.BancoDAOImpl;
import com.beeva.ultimate.elbanco.dao.inter.BancoDAO;
import com.beeva.ultimate.elbanco.dao.model.Banco;

public class BancoFactory {
	public BancoDAO getImp(Banco b){
		BancoDAO clienteDAO = new BancoDAOImpl();
			return clienteDAO;
	}
}