import java.awt.Toolkit;

public class Sonido implements Runnable {


	@Override
	public void run() {
		while(true)
			try {
				Toolkit.getDefaultToolkit().beep();
				Thread.sleep(5000);
			} catch (Exception e) {

			}
	}
}
