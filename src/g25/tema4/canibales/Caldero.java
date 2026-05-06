package g25.tema4.canibales;

public class Caldero {

	private int raciones;
	
	
	public synchronized void cocineroEspera() throws InterruptedException{
		wait();
	}
	public synchronized void llenarCaldero() throws InterruptedException {
		//wait();
		System.out.println("El concinero rellena el caldero");
		raciones += 12;
		Thread.sleep(2000);
		System.out.println("Quedan: "+ raciones);
		cocineroAvisado = false;
		notifyAll();
	}
	
	private boolean cocineroAvisado = false;
	private String quienAvisaAlCocinero = null;
	
	public synchronized void comerRaciones(String nombre) throws InterruptedException {
		while(! (raciones > 0 && (nombre == null || nombre.equals(quienAvisaAlCocinero)))) {
			if(!cocineroAvisado) {
				cocineroAvisado = true;
				System.out.println(nombre + " llama al cocinero");
				quienAvisaAlCocinero = nombre;
				notifyAll();
			}
			wait();
		}
		quienAvisaAlCocinero = null;
		raciones--;
		System.out.println("Un caníbal "+nombre+" ha comido, quedan: "+ raciones);
	}
	
	public static void main(String[] args) {
		Caldero caldero = new Caldero();
		
		new Cocinero(caldero).start();
		for (int i = 0; i < 10; i++) {
			new Canibal(caldero,"Canibal"+i).start();
		}
	}
}
