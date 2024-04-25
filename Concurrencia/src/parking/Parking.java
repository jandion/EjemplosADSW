package parking;

public class Parking {
	
	public final int CAPACIDAD = 5;
	private int ocupados = 0;

	
	synchronized void entra(String sensor) throws InterruptedException {
		while(ocupados >= CAPACIDAD) {
			System.out.println(sensor + " en espera");
			wait();
		}
//		System.out.println("Entra un coche por "+sensor);
		ocupados++;
	}
	
	synchronized void sale(String sensor) throws InterruptedException {
//		System.out.println("Sale un coche por "+sensor);
		ocupados--;
		notifyAll();
	}
	
	synchronized int ocupados() {
		return ocupados;
	}
}
