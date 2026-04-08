package g25.tema3;

public class Arista {

	Nodo origen, destino;
	double peso;
	
	public Arista(Nodo origen, Nodo destino, double peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}
	
	public Nodo getOtro(Nodo n) {
		if (n.equals(origen))
			return destino;
		else
			return origen;
	}
}
