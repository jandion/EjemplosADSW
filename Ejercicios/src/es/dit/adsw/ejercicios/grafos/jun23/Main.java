package es.dit.adsw.ejercicios.grafos.jun23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File("data/jun23")));
		Grafo g = new Grafo();
		String line;
		HashMap<String, Nodo> nodos = new HashMap<String, Nodo>();
		while ((line = reader.readLine())!=null) {
			String[] lineSplit = line.split("\t");
			String a = lineSplit[0];
			String b = lineSplit[1];
			Integer peso = Integer.valueOf(lineSplit[2]);
			if(!nodos.containsKey(a)) {
				nodos.put(a, new Nodo(a));
				g.nodos.add(nodos.get(a));
			}
			if(!nodos.containsKey(b)) {
				nodos.put(b, new Nodo(b));
				g.nodos.add(nodos.get(b));
			}
			nodos.get(a).addVecino(nodos.get(b), peso);
			nodos.get(b).addVecino(nodos.get(a), peso);
			
		}
		
		System.out.println("Infectados desde A: "+ g.simulaContagios(nodos.get("A")));
	}
}
