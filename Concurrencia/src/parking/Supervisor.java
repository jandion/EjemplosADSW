package parking;

public class Supervisor extends Thread {
	
	private Parking p;
	
	public Supervisor(Parking p) {
		this.p = p;
	}

	
	@Override
	public void run() {
		
		while(true) {
			try {
				System.out.println("Hay %d plazas ocupadas".formatted(p.ocupados()));
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
