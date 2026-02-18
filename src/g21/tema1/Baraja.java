package g21.tema1;

import java.util.ArrayList;
import java.util.List;

public class Baraja {

	public static void main(String[] args) {

		List<Carta> baraja = new ArrayList<>();

		Carta unoDia = new Carta(1, Palo.DIAMANTES);
		Carta unoCor = new Carta(1, Palo.CORAZONES);
		Carta dosPic = new Carta(2, Palo.PICAS);

		baraja.add(unoDia);
		baraja.add(unoCor);
		baraja.add(dosPic);

		for(int i = 0; i<5; i++) {
			int numero = (int)(Math.random()*12+1);
			double r = Math.random();
			Palo p;
			if (r < .25) {
				p = Palo.DIAMANTES;
			} else if (r < 0.5) {
				p = Palo.CORAZONES;
			} else if (r < 0.75) {
				p = Palo.PICAS;
			} else  {
				p = Palo.TREBOLES;
			}
			baraja.add(new Carta(numero, p));
		}

		System.out.println(baraja);

		boolean noOrdenado = false;
		// Aqui vemos si esta ordenada
		for (int i = 0; i < baraja.size()-1; i++) {
			Carta actual = baraja.get(i);
			Carta siguiente = baraja.get(i+1);
			if (actual.esMenorOIgual(siguiente) ) {
			} else {
				System.out.println("No esta ordenado!");
				noOrdenado = true;
			}
		}

		if (noOrdenado) {
			// ordenar
			burbuja(baraja);
			System.out.println("Ordenado!");
		}
	}

	private static void swap(int pos1, int pos2, List<Carta> myList) {
		Carta aux = myList.get(pos1);
		myList.set(pos1, myList.get(pos2));
		myList.set(pos2, aux);
	}

	private static void burbuja(List<Carta> myList) {
		boolean hayCambio = true;

		while (hayCambio) {
			hayCambio = false;
			// hacemos una pasa buscando burburjas desordenadas
			for (int i = 0; i < myList.size()-1; i++) {
				Carta actual = myList.get(i);
				Carta siguiente = myList.get(i+1);
				if (!actual.esMenorOIgual(siguiente)) {
					swap( i, i+1, myList );
					hayCambio = true;
				}
			}
		}
	}
	public static void seleccion(List<Carta> myList) {
		for (int i = 0; i < myList.size(); i++) {
			int min = i;
			//buscamos el min entre i y el final
			for(int j = i; j < myList.size(); j++) {

				// si encuentro un elemento menor en j,
				// actualizo min = j
				if(myList.get(j).esMenorOIgual(myList.get(min))) {
					min = j;
				}
			}
			swap(i, min, myList);
		}
	}

	public static void insercion(List<Carta> myList) {
		for (int i = 1; i < myList.size(); i++) {		// repite lo de dentro n-1 veces
			insert(myList,i,myList.get(i));				// g(n)
		}
	}

	public static void insert(List<Carta> myList, int z, Carta v) {
		int j = z;														// 1
		while ( j>0 && v.compareTo(myList.get(j-1)) < 0) {				// n veces
			j--;														// 1
		}
		// desplazar todo lo que esté entre j y z, uno hacia la dcha
		for( int k = z; k > j; k--) {									// n veces
			myList.set(k, myList.get(k-1));								// 1 + 1
		}

		myList.set(j, v);												// 1
	}


	public static List<Carta> mergeSort(List<Carta> myList) {
		if(myList.size() == 1) {
			return myList;
		}
		// dividir
		List<Carta> izquierda = new ArrayList<Carta>();
		List<Carta> derecha = new ArrayList<Carta>();
		for (int i = 0; i < myList.size(); i++) {
			if (i < myList.size()/2) {
				izquierda.add(myList.get(i));
			} else {
				derecha.add(myList.get(i));
			}
		}
		izquierda = mergeSort(izquierda);
		derecha = mergeSort(derecha);

		// mezclar
		List<Carta> resultado = new ArrayList<Carta>();

		while(izquierda.size()>0 && derecha.size()>0) {
			if (izquierda.get(0).compareTo(derecha.get(0))<0) {
				Carta c = izquierda.remove(0);
				resultado.add(c);
			} else {
				resultado.add(derecha.remove(0));
			}
		}
		resultado.addAll(izquierda);
		resultado.addAll(derecha);
		
		return resultado;
	}












}
