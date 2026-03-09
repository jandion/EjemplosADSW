package g25.tema2;

import java.util.List;

public class Nodo {

	public String clave;
	public List<String> valor;
	public Nodo hijoIzq, hijoDch;

	public Nodo(ClaveValor<String, List<String>> cv) {
		this.clave = cv.clave;
		this.valor = cv.valor;
	}
	public Nodo(String clave, List<String> valor) {
		this.clave = clave;
		this.valor = valor;
	}
}
