package g21.tema4.fumadores;

public class PruebaFumadores {

	public static void main(String[] args) {
		Estanco estanco = new Estanco();
		new Estanquero(estanco).start();
		new Fumador("tabaco", estanco).start();
		new Fumador("papel", estanco).start();
		new Fumador("cerillas", estanco).start();
	}
}
