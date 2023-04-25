import java.awt.Toolkit;

public class EjemploConcurrente2 {


	public static void main(String[] args) {


		Runnable hora = new Runnable() {
			@Override
			public void run() {
				while(true)
					try {
						System.out.println(System.currentTimeMillis());
						Thread.sleep(1000);
					} catch (Exception e) {

					}

			}
		};
		
		
		
		new Thread(hora).start();
		new Thread() {
			@Override
			public void run() {
				while(true)
					try {
						Toolkit.getDefaultToolkit().beep();
						Thread.sleep(5000);
					} catch (Exception e) {

					}
			}
		}.start();
	}
}
