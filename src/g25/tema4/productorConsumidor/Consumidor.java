package g25.tema4.productorConsumidor;

public class Consumidor extends Thread {

	private Buffer buffer;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {

		while(true) {
			try {
				int dato = buffer.sacarDato();

				sleep(2000);
			}catch (InterruptedException e) {

			}
		}
	}
}
