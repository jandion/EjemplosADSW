package es.upm.dit.adsw.arbolbinario;

import java.util.List;

public class BST {
	
	private Nodo raiz;

	public static void main(String[] args) {

		// Smoke test
		BST test = new BST();

		System.out.println("Añadimos nodos");
		test.insertar(new ElementoDiccionario(10, "Test1"));
		test.insertar(new ElementoDiccionario(30, "Test2"));
		test.insertar(new ElementoDiccionario(20, "Test3"));
		test.insertar(new ElementoDiccionario(5, "Test4"));
		System.out.println("Imprimimos el árbol");
		test.imprimeArbol();

		System.out.println("Altura: " + test.getAltura());
		System.out.println("Número de nodos: " + test.getNumeroNodos());

		System.out.println("Recorridos");
		System.out.println(test.inOrden());
		System.out.println(test.preOrden());
		System.out.println(test.postOrden());

		System.out.println("Buscamos nodos");
		System.out.println(test.buscar(20));
		System.out.println(test.buscar(30));
		System.out.println(test.buscar(40));

		System.out.println("Eliminamos nodos");
		System.out.println(test.eliminar(10));
		System.out.println(test.buscar(10));
		test.imprimeArbol();

		System.out.println("Altura: " + test.getAltura());
		System.out.println("Número de nodos: " + test.getNumeroNodos());

		System.out.println("Recorridos");
		System.out.println(test.inOrden());
		System.out.println(test.preOrden());
		System.out.println(test.postOrden());
	}
	
	//--------------------------------------------
	// INSERCIÓN
	// Se recorre el árbol de forma recursiva hasta
	// encontrar un nodo vacío donde insertar el nuevo
	// elemento
	//
	// Hay un método público que recibe un elemento
	// y otro privado que recibe un nodo y un elemento
	// El segundo es el que se llama recursivamente
	//--------------------------------------------

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
		} else if (comparacion > 0) {
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
	
	//--------------------------------------------
	// BÚSQUEDA
	// Se recorre el árbol de forma recursiva hasta
	// encontrar el nodo con la clave buscada o llegar
	// a un nodo vacío
	//
	// Hay un método público que recibe una clave
	// y otro privado que recibe un nodo y una clave
	// El segundo es el que se llama recursivamente
	//--------------------------------------------

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
		} else if( comparacion > 0 ) {
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
	
	//--------------------------------------------
	// ELIMINACIÓN
	// Se recorre el árbol de forma recursiva hasta
	// encontrar el nodo con la clave buscada o llegar
	// a un nodo vacío
	//
	// Hay un método público que recibe una clave
	// y otro privado que recibe un nodo y una clave
	// El segundo es el que se llama recursivamente
	//
	// Si se elimina un nodo, este se sustituye por el
	// nodo más a la izquierda del subárbol derecho
	//--------------------------------------------

	public ElementoDiccionario eliminar(int clave) {
		if (raiz == null) {
			return null;
		}
		if (Integer.compare(raiz.getClave(), clave) == 0) {
			ElementoDiccionario resultado = raiz.getElemento();
			eliminaRaiz();
			return resultado;
		}
		return eliminar(raiz, clave);
	}
	
	public ElementoDiccionario eliminar(Nodo nodoActual, int clave) {
		int comparacion = Integer.compare(nodoActual.getClave(), clave);
		
		if (comparacion > 0) {
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

	/**
	 * Elimina un nodo del árbol
	 * Cambia la referencia del padre al nodo a eliminar por el nodo sustituto
	 * Si el nodo a eliminar es una hoja, simplemente se elimina
	 * Si solo tiene un hijo, se cambia la referencia del padre al nodo a eliminar por el hijo
	 * En caso de tener dos hijos, se busca el nodo sustituto y se cambia la referencia del padre 
	 * al nodo a eliminar por el nodo sustituto
	 * El nodo sustituto es el nodo más a la izquierda del subárbol derecho
	 */
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

	/**
	 * Funciona como eliminaNodo pero para el caso especial de la raíz
	 */
	public void eliminaRaiz() {
		Nodo hijoIzquierdo = raiz.getHijoIzquierdo();
		Nodo hijoDerecho = raiz.getHijoDerecho();
		if( hijoIzquierdo == null && hijoDerecho == null ) {
			raiz = null;
		} else if( hijoIzquierdo != null && hijoDerecho == null ) {
			raiz = hijoIzquierdo;
		} else if( hijoIzquierdo == null && hijoDerecho != null ) {
			raiz = hijoDerecho;
		} else {
			Nodo nodoSustituto = hijoDerecho;
			Nodo padreNodoSustituto = raiz;
			while(nodoSustituto.getHijoIzquierdo() != null) {
				padreNodoSustituto = nodoSustituto;
				nodoSustituto = nodoSustituto.getHijoIzquierdo();
			}
			padreNodoSustituto.setHijoIzquierdo(nodoSustituto.getHijoDerecho());
			nodoSustituto.setHijoIzquierdo(hijoIzquierdo);
			nodoSustituto.setHijoDerecho(hijoDerecho);
			raiz = nodoSustituto;
		}
	}
	
	//--------------------------------------------
	// ALTURA DEL ÁRBOL
	// Cada nodo tiene una altura igual a 1 más la
	// altura del nodo más alto de sus hijos
	//--------------------------------------------

	public int getAltura() {
		return getAltura(raiz);
	}
	
	private int getAltura(Nodo nodoActual) {
		if (nodoActual == null)
			return 0;
		return 1 + Math.max(getAltura(nodoActual.getHijoIzquierdo()), getAltura(nodoActual.getHijoDerecho()));
	}

	//--------------------------------------------
	// RECORRIDOS
	// Se recorren los nodos del árbol de forma
	// recursiva en tres órdenes diferentes:
	// inOrden, preOrden y postOrden
	//--------------------------------------------

	public List<ElementoDiccionario> inOrden() {
		List<ElementoDiccionario> resultado = new java.util.ArrayList<>();
		inOrden(raiz, resultado);
		return resultado;
	}

	private void inOrden(Nodo nodoActual, List<ElementoDiccionario> resultado) {
		if (nodoActual == null) {
			return;
		}
		inOrden(nodoActual.getHijoIzquierdo(), resultado);
		resultado.add(nodoActual.getElemento());
		inOrden(nodoActual.getHijoDerecho(), resultado);
	}

	public List<ElementoDiccionario> preOrden() {
		List<ElementoDiccionario> resultado = new java.util.ArrayList<>();
		preOrden(raiz, resultado);
		return resultado;
	}

	private void preOrden(Nodo nodoActual, List<ElementoDiccionario> resultado) {
		if (nodoActual == null) {
			return;
		}
		resultado.add(nodoActual.getElemento());
		preOrden(nodoActual.getHijoIzquierdo(), resultado);
		preOrden(nodoActual.getHijoDerecho(), resultado);
	}
	
	public List<ElementoDiccionario> postOrden() {
		List<ElementoDiccionario> resultado = new java.util.ArrayList<>();
		postOrden(raiz, resultado);
		return resultado;
	}

	private void postOrden(Nodo nodoActual, List<ElementoDiccionario> resultado) {
		if (nodoActual == null) {
			return;
		}
		postOrden(nodoActual.getHijoIzquierdo(), resultado);
		postOrden(nodoActual.getHijoDerecho(), resultado);
		resultado.add(nodoActual.getElemento());
	}

	//--------------------------------------------
	// NÚMERO DE NODOS
	// El número de nodos desde un nodo dado es 1
	// más el número de nodos de sus hijos
	//
	// El número de nodos del árbol es el número
	// de nodos desde la raíz
	//--------------------------------------------
	public int getNumeroNodos() {
		return getNumeroNodos(raiz);
	}

	private int getNumeroNodos(Nodo nodoActual) {
		if (nodoActual == null) {
			return 0;
		}
		return 1 + getNumeroNodos(nodoActual.getHijoIzquierdo()) + getNumeroNodos(nodoActual.getHijoDerecho());
	}
	
	//--------------------------------------------
	// IMPRESIÓN DEL ÁRBOL
	// Método auxiliar para visualizar el árbol
	//--------------------------------------------
	public void imprimeArbol() {
		imprimeArbol(raiz, 0);
	}

	private void imprimeArbol(Nodo nodoActual, int nivel) {
		if (nodoActual == null) {
			return;
		}
		imprimeArbol(nodoActual.getHijoDerecho(), nivel + 1);
		for (int i = 0; i < nivel; i++) {
			System.out.print("   ");
		}
		System.out.println(nodoActual.getClave());
		imprimeArbol(nodoActual.getHijoIzquierdo(), nivel + 1);
	}

}
