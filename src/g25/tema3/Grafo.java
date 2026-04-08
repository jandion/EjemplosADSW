package g25.tema3;

import java.util.ArrayList;
import java.util.List;


public class Grafo {

	private List<Nodo> nodos;
	public List<Arista> aristas;
	
	public Grafo() {
		nodos = new ArrayList<>();
		aristas = new ArrayList<>();
	}
	
	public List<Nodo> getNodos() {
		return nodos;
	}
	
	public double getDistancia(Nodo a, Nodo b) {
		return 0; // TODO
	}
	
	public int getNumNodos() {
		return nodos.size();
	}
	
	public boolean sonAdyacentes(Nodo a, Nodo b) {
		return false; // TODO
	}
	
	public boolean hayUnCaminoEntre(Nodo a, Nodo b) {
		return false; // TODO
	}
	
	public boolean hayCiclos() {
		return false; // TODO
	}
	
	public void anadirNodo(Nodo n) {
		// TODO
	}
}
