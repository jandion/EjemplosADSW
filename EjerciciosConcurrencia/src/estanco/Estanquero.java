package estanco;

public class Estanquero extends Thread{

	private boolean tabaco = false, cerillas = false, papel = false;
	private Ingredientes ing;
	
	Estanquero(Ingredientes ing){
		this.ing = ing;
	}
	
	
	void ponerIngredientes() {
		double d = Math.random();
		if( d < 1.0/3) {
			tabaco = true;
			cerillas =  true;
			papel = false;
		} else if (d < 2.0/3) {
			tabaco = true;
			cerillas =  false;
			papel = true;
		} else {
			tabaco = false;
			cerillas =  true;
			papel = true;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			ponerIngredientes();
			try {
				ing.ponerIngredientes(tabaco, cerillas, papel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
