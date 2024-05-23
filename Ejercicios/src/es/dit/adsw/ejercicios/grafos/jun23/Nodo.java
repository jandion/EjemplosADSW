package es.dit.adsw.ejercicios.grafos.jun23;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	public String id;
	public boolean infectado;
	public List<Arista> vecinos;
	public Nodo(String id) {
		this.id = id;
		this.infectado = false;
		this.vecinos = new ArrayList<>();
	}
	/**
	 * Añade un vecino que se conectará con una arista
	 * del peso especificado
	 *
	 * @param vecino el Nodo que se añadirá como vecino
	 * @param peso el peso de la arista que conectará
	 * los nodos y que marca la distancia
	 * entre ambos
	 */
	public void addVecino(Nodo vecino, int peso) {
		Arista a = new Arista(vecino, this, peso);
		vecinos.add(a);
		vecino.vecinos.add(a);
	}
}
