package g25.tema4.parking;

public class MonitorParking {

	private int plazasLibres;
	
	public MonitorParking(int plazasLibres) {
		this.plazasLibres = plazasLibres;
	}
	
	public synchronized void entra(String nombreCoche) throws Exception {
		while(plazasLibres<=0) 
			wait();
		plazasLibres--;
		System.out.println("Entra el coche "+nombreCoche+" y quedan "+ plazasLibres+ " plazas");
	}
	
	public synchronized void salir(String nombreCoche) {
		plazasLibres++;
		System.out.println("Sale el coche "+nombreCoche+" y quedan "+ plazasLibres+ " plazas");
		notifyAll();
	}
}
