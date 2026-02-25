package g25.tema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiccionarioLista implements Diccionario{
	
	// Clientes
	List<ClaveValor<String, List<String>>> elementos;
	
	public DiccionarioLista() {
		elementos = new ArrayList<>();
	}
	
	public void eliminarYBarajar(){
		Collections.shuffle(elementos);
		elementos = elementos.subList(0, 50);
	}
	
	public void put(String clave, List<String> valor) {
		for (int i = 0; i< elementos.size(); i++) {
			if (elementos.get(i).clave.equals(clave)) {
				elementos.get(i).valor = valor;
				return;
			}
		}
		elementos.add(new ClaveValor<>(clave,valor));
	}
	
	public boolean contains(String claveBuscada) {
		boolean encontrado = false;
		for (int i = 0; i< elementos.size(); i++) {
			if (elementos.get(i).clave.equals(claveBuscada)) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	public boolean remove(String claveBuscada) {
		for (int i = 0; i< elementos.size(); i++) {
			if (elementos.get(i).clave.equals(claveBuscada)) {
				elementos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<String> get(String claveBuscada) {
		for (int i = 0; i< elementos.size(); i++) {
			if (elementos.get(i).clave.equals(claveBuscada)) {
				
				return elementos.get(i).valor;
			}
		}
		return null;
	}
	
	public int size() {
		return elementos.size();
	}
			

}
