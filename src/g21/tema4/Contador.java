package g21.tema4;

public class Contador extends Thread{

	String nombre;
	static int c = 0;
	public Contador(String nombre) {
		this.nombre=nombre;
	}
	
	public void contar() {
		for( int i = 0; i< 100; i++) {
			c++;
			System.out.println("El contador "+ nombre+": "+ c);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
	@Override
	public void run() {
		contar();
	}
}
