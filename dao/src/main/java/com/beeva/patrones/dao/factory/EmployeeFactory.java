package com.beeva.patrones.dao.factory;

import com.beeva.patrones.dao.impl.EmployeeDAOImplArray;
import com.beeva.patrones.dao.impl.EmployeeDAOImplSQL;
import com.beeva.patrones.dao.inter.EmployeeDAO;
import com.beeva.patrones.dao.model.Employee;

public class EmployeeFactory {
	public EmployeeDAO getImp(Employee e){
		if(e.getStore()==1){
			EmployeeDAO employeeDAO = new EmployeeDAOImplArray();
			return employeeDAO;
		}else{
			EmployeeDAO employeeDAO = new EmployeeDAOImplSQL();
			return employeeDAO;
		}
	}
}
