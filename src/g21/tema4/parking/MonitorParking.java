package g21.tema4.parking;

public class MonitorParking {
	
	private int plazas;
	
	public MonitorParking(int plazasDisponibles) {
		plazas = plazasDisponibles;
	}
	
	public synchronized void entra(String nombreCoche) throws InterruptedException {
		while(plazas == 0) wait();
		plazas--;
		System.out.println("Ha entrado el coche "+ nombreCoche+" quedan "+plazas+" plazas");
	}
	
	public synchronized void sale(String nombreCoche) {
		plazas++;
		System.out.println("Ha salido el coche "+ nombreCoche+" quedan "+plazas+" plazas");
		notifyAll();
	}
	
	public synchronized void subirBarrera() throws InterruptedException {
		if (plazas < 3) wait();
		//sube la barrera
	}
	
	public synchronized int plazasLibres() {
		return plazas;
	}

}
