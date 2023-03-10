package es.upm.dit.adsw.diccionarios.arrays.desordenado;

import java.awt.Point;

import es.upm.dit.adsw.diccionarios.arrays.interfaces.CV;
import es.upm.dit.adsw.diccionarios.arrays.interfaces.Diccionario;

public class DiccionarioPixeles implements Diccionario{

	public Pixel[] elementos;
	
	public DiccionarioPixeles() {
		elementos = new Pixel[1000];
	}
	
	@Override
	public void put(CV elemento) {
		for (int i = 0; i < elementos.length; i++) {
			if ( elementos[i] == null ) {
				elementos[i] = (Pixel) elemento;
				break;
			}
		}
	}

	@Override
	public CV get(CV elemento) {
		Point key = ((Pixel) elemento).getKey();
		for (int i = 0; i < elementos.length; i++) {
			if ( elementos[i] == null ) {
				return null;
			}
			if ( elementos[i].getKey().equals(key) ) {
				return elementos[i];
			}
		}
		return null;
	}

	@Override
	public CV remove(CV elemento) {
		Point key = ((Pixel) elemento).getKey();
		for (int i = 0; i < elementos.length; i++) {
			if ( elementos[i] == null ) {
				return null;
			}
			if ( elementos[i].getKey().equals(key) ) {
				Pixel found = elementos[i];
				System.arraycopy(elementos, i+1, elementos, i, elementos.length-i);
				elementos[elementos.length-1] = null;
				return found;
			}
		}
		return null;
	}

	@Override
	public int size() {
		for (int i = 0; i < elementos.length; i++) {
			if ( elementos[i] == null ) {
				return i;
			}
		}
		return elementos.length;
	}

	@Override
	public void clear() {
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = null;
		}
	}

}
