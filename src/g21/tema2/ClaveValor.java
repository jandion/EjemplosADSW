package g21.tema2;

public class ClaveValor<K,V> {
	
	K clave;
	V valor;
	
	public ClaveValor(K clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ClaveValor [clave=" + clave + ", valor=" + valor + "]";
	}
	
	

}
