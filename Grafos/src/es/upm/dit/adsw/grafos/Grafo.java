package es.upm.dit.adsw.grafos;

import java.util.List;

/**
 * Clase que representa un grafo dirigido y con pesos.
 * Contiene dos listas: una de nodos y otra de aristas.
 */
public class Grafo {

    /**
     * Lista de nodos del grafo.
     */
    public List<Nodo> nodos;

    /**
     * Lista de aristas del grafo.
     */
    public List<Arista> aristas;

    /**
     * Constructor que recibe una lista de nodos y una lista de aristas.
     * @param nodos lista de nodos del grafo.
     * @param aristas lista de aristas del grafo.
     */
    public Grafo(List<Nodo> nodos, List<Arista> aristas) {
        this.nodos = nodos;
        this.aristas = aristas;
    }

    /**
     * Método para añadir un nodo al grafo.
     * @param nodo nodo que se va a añadir.
     */
    public void addNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    /**
     * Método para añadir una arista al grafo.
     * @param arista arista que se va a añadir.
     */
    public void addArista(Arista arista) {
        aristas.add(arista);
    }

    /**
     * Método para crear una arista entre dos nodos con un peso determinado.
     * @param nodo1 nodo origen de la arista.
     * @param nodo2 nodo destino de la arista.
     * @param peso peso de la arista.
     */
    public void creaArista(Nodo nodo1, Nodo nodo2, double peso) {
        Arista arista = new Arista(nodo1, nodo2, peso);
        aristas.add(arista);
    }

}
