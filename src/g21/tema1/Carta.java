package g21.tema1;

public class Carta implements Comparable<Carta> {

	int numero;
	Palo palo;
	
	public Carta(int numero, Palo palo) {
		this.numero = numero;
		this.palo = palo;
	}

	@Override
	public String toString() {
		String paloEmoji = "";
		if(palo == Palo.DIAMANTES) {
			paloEmoji = "♦";
		} else if(palo == Palo.CORAZONES) {
			paloEmoji = "♥";
		}else if(palo == Palo.PICAS) {
			paloEmoji = "♠";
		} else {
			paloEmoji = "♣";
		}
		return  numero + " " + paloEmoji;
	}
	
	public boolean esMenorOIgual(Carta otra) {
		if (this.numero != otra.numero) {
			return this.numero < otra.numero;
		}
		// miramos los palos
		if (this.palo == Palo.TREBOLES) {
			return true;
		}
		if (this.palo == Palo.PICAS) {
			return otra.palo == Palo.PICAS ||
					otra.palo == Palo.CORAZONES ||
					otra.palo == Palo.DIAMANTES;
		}
		if (this.palo == Palo.CORAZONES) {
			return otra.palo == Palo.CORAZONES ||
					otra.palo == Palo.DIAMANTES;
		}
		if (this.palo == Palo.DIAMANTES) {
			return otra.palo == Palo.DIAMANTES;
		}
		// aqui no deberiamos llegar
		return false;
	}

	@Override
	public int compareTo(Carta o) {
		if (this.numero != o.numero) {
			return numero - o.numero;
		}
		else {
			if (palo == Palo.TREBOLES) {
				if (o.palo == Palo.TREBOLES) {
					return 0;
				}
				else return -1;
			}
		}
		return 0;
	}
}
