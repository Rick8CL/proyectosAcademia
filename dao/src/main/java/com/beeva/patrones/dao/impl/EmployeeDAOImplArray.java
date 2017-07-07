package com.beeva.patrones.dao.impl;

import com.beeva.patrones.dao.model.Employee;
import com.beeva.patrones.dao.store.EmpleadosArray;
import com.beeva.patrones.dao.inter.EmployeeDAO;

public class EmployeeDAOImplArray implements EmployeeDAO {

	public boolean addEmployee(Employee e) {
		EmpleadosArray empleados = new EmpleadosArray();
		empleados.empleados.add(e);
		return false;
	}

	public boolean removeEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
;