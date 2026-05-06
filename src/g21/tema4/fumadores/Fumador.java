package g21.tema4.fumadores;

public class Fumador extends Thread {

	public String ingrediente;
	public Estanco estanco;

	public Fumador(String ingrediente, Estanco estanco) {
		this.ingrediente = ingrediente;
		this.estanco = estanco;
	}

	@Override
	public void run() {
		try {
			while(true) {
				
				estanco.comprarIngredientes(ingrediente);
				
				sleep(4000);
				
				estanco.avisarEstanquero();

			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
