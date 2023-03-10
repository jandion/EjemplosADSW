package es.upm.dit.adsw.diccionarios.arrays.ordenado;

import es.upm.dit.adsw.diccionarios.arrays.interfaces.CV;

public class Persona implements CV<String,String>, Comparable<Persona>{

	String dni;
	String nombre;
	@Override
	public String getKey() {
		return dni;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return nombre;
	}
	public Persona(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	@Override
	public int compareTo(Persona o) {
		return dni.compareTo(o.dni);
	}
	
}
