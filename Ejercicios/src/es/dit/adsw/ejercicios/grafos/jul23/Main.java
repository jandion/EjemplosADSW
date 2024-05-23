package es.dit.adsw.ejercicios.grafos.jul23;

import java.io.File;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

public class Main {

	public static void main(String[] args) throws Exception{
		EdgeWeightedDigraph grafo = new EdgeWeightedDigraph(new In(new File("data/jul23")));
		
	}
	
	public static double mediaTodosLosPesos(EdgeWeightedDigraph grafo) {
		double media = 0;
		for(DirectedEdge de : grafo.edges() ) {
			media += de.weight();
		}
		
		return media / grafo.E();
	}
	
}
