package g21.tema4.parking;

public class PruebaParking {
	
	public static void main(String[] args) {
		MonitorParking monitor = new MonitorParking(6);
		
		for (int i = 0; i < 10; i++) {
			new HebraCoche("Coche"+i, monitor).start();
		}
		
	}

}
