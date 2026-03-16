package g21.tema2;

import java.util.List;

public class Nodo {
	public ClaveValor<String, List<String>> cv;
	public Nodo hijoIzq, hijoDch;
	
	public Nodo(String key, List<String> value) {
		this.cv = new ClaveValor<String, List<String>>(key, value);
	}
	public Nodo(ClaveValor cv) {
		this.cv = cv;
	}
}
