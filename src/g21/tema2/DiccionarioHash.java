package g21.tema2;

import java.util.List;

public class DiccionarioHash implements Diccionario {

	ClaveValor<String, List<String>>[] elementos;
	int numElementos = 0;

	public DiccionarioHash() {
		elementos = new ClaveValor[100000];
	}

	public int posHash(String key) {
		int pos = key.hashCode();
		pos = pos % elementos.length;

		int pos0 = pos;

		while (true) {

			if(elementos[pos] == null) {
				return pos;
			}
			if(elementos[pos].clave.equals(key)) {
				return pos;
			}
			
			pos = (pos+1)%elementos.length;
			if (pos == pos0) {
				System.out.println("Estamos en un bucle infinito");
				return -1;
			}
		}

	}

	@Override
	public int size() {
		return numElementos;
	}

	@Override
	public boolean contains(String key) {
		int pos = posHash(key);
		if (pos < 0) {
			return false;
		}
		return elementos[pos]!=null;
	}

	@Override
	public List<String> get(String key) {
		int pos = posHash(key);
		if (pos < 0) {
			return null;
		}
		if (elementos[pos]==null) {
			return null;
		}
		return elementos[pos].valor;
	}

	@Override
	public void put(String key, List<String> value) {

		int pos = posHash(key);
		if (pos < 0) {
			//??
			// error, no cabe
		} else if( elementos[pos]==null) {
			// no estaba y 
			// lo tengo que guardar aquí
			elementos[pos] = new ClaveValor<String, List<String>>(key, value);
			numElementos++;
		} else {
			// ya estaba la clave
			// lo tengo que guardar aquí
			elementos[pos].valor = value;
		}

	}

}
