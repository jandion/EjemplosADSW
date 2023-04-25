package es.upm.dit.adsw.grafos;

/**
 * Clase que representa una arista de un grafo dirigido.
 * Contiene tres atributos: el nodo origen, el nodo destino y el peso de la arista.
 */
public class Arista implements Comparable<Arista>{

    /**
     * Nodo origen de la arista.
     */
    public Nodo origen;

    /**
     * Nodo destino de la arista.
     */
    public Nodo destino;

    /**
     * Peso de la arista.
     */
    public double peso;

    /**
     * Constructor que recibe el nodo origen, el nodo destino y el peso de la arista.
     * @param origen nodo origen de la arista.
     * @param destino nodo destino de la arista.
     * @param peso peso de la arista.
     */
    public Arista(Nodo origen, Nodo destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Método para comparar dos aristas según su peso.
     * @param o arista con la que se va a comparar.
     * @return -1 si esta arista tiene menor peso que la otra, 0 si tienen el mismo peso, 1 si esta arista tiene mayor peso que la otra.
     */
    @Override
    public int compareTo(Arista o) {
        return Double.compare(peso, o.peso);
    }

}

