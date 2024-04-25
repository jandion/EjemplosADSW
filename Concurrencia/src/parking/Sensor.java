package parking;

public class Sensor implements Runnable{

	private String id;
	private Parking p;

	public Sensor(String id, Parking p) {
		this.id = id;
		this.p = p;
	}

	@Override
	public void run() {
		while(true) {
			try {
				boolean entrada = Math.random()>0.25;
				if(entrada) {
					p.entra(id);
				} else if(p.ocupados()>0){
					p.sale(id);
				}
				Thread.sleep((long) (Math.random()*500));
			} catch (Exception e) {
			}
		}

	}

}
