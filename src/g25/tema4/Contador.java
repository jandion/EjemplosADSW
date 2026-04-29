package g25.tema4;

public class Contador extends Thread {

	static int c;
	String nombre;
	
	public Contador(String nombre) {
		this.nombre=nombre;
	}


	public void contar() {
		for (int i = 0; i < 100; i++) {
			c++;
			//System.out.println(nombre +" vale: "+ c);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		contar();
	}

}
