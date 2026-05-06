package g25.tema4.fumadores;

public class Estanquero extends Thread {

	private Estanco estanco;
	
	public Estanquero(Estanco estanco) {
		this.estanco = estanco;
	}
}
