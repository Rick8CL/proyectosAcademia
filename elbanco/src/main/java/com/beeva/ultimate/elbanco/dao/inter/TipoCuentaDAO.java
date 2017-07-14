package com.beeva.ultimate.elbanco.dao.inter;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase Abstracta para acceder a los metodos que registran y consultan
 * datos en la tabla tipocuenta de la BD
 * 
 */

import com.beeva.ultimate.elbanco.dao.model.TipoCuenta;

public abstract class TipoCuentaDAO {
	public abstract void save(TipoCuenta tc);
	public abstract TipoCuenta getTipoCuentaById(int id);
}