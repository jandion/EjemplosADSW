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
		
		for(int i = 0; i<0; i++) {
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
		
		
		// Aqui vemos si esta ordenada
		for (int i = 0; i < baraja.size()-1; i++) {
			Carta actual = baraja.get(i);
			Carta siguiente = baraja.get(i+1);
			if (actual.esMenorOIgual(siguiente) ) {
				
			} else {
				System.out.println("No esta ordenado!");
			}
		}
	}

}
