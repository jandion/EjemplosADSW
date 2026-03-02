package g21.tema2;

import java.util.List;

public interface Diccionario {

	int size();
	boolean contains(String key);
	List<String> get(String key);
	void put(String key, List<String> value);
}
