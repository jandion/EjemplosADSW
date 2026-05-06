package g25.tema4;

public class MonitorContador {
	
	private int c;
	
	public synchronized int getContador() {
		return c;
	}
	
	public synchronized void incrementar() {
		c++;
	}

}
