package g25.tema1;

public class Carta implements Comparable<Carta>{

	public int valor;
	public Palo palo;

	public Carta(int valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}

	@Override
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
		return  "" + valor + paloEmoji ;
	}

	public boolean esMenorQue(Carta otra) {

		if (this.valor != otra.valor) {
			return this.valor <= otra.valor;
		}
		// cora, dia, treb y pic
		if(this.palo ==Palo.CORAZONES) {
			return true;
		}
		if(this.palo ==Palo.DIAMANTES) {
			return otra.palo==Palo.DIAMANTES || otra.palo==Palo.TREBOLES || otra.palo==Palo.PICAS;
		}
		if(this.palo ==Palo.TREBOLES) {
			return  otra.palo==Palo.TREBOLES || otra.palo==Palo.PICAS;
		}
		if(this.palo ==Palo.PICAS) {
			return otra.palo==Palo.PICAS;
		}
		return false;
	}

	@Override
	public int compareTo(Carta otra) {
		if (this.valor != otra.valor) {
			if (this.valor > otra.valor)
				return 1;
			else
				return -1;
		}
		if(this.palo ==Palo.CORAZONES) {
			if (otra.palo == Palo.DIAMANTES) return 0;
			return -1;

		}
		if(this.palo ==Palo.DIAMANTES) {
			if (otra.palo == Palo.DIAMANTES) return 0;

			if(otra.palo==Palo.TREBOLES || otra.palo==Palo.PICAS) {
				// this es menor que otra
				return -1;
			} else {
				return 1;
			}
		}
		if(this.palo ==Palo.TREBOLES) {
			if (otra.palo == Palo.TREBOLES) return 0;

			if(otra.palo==Palo.PICAS) {
				// this es menor que otra
				return -1;
			} else {
				return 1;
			}
		}
		if(this.palo ==Palo.PICAS) {
			if (otra.palo == Palo.PICAS) return 0;


			return 1;
		}

		return 0;
	}

}
