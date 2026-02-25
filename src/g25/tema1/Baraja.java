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

		for (int i = 0; i < 10; i++) {
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
			//sortSeleccion(manoCartas);
			//sortInsercion(manoCartas);
			//manoCartas = mergeSort(manoCartas);
			quickSort2(manoCartas);
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
		boolean hayCambios = true;							// O(1)
		while(hayCambios) {									// n*{ 1 + n*(5+f)}
			hayCambios = false;								// O(1)
			for(int i = 0; i< miLista.size()-1; i++) {		// n*{5 + f}
				Carta actual = miLista.get(i);				// O(1)
				Carta siguiente = miLista.get(i+1);			// O(1)

				int res = actual.compareTo(siguiente);		// O(f)
				if (res > 0) {								// O(3)+O(1)
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
	public static void sortInsercion(List<Carta> miLista) {
		for (int i = 1; i < miLista.size(); i++) {
			insert(miLista, i, miLista.get(i));
		}
	}

	private static void insert(List<Carta> miLista, int i, Carta carta) {
		int j = i;
		while(j > 0 && carta.compareTo(miLista.get(j-1))<0) {
			j--;
		}
		for (int k = i; k > j; k--) {
			miLista.set(k, miLista.get(k-1));
		}
		miLista.set(j, carta);

	}

	public static List<Carta> mergeSort(List<Carta> miLista){

		System.out.println("Inicio:" + miLista);
		if (miLista.size() == 1) {
			return miLista;
		}

		// Dividir
		List<Carta> izq = new ArrayList<Carta>();
		List<Carta> dch = new ArrayList<Carta>();
		for ( int i = 0; i < miLista.size() / 2 ; i++ ) {
			izq.add(miLista.get(i));
		}
		for ( int i = miLista.size() / 2; i < miLista.size() ; i++ ) {
			dch.add(miLista.get(i));
		}
		System.out.println("Antes: izq = "+izq+" dch= "+dch);
		izq = mergeSort(izq);
		dch = mergeSort(dch);
		System.out.println("Despues: izq = "+izq+" dch= "+dch);

		// Unir

		List<Carta> res = new ArrayList<Carta>();

		while(dch.size()>0 && izq.size()>0) { // las dos listas tengan elementos
			if ( izq.get(0).compareTo(dch.get(0)) <= 0 ) {
				// uso lo que hay en izq
				res.add(izq.remove(0));
			} else {
				// uso lo que hay en dch
				res.add(dch.remove(0));
			}
		}

		res.addAll(izq);
		while(dch.size()>0) {
			res.add(dch.remove(0));
		}

		System.out.println("Final:" + res);
		return res;
	}

	public static void quickSort( List<Carta> miLista ) {
		if (miLista.size() <= 1) {
			return;
		}
		System.out.println("Inicio:" + miLista);
		// Elegimos el pivot
		int mitad = miLista.size()/2;
		Carta pivot = miLista.get(mitad);
		System.out.println("Pivot:"+ pivot);
		List<Carta> izq = new ArrayList<Carta>();
		List<Carta> dch = new ArrayList<Carta>();

		for (int i = 0; i < miLista.size(); i++) {
			if( i == mitad) continue;
			if( miLista.get(i).compareTo(pivot) <= 0 ) {
				izq.add(miLista.get(i));
			} else {
				dch.add(miLista.get(i));
			}
		}
		quickSort(izq);
		quickSort(dch);

		miLista.clear();
		miLista.addAll(izq);
		miLista.add(pivot);
		miLista.addAll(dch);

		System.out.println("Final:" + miLista);
	}

	private static void quickSort2(List<Carta> data) {
		sort(data, 0, data.size());
	}

	private static void sort(List<Carta> data, int inicio, int fin) {
		// cond parada
		if( inicio >= fin ) {
			return;
		}
		
		// elegir pivot
		System.out.println("datos: " + data);
		System.out.println(inicio + " " + fin);
		Carta pivot = data.get(inicio);
		System.out.println("pivot: "+ pivot);
		int numMenores = 0;
		
		// recolocar respecto al pivot
		for (int pos = inicio + 1; pos < fin; pos++) {
			if (pivot.compareTo(data.get(pos)) > 0 ) { 
				// lo que hay en pos, es menor o igual que pivot
				numMenores++;
				swap(pos, numMenores+inicio, data);
			} else {
				// pos mayor que pivot
			}
		}
		swap(inicio, numMenores+inicio, data);
		
		System.out.println("Recolocado: "+ data);
		// ordenar la parte izq y dcha
		sort(data, inicio, numMenores+inicio);
		sort(data, numMenores+inicio+1, fin);
		
	}
	
}