import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MyQueue  {
	private List<Integer> queue;
	private int capacity;
	static final Logger elLogger = Logger.getLogger(MyQueue.class.getName());

	public MyQueue(int capacity) {
		this.capacity = capacity;
		queue = new ArrayList<Integer>();
		elLogger.setLevel(Level.WARNING);
		elLogger.info("Se ha creado una cola");
	}
	
	public void add(int valor) {
		//TODO: que pasa cuando la cola esta llena
		if (capacity == queue.size()) {
			elLogger.warning("se ha intentado añadir un valor a una cola llena");
			return;
		}
		elLogger.warning("se ha añadido el elemento "+valor);
		elLogger.info("Ahora la cola tiene "+ queue.size()+ " elementos");
		queue.add(valor);
	}
	
	public Integer poll() {
		if(queue.size()==0) return null;
		elLogger.warning("Estamos sacando el primer elemento");
		elLogger.info("El primer elemento es: "+queue.get(0));
		return queue.remove(0);
	}
	
	public Integer peek() {
		if(queue.size()==0) return null;
		elLogger.warning("Estamos consultando el primer elemento");
		elLogger.info("El primer elemento es: "+queue.get(0));
		
		
		return queue.get(0);
	}

	public int size() {
		elLogger.warning("Estamos consultando el tamaño");
		return queue.size();
	}

	@Override
	public String toString() {
		return "MyQueue [queue=" + queue + ", capacity=" + capacity + "]";
	}
	
	
}
