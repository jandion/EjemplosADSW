package canibales;

public class Cocinero extends Thread {
	
	private Marmita marmita;
	
	public Cocinero(Marmita marmita) {
		this.marmita = marmita;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				marmita.cocinar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}

}
