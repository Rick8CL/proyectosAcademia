package com.beeva.ultimate.elbanco;

/**
 * Ricardo Castillo Lara
 * Aplicación para la primer evaluación del Curso de APX
 * Entrega 14/07/2017
 * 
 * Recibe los datos del cliente consultado en la base de datos, los envía a la
 * clase Procesador para hacer la comparación del HashCode y si es satisfactoria
 * regresa el objeto procesado para ser enviado al .txt generado por el
 * SpringBatch
 * 
 */

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.beeva.ultimate.elbanco.dao.model.Cliente;
import com.beeva.ultimate.elbanco.dao.model.Procesador;

@Component
public  class FileProcess implements ItemProcessor <Cliente,Procesador>{

	public Procesador process(Cliente cli) throws Exception {
		Procesador pro = new Procesador();
		pro.setNombre(cli.getNombre());
		pro.setApellido(cli.getApellido());
		return pro;
	}

}
