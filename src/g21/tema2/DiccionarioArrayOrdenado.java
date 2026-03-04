package g21.tema2;

import java.util.Arrays;
import java.util.List;

public class DiccionarioArrayOrdenado implements Diccionario{

	ClaveValor<String, List<String>>[] elementos;
	int numElementos = 0;

	public DiccionarioArrayOrdenado() {
		elementos = new ClaveValor[100];
	}

	@Override
	public int size() {
		return numElementos;
	}

	@Override
	public boolean contains(String key) {
		if (busquedaBinaria(key, 0, numElementos) < 0)
			return false;
		return true;
	}

	private int busquedaBinaria(String key, int inicio, int fin) {

		if( elementos[inicio] == null ) {
			return -inicio-1;
		}

		if( inicio >= fin ) {
			if (elementos[inicio].clave.compareTo(key) == 0) {
				// elementos[inicio].clave.equals(key)
				return inicio;
			} else {
				return -inicio-1;
			}
		}

		int m = (inicio+fin)/2;

		int cmp = elementos[m].clave.compareTo(key);

		if( cmp == 0 ) {
			return m;
		} else if ( cmp < 0) {
			// buscar arriba
			return busquedaBinaria(key, m, fin);
		} else { // cmp > 0
			return busquedaBinaria(key, inicio, m);
		}


	}

	@Override
	public List<String> get(String key) {
		int pos = busquedaBinaria(key, 0, numElementos);
		if (pos < 0) {
			return null;
		}
		return elementos[pos].valor;
		
	}

	@Override
	public void put(String key, List<String> value) {
		int pos = busquedaBinaria(key, 0, numElementos);
		if (pos < 0) {
			if( numElementos == elementos.length) {
				System.out.println("no caben más elementos");
				return;
			}
			// la clave no está
			int k = -(pos+1);
			for(int i = numElementos; i >= k; i--) {
				// swap i, i+1
				elementos[i+1] = elementos[i];
			}
			elementos[k] = new ClaveValor<String, List<String>>(key, value);
			// TODO: falta actualizar numElementos
			
		} else {
			// actualizo
			elementos[pos].valor = value;
		}

	}

}
