package g21.tema4.fumadores;

public class Estanco {

	private boolean tabaco, papel, cerillas;

	public synchronized void avisarEstanquero() {
		notifyAll();
		System.out.println("Despertando al estanquero");
	}

	public synchronized void comprarIngredientes(String ingrediente) throws InterruptedException {
		if (ingrediente.equals("tabaco")) {
			while(!papel || !cerillas) { //!(papel && cerillas)
				wait();
			}
		} else if (ingrediente.equals("papel")) {
			while(!tabaco || !cerillas) {
				wait();
			}
		} else {
			while(!tabaco || !papel) {
				wait();
			}
		}
		System.out.println("El fumador con "+ ingrediente+" ha conseguido lo que le falta");
		papel=false;
		tabaco =false;
		cerillas = false;
	}

	public synchronized void esperarAQueMeAvisen() throws InterruptedException {
		System.out.println("El estanquero espera");
		wait();
		
	}

	public synchronized void ponerIngredientes() {
		
		int r = (int)(3 * Math.random());
		if (r == 0) {
			tabaco = false;
			papel = true;
			cerillas = true;
		} else if (r == 1) {
			tabaco = true;
			papel = false;
			cerillas = true;
		} else {
			tabaco = true;
			papel = true;
			cerillas = false;
		}
		notifyAll();
		System.out.println("Se han puesto ingredientes:");
		System.out.println("Tabaco: "+tabaco);
		System.out.println("Papel: "+papel);
		System.out.println("Cerillas: "+cerillas);
		
	}
}
