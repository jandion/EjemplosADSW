package g25.tema4.productorConsumidor;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

	public static final int TAMANO = 10;
	private List<Integer> buffer= new ArrayList<>();
	
	
	public synchronized void guardarDato(int dato) throws InterruptedException {
		while(buffer.size()>= TAMANO) {
			wait();
		}
		buffer.add(dato);
		notifyAll();
		System.out.println("Se ha añadido un dato: "+ buffer);
	}
	
	public synchronized int sacarDato() throws InterruptedException {
		while(buffer.isEmpty()) {
			wait();
		}
		int dato = buffer.remove(0);
		notifyAll();
		System.out.println("Se ha eliminado un dato: "+ buffer);
		return dato;
	}
	
	public synchronized List<Integer> getBuffer(){
		return buffer;
	}
}
