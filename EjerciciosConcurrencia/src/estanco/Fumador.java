package estanco;

public class Fumador extends Thread {
	private String nombre;
	private boolean tabaco, cerillas, papel;
	private Ingredientes ing;
	
	public Fumador(String nombre, boolean tabaco, boolean cerillas, boolean papel, Ingredientes ing) {
		super();
		this.nombre = nombre;
		this.tabaco = tabaco;
		this.cerillas = cerillas;
		this.papel = papel;
		this.ing = ing;
	}


	@Override
	public void run() {
		while(true) {
			try {
				ing.cogerIngredientes(nombre, tabaco, cerillas, papel);
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
