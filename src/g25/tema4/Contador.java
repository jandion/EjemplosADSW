package g25.tema4;

public class Contador extends Thread {


	String nombre;
	MonitorContador monitor;
	
	public Contador(String nombre, MonitorContador monitor) {
		this.nombre=nombre;
		this.monitor = monitor;
	}


	public void contar() {
		for (int i = 0; i < 1_000_000; i++) {
			monitor.incrementar();
			System.out.println(nombre +" vale: "+ monitor.getContador());
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	@Override
	public void run() {
		contar();
	}

}
