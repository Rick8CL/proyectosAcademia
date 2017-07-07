package com.beeva.patrones.dao;

import com.beeva.patrones.dao.impl.EmployeeDAOImplArray;
import com.beeva.patrones.dao.inter.EmployeeDAO;
import com.beeva.patrones.dao.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Employee empleado = new Employee();
    	empleado.setNombre("Ricardo");
    	empleado.setApellido("Castillo");
    	empleado.setEdad(22);
    	empleado.setStore(1);
        EmployeeDAO empleadoDAO = new EmployeeDAOImplArray();
        empleadoDAO.addEmployee(empleado);
        
        System.out.println(empleado.getNombre());
    }
}
