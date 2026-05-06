package g21.tema4.parking;

public class HebraCoche extends Thread {

	String nombre;
	MonitorParking monitor;

	public HebraCoche (String nombre, MonitorParking monitor) {
		this.nombre = nombre;
		this.monitor = monitor;
	}

	@Override
	public void run() {
		try {
			while(true) {
				monitor.entra(nombre);

				sleep(5000);

				monitor.sale(nombre);

				sleep(2000);
			}

		} catch (Exception e) {

		}
	}

}
