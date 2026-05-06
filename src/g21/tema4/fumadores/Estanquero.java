package g21.tema4.fumadores;

public class Estanquero extends Thread {
	
	private Estanco estanco;
	public Estanquero(Estanco estanco) {
		this.estanco = estanco;
	}

	@Override
	public void run() {
		while(true) {
			
			estanco.ponerIngredientes();
			try {
				estanco.esperarAQueMeAvisen();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
