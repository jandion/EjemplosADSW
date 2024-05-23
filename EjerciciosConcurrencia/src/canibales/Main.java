package canibales;

public class Main {

	
	public static void main(String[] args) {
		Marmita m = new Marmita();
		Cocinero c = new Cocinero(m);
		c.start();
		
		new Canibal(m).start();
		new Canibal(m).start();
		new Canibal(m).start();
		new Canibal(m).start();
		new Canibal(m).start();
	}
}
