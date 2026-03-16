package g21.tema2;

import java.util.List;

public class ArbolBinarioBusquedaDiccionario implements Diccionario {

	private Nodo raiz;

	@Override
	public int size() {
		return sizeEnNodo(raiz);
	}
	
	private int sizeEnNodo(Nodo nodo) {
		if(nodo == null) {
			return 0;
		}
		int total = 1;
		total += sizeEnNodo(nodo.hijoIzq);
		total += sizeEnNodo(nodo.hijoDch);
		return total;
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(String key, List<String> value) {
//		if (raiz == null) {// no hay raiz 
//			raiz = new Nodo(key, value);
//		} else {
//			int cmp = raiz.cv.clave.compareTo(key);
//			
//			if (cmp == 0) {
//				raiz.cv.valor = value;
//			} else if (cmp < 0) { // la raiz es menor, voy a la dcha
//				if (raiz.hijoDch == null)
//					raiz.hijoDch = new Nodo(key,value);
//				else {
//					// sigo por la derecha
//				}
//			} else {
//				if (raiz.hijoIzq == null)
//					raiz.hijoIzq = new Nodo(key,value);
//				else {
//					// sigo por la izquierda
//				}
//			}
//		}
		putEnNodo(raiz, key, value);

	}
	
	private void putEnNodo(Nodo nodo, String key, List<String> value) {
		if (nodo == null) {
			nodo = new Nodo(key, value);
		} else {
			int cmp = nodo.cv.clave.compareTo(key);
			
			if (cmp == 0) {
				nodo.cv.valor = value;
			} else if (cmp < 0) { // el nodo es menor, voy a la dcha
				if (nodo.hijoDch == null)
					nodo.hijoDch = new Nodo(key,value);
				else {
					// sigo por la derecha
					putEnNodo(nodo.hijoDch, key, value);
				}
			} else {
				if (nodo.hijoIzq == null)
					nodo.hijoIzq = new Nodo(key,value);
				else {
					// sigo por la izquierda
					putEnNodo(nodo.hijoIzq, key, value);
				}
			}
		}
	}

}
