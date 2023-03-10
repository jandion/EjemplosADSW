package es.upm.dit.adsw.diccionarios.arrays.ordenado;

import java.awt.Point;

import es.upm.dit.adsw.diccionarios.arrays.interfaces.CV;
import es.upm.dit.adsw.diccionarios.arrays.interfaces.Diccionario;

public class DiccionarioPersonas implements Diccionario {

	Persona[] elementos;
	int contador;
	public DiccionarioPersonas() {
		elementos = new Persona[1000];
		contador = 0;
	}
	@Override
	public void put(CV elemento) {
		if(contador == elementos.length) return;
		Persona p = (Persona) elemento;
		for (int i = 0; i < elementos.length; i++) {
			if (elementos[i] == null) {
				elementos[i] = p;
				contador++;
				return;
			}
			if ( elementos[i].getKey().compareTo(p.getKey()) > 0 ) {
				//System.arraycopy(elementos, i, elementos, i+1, elementos.length-(i+1));
				for(int j = elementos.length-1; j>i; j--) {
					elementos[j] = elementos[j-1];
				}
				elementos[i] = p;
				contador ++;
				return;


			}
		}
	}

	@Override
	public CV get(CV elemento) {
		String key = ((Persona) elemento).getKey();
		
		int pos = busca(key, 0, contador);
		
		return elementos[pos];
	}

	private int busca(String key, int inicio, int fin) {
		int medio = (inicio + fin) / 2;
		String pm = elementos[medio].getKey();

		if(medio == fin || medio == inicio)
			return -1;
		if( pm.compareTo(key)<0 ) {
			return busca(key, medio, fin);
		}
		if( pm.compareTo(key) == 0) {
			return medio;
		}
		if( pm.compareTo(key)>0) {
			return busca(key,inicio,medio);
		}
		return 0;
	}
	@Override
	public CV remove(CV elemento) {
		String key = ((Persona) elemento).getKey();
		for (int i = 0; i < elementos.length; i++) {
			if ( elementos[i] == null ) {
				return null;
			}
			if ( elementos[i].getKey().equals(key) ) {
				Persona found = elementos[i];
				System.arraycopy(elementos, i+1, elementos, i, elementos.length-i);
				elementos[elementos.length-1] = null;
				return found;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return contador;
	}

	@Override
	public void clear() {
		elementos = new Persona[1000];
	}

}
