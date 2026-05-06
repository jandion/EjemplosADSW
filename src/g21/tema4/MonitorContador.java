package g21.tema4;

public class MonitorContador {
	
	private int c;
	
	public synchronized int getContador() {
		return c;
	}
	
	public synchronized void incrementa() {
		c++;
	}

}
