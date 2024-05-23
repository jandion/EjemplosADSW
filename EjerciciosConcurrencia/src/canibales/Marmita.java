package canibales;

public class Marmita {

	private int raciones = 0;
	public static final int CAPACIDAD = 10;
	private int quienLlama = -1;
	
	synchronized public void comer(int canibalId) throws Exception {
		while(raciones <= 0 && quienLlama == -1) {
			notify();
			System.err.println("El canibal "+canibalId +" ha llamado al cocinero");
			quienLlama = canibalId;
			wait();
		}
		while(quienLlama != -1 && quienLlama != canibalId) {
			wait();
		}
		raciones--;
		quienLlama = -1;
		notifyAll();
		
		System.out.println("Ha comido el canibal "+canibalId+" quedan "+raciones);
	}
	
	public synchronized void cocinar() throws InterruptedException {
		
		raciones += CAPACIDAD;
		System.out.println("Se ha rellenado la marmita");
		notifyAll();
		while(raciones >0 || quienLlama == -1)
		 wait();
	}
}
