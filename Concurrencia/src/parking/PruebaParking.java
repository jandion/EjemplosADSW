package parking;

public class PruebaParking {

	public static void main(String[] args) {
		 Parking p = new Parking();

		 Sensor s1 = new Sensor("s1", p);
		 Sensor s2 = new Sensor("s2", p);
		 Sensor s3 = new Sensor("s3", p);
		 
		 SensorSalida ssalida = new SensorSalida("salida", p);
		 
		 Supervisor supervisor = new Supervisor(p);
		 
		 
		 supervisor.start();
		 
		 new Thread(s1).start();
		 new Thread(s2).start();
		 new Thread(s3).start();
		 new Thread(ssalida).start();
	}
}
