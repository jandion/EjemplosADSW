package g25.tema4;

public class PruebaContador {
	public static void main(String[] args) {
		Contador cont1 = new Contador("Contador 1");
		Contador cont2 = new Contador("Contador 2");
		Reloj reloj = new Reloj();
		
		//cont1.run(); nunca llamamos a run directamente
		cont1.start();
		cont2.start();
		Thread th = new Thread(reloj);
		th.start();
		
		try {
			cont1.join();
			cont2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hemos acabado de contar");
		System.out.println("El resultado final es "+Contador.c);
		System.exit(0);
	}
}
