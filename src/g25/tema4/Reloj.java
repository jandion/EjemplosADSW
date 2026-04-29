package g25.tema4;

import java.util.Date;

public class Reloj implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println(new Date().toString());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
