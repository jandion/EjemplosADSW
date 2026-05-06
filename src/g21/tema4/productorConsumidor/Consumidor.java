package g21.tema4.productorConsumidor;

public class Consumidor extends Thread{

	MonitorBuffer monitor;
	String name;
	public Consumidor(MonitorBuffer monitor, String name) {
		super();
		this.monitor = monitor;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int dato = monitor.sacarDato();
				System.out.println("["+name+"] ha leido "+dato);
				sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}


}
