package es.dit.adsw.ejercicios.grafos.jun23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	public List<Nodo> nodos;
	public Grafo() {
		nodos = new ArrayList<>();
	}
	
	public int simulaContagios(Nodo origen) {
		int contador = 1;
		origen.infectado = true;
		System.out.println("Infectando "+ origen.id);
		for (Arista a: origen.vecinos) {
			if( a.peso <= 4 && !a.contrario(origen).infectado ) {
				contador += simulaContagios(a.contrario(origen));
			}
		}		
		return contador;
	}
	
	public Set<Nodo> inmunes(){
		Set<Nodo> inmunes = new HashSet<Nodo>();
		
		for(Nodo n: nodos) {
			boolean esInmune = true;
			for (Arista a: n.vecinos) {
				if(a.peso <= 4) {
					esInmune = false;
					break;
				}
			}
			if(esInmune) {
				inmunes.add(n);
			}
		}
		
		return inmunes;
	}
}
