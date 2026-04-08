package g25.tema3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Grafo {

	private List<Nodo> nodos;
	public List<Arista> aristas;
	
	public Grafo() {
		nodos = new ArrayList<>();
		aristas = new ArrayList<>();
	}

	public void cargarGrafoMatriz(String ruta) {
		// TODO en casa
		try {
		BufferedReader br = new BufferedReader(new FileReader(new File(ruta)));
		
		} catch( Exception e) {
			
		}
	}
	
	public void cargarGrafoListaNodos(String ruta) {
		// TODO en casa
	}
	
	public void cargarGrafoListaAristas(String ruta) {
		// TODO en casa
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
	
	public boolean contieneNodo(Nodo a) {
		//return nodos.contains(a);
		for(Nodo n : nodos) {
			if (n.equals(a))
				return true;
		}
		return false;
	}
	
	public boolean sonAdyacentes(Nodo a, Nodo b) {
		if(!contieneNodo(a) || !contieneNodo(b)) 
			return false;
		return a.esVecinoDe(b); 
	}
	
	public boolean hayUnCaminoEntre(Nodo a, Nodo b) {
		return false; // TODO
	}
	
	public List<Nodo> getCaminoEntre(Nodo a, Nodo b){
		return null; // TODO
	}
	
	public double getDistanciaEntre(Nodo a, Nodo b){
		return 0; // TODO
	}
	
	public boolean hayCiclos() {
		return false; // TODO
	}
	
	public void anadirNodo(Nodo n) {
		nodos.add(n);
	}

	public List<Arista> getArbolRecubridor() {
		return null; // TODO
	}
	
	public List<Arista> getArbolRecubridorMinimo() {
		return null; // TODO
	}
	
	
}
