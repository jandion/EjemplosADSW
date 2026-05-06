package g25.tema4.parking;

public class HebraCoche extends Thread {
	
	private String nombre;
	private MonitorParking monitor;
	
	public HebraCoche(String nombre, MonitorParking monitor ) {
		this.nombre = nombre;
		this.monitor = monitor;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				monitor.entra(nombre);
				
				sleep(3000);
				
				monitor.salir(nombre);
				
				Thread.sleep(2000);
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
