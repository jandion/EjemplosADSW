package g25.tema4.canibales;

public class Canibal extends Thread {
	
	private Caldero caldero;
	private String nombre;
	
	public Canibal(Caldero caldero, String nombre) {
		this.caldero = caldero;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				sleep((long)(1000 *Math.random())); //hace otra cosa
				caldero.comerRaciones(nombre);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
