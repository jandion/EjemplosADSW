public class ArbolBinario {
	private Nodo raiz;
	private int alturaArbol;
	
	public ArbolBinario() {
	}
	
	public void insertarNodoDesde(Nodo nodoPadre, Nodo nodoAInsertar) {
		if (nodoAInsertar.valor < nodoPadre.valor) {
			if (nodoPadre.hijoIzquierdo != null) {
				insertarNodoDesde(nodoPadre.hijoIzquierdo, nodoAInsertar);
			} else {
				nodoPadre.hijoIzquierdo = nodoAInsertar;
				return;
			}
			
		}
		else {
			if (nodoPadre.hijoDerecho != null) {
				insertarNodoDesde(nodoPadre.hijoDerecho, nodoAInsertar);
			} else {
				nodoPadre.hijoDerecho = nodoAInsertar;
				return;
			}
		}
	}
	
	public void insertarNodo(Nodo n) {
		if (raiz == null) {
			raiz = n;
			return;
		}
		insertarNodoDesde(raiz, n);
	}
	
	public boolean estaNodoRecursivo(Nodo nodoPadre, Nodo nodoABuscar) {
		if (nodoABuscar.valor < nodoPadre.valor) {
			if (nodoPadre.hijoIzquierdo != null) {
				return estaNodoRecursivo(nodoPadre.hijoIzquierdo, nodoABuscar);
			} else {
				return false;
			}
			
		}
		else if (nodoABuscar.valor > nodoPadre.valor){
			if (nodoPadre.hijoDerecho != null) {
				return estaNodoRecursivo(nodoPadre.hijoDerecho, nodoABuscar);
			} else {
				return false;
			}
		}
		else {
			return true;
		}
	}
	
	public boolean estaNodo(Nodo n) {
		if (raiz == null) {
			return false;
		}
		if (raiz.valor == n.valor) {
			return true;
		}
		
		return estaNodoRecursivo(raiz, n);
		
	}
	
	
}
