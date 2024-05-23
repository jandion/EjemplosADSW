package es.dit.adsw.ejercicios.grafos.jun23;

public class Arista {

	public Nodo a, b;
	public int peso;
	public Arista(Nodo a, Nodo b, int peso) {
		this.a = a;
		this.b = b;
		this.peso = peso;
	}
	/**
	 * Retorna el nodo que está en el otro extremo
	 * de la arista con relación al pasado como parámetro
	 *
	 * @param nodo uno de los Nodo de la Arista
	 * @return el otro Nodo de la Arista
	 */
	public Nodo contrario(Nodo nodo) {
		if(a.equals(nodo)) return b;
		return a;
	}
}
