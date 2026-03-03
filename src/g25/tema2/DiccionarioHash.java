package g25.tema2;

import java.util.List;

public class DiccionarioHash implements Diccionario {

	ClaveValor<String, List<String>>[] elementos;
	int numElementos;
	public DiccionarioHash() {
		elementos = new ClaveValor[100];
		numElementos = 0;
	}


	private int hash(String clave) {
		int pos = clave.hashCode()%elementos.length;

		while(true) {
			// que pos esté vacío
			if(elementos[pos] == null) {
				return pos;
			}

			// que pos contenga clave
			if(elementos[pos].clave.equals(clave)) {
				return pos;
			}

			// que pos contenga otra clave
			//pos = (pos+1)%elementos.length; // sondeo lineal
			pos = Integer.hashCode(pos)%elementos.length; // rehash
			if (pos == clave.hashCode()%elementos.length) {
				System.err.println("El diccionario está lleno y no está la clave");
			}
		}

		//return pos;
	}

	@Override
	public void put(String clave, List<String> valor) {
		int pos = hash(clave);
		if (elementos[pos] == null) {
			numElementos++;
		}
		elementos[pos] = new ClaveValor<String, List<String>>(clave, valor);
	}

	@Override
	public int size() {
		return numElementos;
	}

	@Override
	public boolean remove(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> get(String clave) {
		int pos = hash(clave);
		if (elementos[pos] == null) {
			return null;
		}
		return elementos[pos].valor;
	}

	@Override
	public boolean contains(String clave) {
		int pos = hash(clave);
		return elementos[pos] != null;
	}

}
