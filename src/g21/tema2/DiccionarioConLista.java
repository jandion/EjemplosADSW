package g21.tema2;

import java.util.ArrayList;
import java.util.List;

public class DiccionarioConLista implements Diccionario {

	List<ClaveValor<String, List<String>>> elementos;
	
	public DiccionarioConLista() {
		elementos = new ArrayList<>();
	}
	
	@Override
	public int size() {
		return elementos.size();
	}

	@Override
	public boolean contains(String key) {
		for( ClaveValor cv : elementos) {
			if(cv.clave.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> get(String key) {
		for( ClaveValor<String, List<String>> cv : elementos) {
			if(cv.clave.equals(key)) {
				return cv.valor;
			}
		}
		return null;
	}

	@Override
	public void put(String key, List<String> value) {
		if (!contains(key)) {
			elementos.add(new ClaveValor<>(key, value));
		} else {
			for( ClaveValor<String, List<String>> cv : elementos) {
				if(cv.clave.equals(key)) {
					cv.valor = value;
					return;
				}
			}
		}
		
	}

}
