package g25.tema4.canibales;

public class Cocinero extends Thread {
	
	private Caldero caldero;
	
	public Cocinero(Caldero caldero) {
		this.caldero = caldero;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				caldero.cocineroEspera();
				caldero.llenarCaldero();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
