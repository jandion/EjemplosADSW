package g21.tema4.productorConsumidor;

import java.util.ArrayList;
import java.util.List;

public class MonitorBuffer {
	
	public final int tamano = 3;
	private List<Integer> buffer;
	
	public MonitorBuffer() {
		buffer = new ArrayList<>();
	}
	
	public synchronized void guardarDato(int dato) throws InterruptedException {
		while(buffer.size()>= tamano) {
			wait();
		}
		buffer.add(dato);
		System.out.println("despues de añadir" + buffer);
		notifyAll();
	}
	
	public synchronized int sacarDato() throws InterruptedException{
		while(buffer.size()<=0) {
			wait();
		}

		System.out.println("antes de extraer" + buffer);
		int dato = buffer.remove(0);
		notifyAll();
		return dato;
	}
	
	public List<Integer> getBuffer(){
		return buffer;
	}
	
	

}
