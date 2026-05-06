package g25.tema4.productorConsumidor;

public class Productor extends Thread {

	private Buffer buffer;

	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {

		while(true) {
			try {
				int dato = (int) (Math.random()*10);
				buffer.guardarDato(dato);

				sleep(1000);
			}catch (InterruptedException e) {

			}
		}
	}
}
