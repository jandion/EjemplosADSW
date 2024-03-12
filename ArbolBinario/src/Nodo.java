

public class Nodo implements Comparable<Nodo> {
	public int valor;
	public Nodo hijoDerecho;
	public Nodo hijoIzquierdo;
	public int altura;
	
	public Nodo(int valor) {
		this.valor = valor;
		
	}

	@Override
	public int compareTo(Nodo o) {
		return Integer.compare(valor, o.valor);
	}
	
}