package estanco;

public class Ingredientes {

	private boolean tabaco = false, cerillas = false, papel = false;
	
	synchronized void ponerIngredientes (boolean tabaco, 
			boolean cerillas, 
			boolean papel) throws Exception{
		
		while((this.tabaco || this.cerillas || this.papel)) {
			wait();
		}
		this.tabaco = tabaco;
		this.cerillas = cerillas;
		this.papel = papel;
//		System.out.println("Tabaco "+tabaco);
//		System.out.println("cerillas "+cerillas);
//		System.out.println("papel "+papel);
		notifyAll();
	}
	
	synchronized void cogerIngredientes(String nombre, boolean tabaco, 
			boolean cerillas, 
			boolean papel) throws InterruptedException {
		
		
		while( !((this.tabaco || tabaco) &&
				(this.papel || papel) &&
				(this.cerillas || cerillas))) {
			wait();
		}
		this.tabaco = false;
		this.cerillas = false;
		this.papel = false;
		System.out.println(nombre + " ha conseguido los ingredientes");
		notifyAll();
		
	}
	
}
