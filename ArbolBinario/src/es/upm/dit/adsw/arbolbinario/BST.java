package es.upm.dit.adsw.arbolbinario;

public class BST {
	
	private Nodo raiz;
	
	public void insertar(ElementoDiccionario elemento) {
		if(raiz == null) {
			raiz = new Nodo(elemento);
		} else {
			insertar(raiz, elemento);
		}
	}

	private void insertar(Nodo nodoActual, ElementoDiccionario elemento) {
		int comparacion = nodoActual.getElemento().compareTo(elemento);
		if( comparacion == 0 ) {
			nodoActual.getElemento().setValor(elemento.getValor());
		} else if (comparacion < 0) {
			if(nodoActual.getHijoIzquierdo() != null) {
				insertar(nodoActual.getHijoIzquierdo(), elemento);
			} else {
				nodoActual.setHijoIzquierdo(new Nodo(elemento));
			}
		} else {
			if(nodoActual.getHijoDerecho() != null) {
				insertar(nodoActual.getHijoDerecho(), elemento);
			} else {
				nodoActual.setHijoDerecho(new Nodo(elemento));
			}
		}
	}
	
	public boolean buscar(int clave) {
		if (raiz == null) {
			return false;
		}
		return buscar(raiz,clave);
	}
	
	private boolean buscar(Nodo nodoActual, int clave) {
		int comparacion = Integer.compare(nodoActual.getClave(), clave);
		if( comparacion == 0 ) {
			return true;
		} else if( comparacion < 0 ) {
			if (nodoActual.getHijoIzquierdo() == null) {
				return false;
			}
			return buscar(nodoActual.getHijoIzquierdo(), clave);
		} else {
			if (nodoActual.getHijoDerecho() == null) {
				return false;
			}
			return buscar(nodoActual.getHijoDerecho(), clave);
		}
	}
	
	public ElementoDiccionario eliminar(int clave) {
		if (raiz == null) {
			return null;
		}
		if (Integer.compare(raiz.getClave(), clave) == 0) {
			ElementoDiccionario resultado = raiz.getElemento();
			raiz = null;
			return resultado;
		}
		return eliminar(raiz, clave);
	}
	
	public ElementoDiccionario eliminar(Nodo nodoActual, int clave) {
		int comparacion = Integer.compare(nodoActual.getClave(), clave);
		
		if (comparacion < 0) {
			if (nodoActual.getHijoIzquierdo() == null) {
				return null;
			}
			if (Integer.compare(nodoActual.getHijoIzquierdo().getClave(), clave) == 0) {
				ElementoDiccionario resultado = nodoActual.getHijoIzquierdo().getElemento();
				eliminaNodo(nodoActual, true);
				return resultado;
			} else {
				return eliminar(nodoActual.getHijoIzquierdo(), clave);
			}
		} else {
			if (nodoActual.getHijoDerecho() == null) {
				return null;
			}
			if (Integer.compare(nodoActual.getHijoDerecho().getClave(), clave) == 0) {
				ElementoDiccionario resultado = nodoActual.getHijoDerecho().getElemento();
				eliminaNodo(nodoActual, false);
				return resultado;
			} else {
				return eliminar(nodoActual.getHijoDerecho(), clave);
			}
		}
	}

	private void eliminaNodo(Nodo padre, boolean izquierda) {
		Nodo nodoAEliminar = izquierda ? padre.getHijoIzquierdo() : padre.getHijoDerecho();
		Nodo hijoIzquierdo = nodoAEliminar.getHijoIzquierdo();
		Nodo hijoDerecho = nodoAEliminar.getHijoDerecho();
		if (hijoIzquierdo == null && hijoDerecho == null) {
			if (izquierda) {
				padre.setHijoIzquierdo(null);
			} else {
				padre.setHijoDerecho(null);
			}
		} else if (hijoIzquierdo != null && hijoDerecho == null) {
			if (izquierda) {
				padre.setHijoIzquierdo(hijoIzquierdo);
			} else {
				padre.setHijoDerecho(hijoIzquierdo);
			}
		} else if (hijoIzquierdo == null && hijoDerecho != null) {
			if (izquierda) {
				padre.setHijoIzquierdo(hijoDerecho);
			} else {
				padre.setHijoDerecho(hijoDerecho);
			}
		} else {
			Nodo nodoSustituto = hijoDerecho;
			Nodo padreNodoSustituto = nodoAEliminar;
			while(nodoSustituto.getHijoIzquierdo() != null) {
				padreNodoSustituto = nodoSustituto;
				nodoSustituto = nodoSustituto.getHijoIzquierdo();
			}
			padreNodoSustituto.setHijoIzquierdo(nodoSustituto.getHijoDerecho());
			if (izquierda) {
				nodoSustituto.setHijoIzquierdo(hijoIzquierdo);
				nodoSustituto.setHijoDerecho(hijoDerecho);
				padre.setHijoIzquierdo(nodoSustituto);
			} else {
				nodoSustituto.setHijoIzquierdo(hijoIzquierdo);
				nodoSustituto.setHijoDerecho(hijoDerecho);
				padre.setHijoDerecho(nodoSustituto);
			}
		}
	}
	
	public int getAltura() {
		if (raiz == null) {
			return 0;
		}
		return 1 + getAltura(raiz);
	}
	
	private int getAltura(Nodo nodoActual) {
		if (nodoActual == null)
			return 0;
		return 1 + Math.max(getAltura(nodoActual.getHijoIzquierdo()), getAltura(nodoActual.getHijoIzquierdo()));
	}
	

}
