package es.upm.dit.adsw.grafos.dijkstra;

import java.util.List;
import java.util.Map;
import java.util.Set;

import es.upm.dit.adsw.grafos.Arista;
import es.upm.dit.adsw.grafos.Grafo;
import es.upm.dit.adsw.grafos.Nodo;

/**
 * Esta clase implementa el algoritmo de Dijkstra para encontrar el camino más
 * corto entre dos nodos de un grafo. El algoritmo es capaz de encontrar el
 * camino más corto entre un nodo origen y un nodo destino, así como todas las
 * distancias desde el nodo origen a todos los demás nodos del grafo y todos los
 * caminos posibles desde el nodo origen a cada uno de los demás nodos del
 * grafo.
 */
public class Dijkstra {

	/**
	 * Calcula la distancia más corta entre dos nodos de un grafo usando el
	 * algoritmo de Dijkstra.
	 * 
	 * @param g       Grafo en el que se buscará el camino más corto.
	 * @param origen  Nodo origen.
	 * @param destino Nodo destino.
	 * @return La distancia más corta entre los nodos origen y destino.
	 */
	public static double getDistancia(Grafo g, Nodo origen, Nodo destino) {

		// Se inicializan los conjuntos de visitados, distancias y nodos anteriores
		Set<Nodo> visitados = new java.util.HashSet<Nodo>();
		Map<Nodo, Double> distancia = new java.util.HashMap<Nodo, Double>();
		Map<Nodo, Nodo> anterior = new java.util.HashMap<Nodo, Nodo>();

		// La distancia al nodo origen es 0
		distancia.put(origen, 0.0);

		// Se continúa hasta que se llegue al nodo destino
		while (!visitados.contains(destino)) {
			Nodo nodo = getNodoMasCercano(visitados, distancia);
			visitados.add(nodo);
			for (Arista arista : nodo.aristas) {
				Nodo nodoDestino = arista.destino;
				if (!visitados.contains(nodoDestino)) {
					double distanciaNueva = distancia.get(nodo) + arista.peso;
					if (!distancia.containsKey(nodoDestino) || distanciaNueva < distancia.get(nodoDestino)) {
						distancia.put(nodoDestino, distanciaNueva);
						anterior.put(nodoDestino, nodo);
					}
				}
			}
		}

		return distancia.get(destino);
	}

	/**
	 * 
	 * Obtiene el nodo más cercano a los ya visitados con la distancia más corta.
	 * 
	 * @param visitados Conjunto de nodos ya visitados.
	 * @param distancia Mapa con la distancia a cada uno de los nodos.
	 * @return El nodo más cercano a los ya visitados con la distancia más corta.
	 */
	private static Nodo getNodoMasCercano(Set<Nodo> visitados, Map<Nodo, Double> distancia) {
		Nodo nodoMasCercano = null;
		double distanciaMasCercana = Double.MAX_VALUE;
		for (Nodo nodo : distancia.keySet()) {
			if (!visitados.contains(nodo) && distancia.get(nodo) < distanciaMasCercana) {
				nodoMasCercano = nodo;
				distanciaMasCercana = distancia.get(nodo);
			}
		}
		return nodoMasCercano;
	}

	/**
	 * 
	 * Calcula todas las distancias desde el nodo origen a todos los demás nodos del
	 * grafo utilizando el algoritmo de Dijkstra.
	 * 
	 * @param g      el grafo en el que se calcularán las distancias.
	 * 
	 * @param origen el nodo de origen desde el que se calcularán las distancias.
	 * 
	 * @return un mapa que contiene la distancia desde el nodo origen a todos los
	 *         demás nodos del grafo.
	 */
	public static Map<Nodo, Double> getTodasLasDistancias(Grafo g, Nodo origen) {

		// Conjunto de nodos visitados
		Set<Nodo> visitados = new java.util.HashSet<Nodo>();

		// Mapa que contiene la distancia desde el nodo origen a cada nodo del grafo
		Map<Nodo, Double> distancia = new java.util.HashMap<Nodo, Double>();

		// Mapa que contiene el nodo anterior en el camino más corto desde el origen a
		// cada nodo del grafo
		Map<Nodo, Nodo> anterior = new java.util.HashMap<Nodo, Nodo>();

		// Inicializa la distancia desde el origen a sí mismo en 0
		distancia.put(origen, 0.0);

		// Mientras haya nodos sin visitar
		while (visitados.size() != g.nodos.size()) {

			// Obtiene el nodo más cercano al origen que aún no ha sido visitado
			Nodo nodo = getNodoMasCercano(visitados, distancia);

			// Marca el nodo como visitado
			visitados.add(nodo);

			// Para cada arista que sale del nodo
			for (Arista arista : nodo.aristas) {
				Nodo nodoDestino = arista.destino;
				if (!visitados.contains(nodoDestino)) {

					// Calcula la distancia desde el origen hasta el nodo de destino a través del
					// nodo actual
					double distanciaNueva = distancia.get(nodo) + arista.peso;

					// Si la distancia calculada es menor a la distancia actual almacenada en el
					// mapa, actualiza la distancia y el nodo anterior
					if (!distancia.containsKey(nodoDestino) || distanciaNueva < distancia.get(nodoDestino)) {
						distancia.put(nodoDestino, distanciaNueva);
						anterior.put(nodoDestino, nodo);
					}
				}
			}
		}

		// Devuelve el mapa con las distancias desde el origen a cada nodo
		return distancia;
	}

	/**
	 * Este método devuelve una lista de nodos que representa el camino más corto
	 * entre un nodo origen y un nodo destino en un grafo dado.
	 * 
	 * @param g       El grafo en el que se buscará el camino.
	 * @param origen  El nodo de origen.
	 * @param destino El nodo de destino.
	 * @return Una lista de nodos que representa el camino más corto entre origen y
	 *         destino.
	 */
	public static List<Nodo> getCamino(Grafo g, Nodo origen, Nodo destino) {

		// Conjunto de nodos visitados
		Set<Nodo> visitados = new java.util.HashSet<Nodo>();
		// Mapa que almacena las distancias desde el nodo origen hasta cada nodo en el
		// grafo
		Map<Nodo, Double> distancia = new java.util.HashMap<Nodo, Double>();
		// Mapa que almacena los nodos anteriores a cada nodo en el camino más corto
		// desde el origen
		Map<Nodo, Nodo> anterior = new java.util.HashMap<Nodo, Nodo>();

		// La distancia desde el origen hasta el origen es 0
		distancia.put(origen, 0.0);

		// Mientras no se haya visitado el nodo destino
		while (!visitados.contains(destino)) {
			// Se obtiene el nodo más cercano que no ha sido visitado aún
			Nodo nodo = getNodoMasCercano(visitados, distancia);
			// Se marca el nodo como visitado
			visitados.add(nodo);
			// Se actualiza la distancia de los nodos adyacentes que no han sido visitados
			for (Arista arista : nodo.aristas) {
				Nodo nodoDestino = arista.destino;
				if (!visitados.contains(nodoDestino)) {
					double distanciaNueva = distancia.get(nodo) + arista.peso;
					if (!distancia.containsKey(nodoDestino) || distanciaNueva < distancia.get(nodoDestino)) {
						distancia.put(nodoDestino, distanciaNueva);
						anterior.put(nodoDestino, nodo);
					}
				}
			}
		}

		// Se construye el camino a partir del mapa de nodos anteriores
		List<Nodo> camino = new java.util.ArrayList<Nodo>();
		Nodo nodo = destino;
		while (nodo != origen) {
			camino.add(0, nodo);
			nodo = anterior.get(nodo);
		}
		camino.add(0, origen);
		return camino;

	}

	/**
	 * Obtiene todos los caminos desde un nodo origen a todos los demás nodos en el
	 * grafo. Utiliza el algoritmo de Dijkstra para calcular las distancias mínimas.
	 * 
	 * @param g      Grafo en el que se buscan los caminos.
	 * @param origen Nodo de origen desde el que se buscan los caminos.
	 * @return Mapa que contiene como clave cada nodo en el grafo y como valor una
	 *         lista de nodos que forman un camino desde el nodo origen hasta el
	 *         nodo clave.
	 */
	public static Map<Nodo, List<Nodo>> getTodosLosCaminos(Grafo g, Nodo origen) {

		// Conjunto de nodos visitados
		Set<Nodo> visitados = new java.util.HashSet<Nodo>();
		// Mapa que almacena la distancia mínima desde el origen hasta cada nodo
		Map<Nodo, Double> distancia = new java.util.HashMap<Nodo, Double>();
		// Mapa que almacena el nodo anterior en el camino más corto desde el origen
		// hasta cada nodo
		Map<Nodo, Nodo> anterior = new java.util.HashMap<Nodo, Nodo>();

		// Se inicializa la distancia desde el origen a sí mismo como cero
		distancia.put(origen, 0.0);

		// Se buscan los caminos desde el origen hasta todos los demás nodos
		while (visitados.size() != g.nodos.size()) {
			Nodo nodo = getNodoMasCercano(visitados, distancia);
			visitados.add(nodo);
			for (Arista arista : nodo.aristas) {
				Nodo nodoDestino = arista.destino;
				if (!visitados.contains(nodoDestino)) {
					double distanciaNueva = distancia.get(nodo) + arista.peso;
					if (!distancia.containsKey(nodoDestino) || distanciaNueva < distancia.get(nodoDestino)) {
						distancia.put(nodoDestino, distanciaNueva);
						anterior.put(nodoDestino, nodo);
					}
				}
			}
		}

		// Se generan las listas de nodos que forman los caminos desde el origen hasta
		// cada nodo
		Map<Nodo, List<Nodo>> todosLosCaminos = new java.util.HashMap<Nodo, List<Nodo>>();
		for (Nodo destino : g.nodos) {
			List<Nodo> camino = new java.util.ArrayList<Nodo>();
			Nodo nodo = destino;
			while (nodo != origen) {
				camino.add(0, nodo);
				nodo = anterior.get(nodo);
			}
			camino.add(0, origen);
			todosLosCaminos.put(destino, camino);
		}

		// Se retorna el mapa con los caminos desde el origen hasta cada nodo
		return todosLosCaminos;
	}

}
