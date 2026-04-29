package g21.tema4;

public class PruebaContador {


	public static void main(String[] args) {
		Contador c1 = new Contador("Cont1");
		Contador c2 = new Contador("Cont2");

		Reloj reloj = new Reloj();

		//reloj.run();
		Thread th = new Thread(reloj);
		th.start();

		Runnable objRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000); 
					System.out.println("Reloj2:" + new java.util.Date().toString());
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}

		};
		Thread th2 = new Thread(objRunnable);
		th2.start();

		//c1.run(); esto nunca
		c1.start();
		c2.start();

		try {
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Los contadores han terminado!");
		//System.out.println("El contador vale "+ Contador.c);
		System.exit(0);
	}
}
