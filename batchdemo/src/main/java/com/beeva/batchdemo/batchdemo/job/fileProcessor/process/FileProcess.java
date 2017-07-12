package com.beeva.batchdemo.batchdemo.job.fileProcessor.process;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.beeva.batchdemo.batchdemo.job.fileProcessor.model.Empleado;

@Component
public class FileProcess implements ItemProcessor <Empleado,Empleado> {
	
	public Empleado process(Empleado empleado) throws Exception{
		
		System.out.println(empleado.toString());
		
		return empleado;
	}
	
}