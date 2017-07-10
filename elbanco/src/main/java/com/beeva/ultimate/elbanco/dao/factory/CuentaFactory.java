package com.beeva.ultimate.elbanco.dao.factory;

import com.beeva.ultimate.elbanco.dao.impl.CuentaDAOImplAhorro;
import com.beeva.ultimate.elbanco.dao.impl.CuentaDAOImplCheques;
import com.beeva.ultimate.elbanco.dao.inter.CuentaDAO;
import com.beeva.ultimate.elbanco.dao.model.Cuenta;

public class CuentaFactory {
	public CuentaDAO getImp(Cuenta cu){
		if(cu.getTipoCuenta().equals("AHORROS")){
			CuentaDAO cuentaDAO = new CuentaDAOImplAhorro();
			return cuentaDAO;
		}else if(cu.getTipoCuenta().equals("CHEQUES")){
			CuentaDAO cuentaDAO = new CuentaDAOImplCheques();
			return cuentaDAO;
		}else{
			return null;
		}
	}
}