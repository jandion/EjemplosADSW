package g25.tema2;

import java.util.ArrayList;
import java.util.List;

public class DiccionarioHashListas implements Diccionario {

	List<ClaveValor<String, List<String>>>[] elementos;
	public DiccionarioHashListas() {
		elementos = new List[100];
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = new ArrayList();
		}
	}
	@Override
	public void put(String clave, List<String> valor) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int size() {
		int contador = 0;
		for(List l : elementos)
			contador += l.size();
		return contador;
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
		// TODO Auto-generated method stub
		return false;
	}
}
