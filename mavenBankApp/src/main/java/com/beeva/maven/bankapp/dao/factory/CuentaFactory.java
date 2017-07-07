package com.beeva.maven.bankapp.dao.factory;

import com.beeva.maven.bankapp.dao.impl.CuentaDAOImplAhorro;
import com.beeva.maven.bankapp.dao.impl.CuentaDAOImplCheques;
import com.beeva.maven.bankapp.dao.inter.CuentaDAO;
import com.beeva.maven.bankapp.dao.model.Cuenta;

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