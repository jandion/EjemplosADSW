package estanco;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Ingredientes ing = new Ingredientes();
		new Estanquero(ing).start();
		Thread.sleep(150);
		new Fumador("FumadorConTabaco", true, false, false, ing).start();
		new Fumador("FumadorConCerillas", false, true, false, ing).start();
		new Fumador("FumadorConPapel", false, false, true, ing).start();
	}
}
