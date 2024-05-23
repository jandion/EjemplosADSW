package canibales;

public class Canibal extends Thread{

	private int id;
	private static int contador=0;
	private Marmita marmita;

	public Canibal(Marmita marmita) {
		this.marmita = marmita;
		this.id = ++contador;
	}

	@Override
	public void run() {
		while (true) {
			try {
				marmita.comer(id);
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
}
