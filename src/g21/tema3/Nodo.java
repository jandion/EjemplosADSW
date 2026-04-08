package g21.tema3;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	//String nombreCiudad;
	public int id;
	//int poblacion;
	public List<Arista> vecinos;
	
	
	public Nodo(int id) {
		this.id = id;
		vecinos = new ArrayList<>();
	}
	
	
	public boolean conectar(Nodo n) {
		Arista a = new Arista(this, n, 1);
		vecinos.add(a);
		n.vecinos.add(a);
		return true; 
	}
	
	public boolean eliminarArista(Arista a) {
		vecinos.remove(a);
		a.getOtro(this).vecinos.remove(a); // solo si es no dirigido
		return true;
	}

}
