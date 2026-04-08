package g25.tema2;

import java.util.List;

public class ArbolDiccionario implements Diccionario{

	private Nodo raiz;

	@Override
	public void put(String clave, List<String> valor) {
		if (raiz == null) {
			raiz = new Nodo(clave, valor);
		} else {
			put(raiz, clave, valor);
		}
	}

	private void put(Nodo nodo, String clave, List<String> valor) {
		if (nodo.clave.compareTo(clave) > 0) {
			if (nodo.hijoIzq == null)
				nodo.hijoIzq = new Nodo(clave,valor);
			else
				put(nodo.hijoIzq, clave, valor);
		} else if (nodo.clave.compareTo(clave) == 0) {
			nodo.valor = valor;
		} else {
			if (nodo.hijoDch == null)
				nodo.hijoDch = new Nodo(clave, valor);
			else
				put(nodo.hijoDch, clave, valor);
				
		}
	}

	@Override
	public int size() {
		return size(raiz);
	}
	
	private int size(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}
		int res = 1;
		res += size(nodo.hijoIzq);
		res += size(nodo.hijoDch);
		
		return res;
	}

	@Override
	public boolean remove(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> get(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String clave) {
		if (raiz == null) {
			return false;
		} else {
			return contains(raiz, clave);
		}
	}

	private boolean contains(Nodo nodo, String clave) {
		if (nodo.clave.compareTo(clave) > 0) {
			if (nodo.hijoIzq == null)
				return false;
			else
				return contains(nodo.hijoIzq, clave);
		} else if (nodo.clave.compareTo(clave) == 0) {
			return true;
		} else {
			if (nodo.hijoDch == null)
				return false;
			else
				return contains(nodo.hijoDch, clave);
				
		}
	}
	
	public void imprimeOrdenado() {
		System.out.println(recorreEnOrden(raiz));
	}

	private String recorreEnOrden(Nodo nodo) {
		if (nodo == null) return "";
		String res = "";
		res += recorreEnOrden(nodo.hijoIzq) +" ";
		res += nodo.clave + " ";
		res += recorreEnOrden(nodo.hijoDch) +" ";
		return res;
	}
	
	
	
}
