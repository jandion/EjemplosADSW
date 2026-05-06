package g21.tema4.productorConsumidor;

public class PruebaConsumidorProductor {
	
	public static void main(String[] args) {
		MonitorBuffer monitor = new MonitorBuffer();
		
		for(int i = 0; i< 3 ; i++) {
			new Productor(monitor, "Productor"+i).start();
		}
		
		for(int i = 0; i< 5; i++) {
			new Consumidor(monitor, "Consumidor"+i).start();
		}
	}

}
