package g25.tema2;

import java.util.List;

public interface Diccionario {

	public void put(String clave, List<String> valor);
	public int size();
	public boolean remove(String clave);
	public List<String> get(String clave);
	public boolean contains(String clave);
}
