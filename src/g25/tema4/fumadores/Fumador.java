package g25.tema4.fumadores;

public class Fumador extends Thread {

	private Estanco estanco;
	
	public Fumador(Estanco estanco) {
		this.estanco = estanco;
	}

}
