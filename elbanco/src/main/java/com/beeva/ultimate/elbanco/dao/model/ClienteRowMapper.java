package com.beeva.ultimate.elbanco.dao.model;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Clase que realiza un Mapeo de los resultados obtenidos de la consulta
 * a la BD, y sirve de paso para cada elemento que llegará al .txt creado
 * por el Spring Batch
 * 
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ClienteRowMapper implements RowMapper<Cliente> {

	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {

		Cliente cliente = new Cliente();

		
		cliente.setNombre(rs.getString("nombre"));
		cliente.setApellido(rs.getString("apellido"));
		

		return cliente;
	}

}