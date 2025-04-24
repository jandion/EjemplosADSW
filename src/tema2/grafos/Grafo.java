package tema2.grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
    List<Nodo> nodos;
    List<Arista> aristas;

    public List<Arista> getArbolRecubridorMinimo(){
        Nodo inicial = nodos.get(0);
        List<Arista> arbolRecubridorMinimo = new ArrayList<Arista>();
        List<Arista> aristasPosibles = new ArrayList<>();
        List<Nodo> nodosDelArbol = new ArrayList<>();
        nodosDelArbol.add(inicial);
        aristasPosibles.addAll(inicial.aristas);
        while(!aristasPosibles.isEmpty()|| arbolRecubridorMinimo.size()!=nodos.size()-1){
            Arista min = aristasPosibles.get(0);
            for(Arista a : aristasPosibles){
                if (a.peso<min.peso){
                    min = a;
                }
            }
            aristasPosibles.remove(min);
            // ver si la arista conecta un nodo que ya hayamos visto
            if(nodosDelArbol.contains(min.origen)&& nodosDelArbol.contains(min.destino)){
                continue;
            }
            arbolRecubridorMinimo.add(min);
            if(nodosDelArbol.contains(min.origen)) {
                nodosDelArbol.add(min.destino);
                aristasPosibles.addAll(min.destino.aristas);
                aristasPosibles.remove(min);
            } else {
                nodosDelArbol.add(min.origen);
                aristasPosibles.addAll(min.origen.aristas);
                aristasPosibles.remove(min);
            }
        }

        return arbolRecubridorMinimo;
    }

    public Set<Arista> getArbolRecubridorMinimoOptimizado() throws Exception{
        Set<Arista> arbol = new HashSet<>();
        Set<Nodo> nodosVisitados = new HashSet<>();
        List<Arista> aristasPosibles = new ArrayList<>();
        aristasPosibles.addAll(nodos.get(0).aristas);
        nodosVisitados.add(nodos.get(0));
        while(!aristasPosibles.isEmpty() && nodosVisitados.size()!=nodos.size()){
            Arista min =  aristasPosibles.get(0);
            for(Arista a : aristasPosibles){
                if(a.peso<min.peso){
                    min = a;
                }
            }

            if(!nodosVisitados.contains(min.origen) && !nodosVisitados.contains(min.destino)){
                if (nodosVisitados.contains(min.origen)){
                    nodosVisitados.add(min.destino);
                    arbol.addAll(min.destino.aristas);
                } else {
                    nodosVisitados.add(min.origen);
                    arbol.addAll(min.origen.aristas);
                }
            }
            aristasPosibles.remove(min);
        }
        if(nodosVisitados.size()!=nodos.size()){
            throw new Exception("No se pudo crear un arbol recubridor. El grafo no es conexo.")
        }
        return arbol;
    }
}
