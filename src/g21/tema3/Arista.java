package g21.tema3;

public class Arista {

	Nodo origen, destino;
	double peso;

	public Arista (Nodo a, Nodo b, double peso) {
		this.origen = a;
		this.destino = b;
		this.peso = peso;
	}

	public Nodo getOtro(Nodo a) {
		if(a.equals(origen))
			return destino;
		else 
			return origen;
	}



}
