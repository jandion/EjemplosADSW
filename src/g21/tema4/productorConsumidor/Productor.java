package g21.tema4.productorConsumidor;

public class Productor extends Thread{

	MonitorBuffer monitor;
	String name;
	public Productor(MonitorBuffer monitor, String name) {
		super();
		this.monitor = monitor;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int dato = (int)(Math.random()*10);
				monitor.guardarDato(dato);

				System.out.println("["+name+"] ha generado "+dato);
				sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}


}
