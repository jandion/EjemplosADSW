package g25.tema1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Baraja {

	public static void main(String[] args) {

		Carta unoDiamantes = new Carta(1, Palo.DIAMANTES);
		Carta unoCorazones = new Carta(1, Palo.CORAZONES);
		Carta dosPicas = new Carta(2, Palo.PICAS);

		List<Carta> manoCartas = new ArrayList<>();
		manoCartas.add(unoCorazones);
		manoCartas.add(unoDiamantes);
		manoCartas.add(dosPicas);

		for (int i = 0; i < 5; i++) {
			int valor = (int)(Math.random()*12+1);
			Palo palo;
			double rand = Math.random();
			if (rand < 0.25) {
				palo = Palo.DIAMANTES;
			} else if (rand < 0.5) {
				palo = Palo.CORAZONES;
			} else if (rand < 0.75) {
				palo = Palo.TREBOLES;
			} else {
				palo = Palo.PICAS;
			}
			manoCartas.add(new Carta(valor, palo));
		}

		System.out.println(manoCartas);

		boolean estaOrdenado = estaOrdenada(manoCartas);


		//Collections.sort(manoCartas);

		if (estaOrdenado) {
			System.out.println("Todo bien!");
		} else {
			System.out.println("Alguno mal");
			//sortBurbuja(manoCartas);
			sortSeleccion(manoCartas);
			System.out.println(manoCartas);
			System.out.println(estaOrdenada(manoCartas));
		}


	}

	public static boolean estaOrdenada(List<Carta> miLista) {
		boolean estaOrdenado = true;
		// cora, dia, treb y pic
		// Comprobar si está ordenado
		for (int i = 0; i < miLista.size()-1; i++) {

			if(!miLista.get(i).esMenorQue(miLista.get(i+1))) {
				System.out.println("No está ordenado!");
				estaOrdenado = false;
			} 
		}
		return estaOrdenado;
	}

	public static void swap(int pos1, int pos2, List<Carta> miLista) {
		Carta aux = miLista.get(pos1);
		miLista.set(pos1, miLista.get(pos2));
		miLista.set(pos2, aux);
	}

	public static void sortBurbuja(List<Carta> miLista) {
		boolean hayCambios = true;
		while(hayCambios) {
			hayCambios = false;
			for(int i = 0; i< miLista.size()-1; i++) {
				Carta actual = miLista.get(i);
				Carta siguiente = miLista.get(i+1);

				int res = actual.compareTo(siguiente);
				if (res > 0) {
					swap(i, i+1, miLista);
					hayCambios = true;
				} 
			}
		}
	}
	
	public static void sortSeleccion(List<Carta> miLista) {
		for (int i = 0; i < miLista.size(); i++) {
			Carta minima = miLista.get(i);
			int posMinima = i;
			for(int j = i; j< miLista.size(); j++) {
				if(minima.compareTo(miLista.get(j))>0) {
					minima = miLista.get(j);
					posMinima = j;
				}
			}
			swap(i, posMinima, miLista);	
		}
	}
	public static void sortInsertion(List<Carta> miLista) {
		for (int i = 1; i < miLista.size(); i++) {
			insert(miLista, i, miLista.get(i));
		}
	}

	private static void insert(List<Carta> miLista, int i, Carta carta) {
		int j = i;
		while(j>0 &&carta.compareTo(miLista.get(j-1))<0) {
			j--;
		}
		
	}
}
