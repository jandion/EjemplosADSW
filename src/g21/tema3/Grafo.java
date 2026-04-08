package g21.tema3;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Arista> aristas;
	private List<Nodo> nodos;
	
	public Grafo() {
		aristas = new ArrayList<>();
		nodos = new ArrayList<>();
	}
	
	public List<Arista> getAristas(){
		return aristas;
	}
	
	public List<Nodo> getNodos(){
		return nodos;
	}
	
	public boolean esDirigido() {
		return false; // TODO
	}
	
	public boolean contieneNodo( Nodo n ) {
		//return nodos.contains(n);
		for(Nodo nEnGrafo : nodos) {
			if(nEnGrafo.equals(n)) {
				return true;
			}
		}
		return false; 
	}
	
	public boolean sonAdyacentes( Nodo a, Nodo b) {
		if (!contieneNodo(a) || !contieneNodo(b)) {
			return false;
		}
		// sacamos las aristas de a
		for(Arista ar : a.vecinos) {
			if (ar.getOtro(a).equals(b))
				return true;
		}
		return false; 
	}
	
	public boolean hayCamino( Nodo a, Nodo b ) {
		return false; // TODO
	}
	
	public List<Nodo> getCamino(Nodo a, Nodo b) {
		return null; // TODO
	}

	public List<Arista> getArbolRecubridor() {
		return null; // TODO
	}
	
	public List<Arista> getArbolRecubridorMinimo() {
		return null; // TODO
	}
}
