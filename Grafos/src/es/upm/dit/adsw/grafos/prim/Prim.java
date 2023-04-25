package es.upm.dit.adsw.grafos.prim;

import java.util.PriorityQueue;
import java.util.Set;

import es.upm.dit.adsw.grafos.Arista;
import es.upm.dit.adsw.grafos.Grafo;
import es.upm.dit.adsw.grafos.Nodo;

/**
 * Clase que implementa el algoritmo de Prim para obtener el árbol de expansión mínimo de un grafo.
 */
public class Prim {

	/**
	 * Método que recibe un grafo y devuelve el conjunto de aristas que forman el árbol de expansión mínimo.
	 * @param g grafo del que se desea obtener el árbol de expansión mínimo.
	 * @return conjunto de aristas que forman el árbol de expansión mínimo.
	 */
	public static Set<Arista> getMST(Grafo g) {
        Set<Arista> mst = new java.util.HashSet<Arista>();
        Set<Nodo> visitados = new java.util.HashSet<Nodo>();
        PriorityQueue<Arista> aristasPosibles = new PriorityQueue<Arista>();

        // Se comienza visitando el primer nodo del grafo.
        visitados.add(g.nodos.get(0));
        aristasPosibles.addAll(g.nodos.get(0).aristas);

        // Mientras no se hayan visitado todos los nodos.
        while(visitados.size() < g.nodos.size()) {
            if( aristasPosibles.isEmpty() ) {
                System.err.println("Grafo no conexo");
                return null;
            }
            // Se escoge la arista de menor peso que conecta un nodo visitado con uno no visitado.
            Arista arista = aristasPosibles.poll();
            if(!visitados.contains(arista.destino)) {
                // Se agrega la arista al conjunto de aristas del árbol de expansión mínimo.
                mst.add(arista);
                // Se marca el nodo destino como visitado y se agregan sus aristas a la cola de aristas posibles.
                visitados.add(arista.destino);
                aristasPosibles.addAll(arista.destino.aristas);
            }
        }
		return mst;
	}
}
