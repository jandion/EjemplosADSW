package g25.tema3;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	int id;
	List<Arista> vecinos;
	
	public Nodo( int id ) {
		this.id = id;
		vecinos = new ArrayList<>();
	}

	public boolean esVecinoDe(Nodo otro) {
		for(Arista ar : vecinos) {
			if (ar.getOtro(this).equals(otro)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean conectarA(Nodo otro) {
		if(esVecinoDe(otro)) return false;
		Arista ar = new Arista(this, otro, 1);
		vecinos.add(ar);
		otro.vecinos.add(ar);
		return true; 
	}
}
