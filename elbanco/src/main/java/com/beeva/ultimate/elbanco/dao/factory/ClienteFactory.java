package com.beeva.ultimate.elbanco.dao.factory;

import com.beeva.ultimate.elbanco.dao.impl.ClienteDAOImpl;
import com.beeva.ultimate.elbanco.dao.inter.ClienteDAO;
import com.beeva.ultimate.elbanco.dao.model.Cliente;

public class ClienteFactory {
	public ClienteDAO getImp(Cliente cli){
		ClienteDAO clienteDAO = new ClienteDAOImpl();
			return clienteDAO;
	}
}