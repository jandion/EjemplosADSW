
public class Hora extends Thread {

	
	boolean activo = true;
	@Override
	public void run() {
		while(activo)
			try {
				System.out.println(System.currentTimeMillis());
				Thread.sleep(1000);
			} catch (Exception e) {

			}
	}
	
	public void detener() {
		activo = false;
	}
}
