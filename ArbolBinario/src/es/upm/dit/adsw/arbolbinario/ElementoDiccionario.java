package es.upm.dit.adsw.arbolbinario;

public class ElementoDiccionario implements Comparable<ElementoDiccionario>{

	private int clave;
	private String valor;
	public ElementoDiccionario(int clave, String valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getClave() {
		return clave;
	}
	@Override
	public String toString() {
		return "ElementoDiccionario [clave=" + clave + ", valor=" + valor + "]";
	}
	
	@Override
	public int compareTo(ElementoDiccionario o) {
		return Integer.compare(clave, o.clave);
	}
	
	
}
