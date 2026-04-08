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
		return false; // TODO
	}
	
	public boolean conectarA(Nodo otro) {
		return false; // TODO
	}
}
