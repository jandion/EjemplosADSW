package g21.tema4;

public class Contador extends Thread{

	String nombre;
	MonitorContador monitor;
	public Contador(String nombre, MonitorContador monitor) {
		this.nombre=nombre;
		this.monitor = monitor;
	}
	
	public void contar() {
		for( int i = 0; i< 1000000; i++) {
			// region critica
			monitor.incrementa();
			System.out.println("El contador "+ nombre+": "+ monitor.getContador());
			// fin region
			
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.exit(-1);
//			}
		}
	}
	
	@Override
	public void run() {
		contar();
	}
}
