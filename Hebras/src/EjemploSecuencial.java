import java.awt.Toolkit;

public class EjemploSecuencial {

	
	public static void main(String[] args) throws InterruptedException {
		int contador = 0;
		
		while(true) {
			System.out.println(System.currentTimeMillis());
			if(contador %5 == 0) {
				Toolkit.getDefaultToolkit().beep();
			}
			
			contador++;
			Thread.sleep(1000);
		}
	}
}
