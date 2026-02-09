package g25.tema1;

import java.util.ArrayList;
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
		
		for (int i = 0; i < 1; i++) {
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
		
		boolean estaOrdenado = true;
		// cora, dia, treb y pic
		// Comprobar si está ordenado
		for (int i = 0; i < manoCartas.size()-1; i++) {
			
			if(!manoCartas.get(i).esMenorQue(manoCartas.get(i+1))) {
				System.out.println("No está ordenado!");
				estaOrdenado = false;
			} 
		}
		
		if (estaOrdenado) {
			System.out.println("Todo bien!");
		} else {
			System.out.println("Alguno mal");
		}
	}
}
