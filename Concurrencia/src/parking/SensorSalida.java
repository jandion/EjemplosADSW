package parking;


public class SensorSalida implements Runnable{

	private String id;
	private Parking p;

	public SensorSalida(String id, Parking p) {
		this.id = id;
		this.p = p;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(p.ocupados()>0){
					p.sale(id);
				}
				Thread.sleep((long) (Math.random()*5000));
			} catch (Exception e) {
			}
		}

	}

}
