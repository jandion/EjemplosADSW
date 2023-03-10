package es.upm.dit.adsw.diccionarios.arrays.interfaces;


public interface Diccionario {
	/**
	put(...)
	get(...)
	remove(...)
	size()
	clear()
	*/
	
	public void put(CV elemento);
	public CV get(CV elemento);
	public CV remove(CV elemento);
	public int size();
	public void clear();
}
