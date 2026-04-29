package g21.tema4;

public class Reloj implements Runnable {

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000); 
				System.out.println(new java.util.Date().toString());
			} catch (Exception e) {

			}

		}

	}

}
