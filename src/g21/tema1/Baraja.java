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

}
