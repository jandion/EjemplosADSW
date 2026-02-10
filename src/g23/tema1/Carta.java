package g23.tema1;

public class Carta implements Comparable<Carta>{
	public int numero;
	public Palo palo;

	public Carta(int numero, Palo palo) {
		this.numero = numero;
		this.palo = palo;
	}

	public String toString() {
		String paloEmoji = "";
		if(palo == Palo.PICAS)
			paloEmoji = "♤";
		else if(palo == Palo.DIAMANTES)
			paloEmoji = "♦";
		else if(palo == Palo.CORAZONES)
			paloEmoji = "♥";
		else
			paloEmoji = "♣";

		return ""+numero+paloEmoji;
	}

	public boolean menorOIgual(Carta otra) {
		if (this.numero != otra.numero) {
			return this.numero <=  otra.numero;
		}
		if(this.palo == Palo.DIAMANTES) {
			return true;
		}
		if(this.palo == Palo.CORAZONES) {
			return otra.palo == Palo.CORAZONES ||
					otra.palo == Palo.TREBOLES ||
					otra.palo == Palo.PICAS ;
		}
		if(this.palo == Palo.TREBOLES) {
			return otra.palo == Palo.TREBOLES ||
					otra.palo == Palo.PICAS ;
		}
		if(this.palo == Palo.PICAS) {
			return otra.palo == Palo.PICAS ;
		}
		// aqui no deberiamos llegar
		return false;
	}

	@Override
	public int compareTo(Carta o) {
		return 0;
	}
}
