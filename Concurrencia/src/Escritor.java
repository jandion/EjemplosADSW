
public class Escritor extends Thread {

	String nombre, mensajeAEscribir;
	Pantalla p;

	public Escritor(String nombre, String mensajeAEscribir, Pantalla p) {
		this.nombre = nombre;
		this.mensajeAEscribir = mensajeAEscribir;
		this.p = p;
	}
	
	@Override
	public void run() {
		System.out.println("%s empieza a escribir su mensaje".formatted(nombre));
		String[] tokens = mensajeAEscribir.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			p.escribir(tokens[i]);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		p.escribir("\n");
		System.out.println("%s ha terminado de escribir su mensaje".formatted(nombre));
	}
	
	
}
