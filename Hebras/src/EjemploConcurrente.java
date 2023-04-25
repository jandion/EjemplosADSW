
public class EjemploConcurrente {

	public static void main(String[] args) {
		Hora h = new Hora();
		Sonido s = new Sonido();
		
		Thread threadSonido = new Thread(s);
		
		h.start();
		threadSonido.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.detener();
	}
}
