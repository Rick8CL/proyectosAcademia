package com.beeva.spring.saluda;

public class Saludador {
	private String tiempo;
	private Persona persona;
	
	public void Saluda(){
		System.out.println("Hola "+persona.getNombre());
	}
	
	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
