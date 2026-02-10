package g23.tema1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
	public static void main(String[] args) {
		Carta unoDia = new Carta(1, Palo.DIAMANTES);
		Carta unoCor = new Carta(1, Palo.CORAZONES);
		Carta dosPic = new Carta(2, Palo.PICAS);
		
		List<Carta> manoCartas = new ArrayList<>();

		manoCartas.add(unoCor);
		manoCartas.add(unoDia);
		manoCartas.add(dosPic);
		
		// añadir cartas
		for (int i = 0; i < 5; i++) {
			int numero = (int) (Math.random()*12+1);
			Palo palo;
			double r = Math.random();
			if(r < 0.25) {
				palo = Palo.DIAMANTES;
			} else if (r < 0.5) {
				palo = Palo.CORAZONES;
			} else if (r < 0.75) {
				palo = Palo.TREBOLES;
			} else {
				palo = Palo.PICAS;
			}
			manoCartas.add(new Carta(numero, palo));
		}
		
		System.out.println("Antes de ordenar");
		System.out.println(manoCartas);
		

		boolean noOrdenado= false;
		for (int i = 0; i < manoCartas.size()-1; i++) {
			Carta actual = manoCartas.get(i);
			Carta siguiente = manoCartas.get(i+1);
			
			if (!actual.menorOIgual(siguiente)) {
				// actual no está bien colocada
				System.out.println("No está ordenado!");
				noOrdenado = true;
			} 
		}
		
		while (noOrdenado) { 
			noOrdenado = false;
			for (int i = 0; i < manoCartas.size()-1; i++) {
				Carta actual = manoCartas.get(i);
				Carta siguiente = manoCartas.get(i+1);
				
				if (!actual.menorOIgual(siguiente)) {
					swap(manoCartas,i, i+1);
					noOrdenado = true;
				}
			}

			System.out.println("Despues de una pasada");
			System.out.println(manoCartas);
		}
	}
	
	public static void swap(List<Carta> mano, int pos1, int pos2) {
		Carta aux = mano.get(pos1);
		mano.set(pos1, mano.get(pos2));
		mano.set(pos2, aux);
	}
}
