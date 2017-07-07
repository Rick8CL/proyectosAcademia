package com.beeva.patrones.dao.inter;

import com.beeva.patrones.dao.model.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee e);
	public boolean removeEmployee(Employee e);
	public Employee getEmployee(int id);
}
