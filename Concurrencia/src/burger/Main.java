package burger;

/**
 * 1. Clientes recogen productos de 1 en 1
 * 2. Clientes recogen todo el pedido de golpe
 * 3. Se incorporan las patatas como segundo producto
 * 4. La bandeja de salida tiene un tamaño limitado
 */

public class Main {
	
	public static final String CLEAR = "\n".repeat(50);
	
	public static void main(String[] args) {
		
		Pedido pedido = Pedido.pedidoAleatorio();
		
		System.out.println(pedido);
		
		pedido.hamburguesasRecogidas++;
		System.out.println(CLEAR);
		System.out.println(pedido);

	}
}
