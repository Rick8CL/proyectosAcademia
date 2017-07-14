package com.beeva.ultimate.elbanco.dao.inter;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase Abstracta para acceder a los metodos que registran y consultan
 * datos en la tabla cuenta de la BD
 * 
 */

import java.util.List;

import com.beeva.ultimate.elbanco.dao.model.Cuenta;

public abstract class CuentaDAO {
	public abstract Cuenta deposito(Cuenta cuenta, double dinero);
	public abstract Cuenta retiro(Cuenta cuenta, double dinero);
	public abstract void save(Cuenta cuenta);
	public abstract Cuenta getCuentaById(int id);
	public abstract Cuenta getCuentaByIdCliente(int id);
	public abstract List<Cuenta> getCuentasByCliente(int id);
}