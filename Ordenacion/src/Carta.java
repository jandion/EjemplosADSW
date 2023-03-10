
public class Carta implements Comparable<Carta> {
	public String palo;
	public int valor;
	public Carta(String palo, int valor) {
		this.palo = palo;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return palo + " " + valor;
	}
	@Override
	public int compareTo(Carta o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
