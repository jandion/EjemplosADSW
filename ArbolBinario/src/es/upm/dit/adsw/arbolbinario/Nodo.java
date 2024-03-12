package es.upm.dit.adsw.arbolbinario;

public class Nodo implements Comparable<Nodo> {
	private ElementoDiccionario elemento;
	private Nodo hijoDerecho;
	private Nodo hijoIzquierdo;
	
	public Nodo(ElementoDiccionario elemento) {
		this.elemento = elemento;		
	}

	@Override
	public int compareTo(Nodo o) {
		return elemento.compareTo(o.elemento);
	}

	public ElementoDiccionario getElemento() {
		return elemento;
	}

	public void setElemento(ElementoDiccionario elemento) {
		this.elemento = elemento;
	}

	public Nodo getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(Nodo hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}

	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	
	public int getClave() {
		return elemento.getClave();
	}
	
}