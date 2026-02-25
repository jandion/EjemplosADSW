package g25.tema2;

import java.util.List;

public class DiccionarioArrayOrdenado implements Diccionario{

	ClaveValor<String, List<String>>[] elementos;
	int numElementos;
	public DiccionarioArrayOrdenado() {
		elementos = new ClaveValor[100];
		numElementos = 0;
	}

	private int busquedaBinariaRecursiva(String claveBuscada) {
		return busquedaBinariaRecursivaInterna(claveBuscada, 0, numElementos);
	}
	private int busquedaBinariaRecursivaInterna(String claveBuscada, int inicio, int fin) {
		if(inicio ==  fin) {
			if(elementos[inicio]!=null &&elementos[inicio].clave.equals(claveBuscada)) {
				return inicio;
			}
			return -inicio-1;
		}
		int puntoMedio = (inicio+fin) / 2;
		
		int comparacion = elementos[puntoMedio].clave.compareTo(claveBuscada);
		
		if (comparacion == 0) {
			return puntoMedio;
		} else if ( comparacion < 0) {
			return busquedaBinariaRecursivaInterna(claveBuscada, puntoMedio+1, fin);
		} else {
			return busquedaBinariaRecursivaInterna(claveBuscada, 0, puntoMedio);
		}
		
	}


	@Override
	public void put(String clave, List<String> valor) {
		int pos = busquedaBinariaRecursiva(clave);
		if (pos<0) {
			// la clave no estaba
			
			int k = -(pos+1);
			for( int i = numElementos; i>k; i--) {
				swap(i, i-1);				
			}
			elementos[k] = new ClaveValor<String, List<String>>(clave, valor);
			numElementos++;
		} else {
			elementos[pos].valor = valor;
		}
	}

	private void swap(int i, int j) {
		ClaveValor aux = elementos[i];
		elementos[i] = elementos[j];
		elementos[j] = aux;
	}

	@Override
	public int size() {
		return numElementos;
	}

	@Override
	public boolean remove(String clave) {
		int pos = busquedaBinariaRecursiva(clave);
		if(pos>0) {
			for(int i = pos; i< numElementos; i++) {
				swap(i,i+1);
			}
			numElementos--;
		}
		return false;
	}

	@Override
	public List<String> get(String clave) {
		int pos = busquedaBinariaRecursiva(clave);
		
		if (pos < 0) {
			return null;
		}
		return elementos[pos].valor;
	}

	@Override
	public boolean contains(String clave) {
		return busquedaBinariaRecursiva(clave)>=0;
	}

}
