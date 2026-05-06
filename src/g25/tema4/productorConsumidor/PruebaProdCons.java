package g25.tema4.productorConsumidor;

public class PruebaProdCons {
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer();

		for(int i = 0; i < 3; i++)
			new Productor(buffer).start();
		for(int i = 0; i < 2; i++)
			new Consumidor(buffer).start();
	}

}
