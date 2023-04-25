package es.upm.dit.adsw.grafos;

import java.util.List;
/**
 * Clase que representa un nodo de un grafo.
 * Contiene dos atributos: el nombre del nodo y una lista de aristas que salen del nodo.
 */
public class Nodo {

    /**
     * Nombre del nodo.
     */
    public String nombre;

    /**
     * Lista de aristas que salen del nodo.
     */
    public List<Arista> aristas;

    /**
     * Constructor que recibe el nombre del nodo.
     * @param nombre nombre del nodo.
     */
    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el nombre del nodo.
     * @return nombre del nodo.
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Método para agregar una arista a la lista de aristas del nodo.
     * @param arista arista que se va a agregar.
     */
    public void addArista(Arista arista) {
        aristas.add(arista);
    }

    /**
     * Método para crear una nueva arista desde este nodo hacia otro nodo.
     * @param nodo nodo destino de la arista.
     * @param peso peso de la arista.
     */
    public void creaArista(Nodo nodo, double peso) {
        Arista arista = new Arista(this, nodo, peso);
        aristas.add(arista);
    }
}
