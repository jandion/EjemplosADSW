package g21.tema2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tienda {
	// col Clientes, carro de la compra

	static Diccionario clientes;

	// ids de los clientes
	// carritos de la compra

	public static void main(String[] args) {

		String id = "0000";
		List<String> carrito = new ArrayList<>();
		carrito.add("comida");
		carrito.add("productos limpieza");

		ClaveValor<String, List<String>> cliente = new ClaveValor<>(id, carrito);

		clientes = new DiccionarioConLista();

		for( int i = 1; i< 100; i++) {
			String idCliente = "00" + i;
			// usar el format
			List<String> carritoCliente = getCartItems();
			clientes.put(idCliente, carritoCliente);
		}

		//for( ClaveValor cv : clientes) {
		//	System.out.println(cv);
		//}

		//Collections.shuffle(clientes);

		//clientes = clientes.subList(0, 60);

		String claveBuscada = "0033";
		boolean encontrado = clientes.contains(claveBuscada);	

		if (encontrado) {
			System.out.println("El 0033 está todavía en la tienda");

			List<String> carritoCliente = clientes.get(claveBuscada);
			System.out.println("Este es su carrito y le añado RAM");
			carritoCliente.add("RAM");
			System.out.println(carritoCliente);

		} else {
			System.out.println("Ya se habrá ido");
		}
	}

	public static List<String> getCartItems() {
		List<String> pool = Arrays.asList(
				"Smartphone", "Laptop", "Monitor 4K", "Teclado Mecánico", "Ratón Ergonómico",
				"Auriculares ANC", "Cargador USB-C", "Disco SSD 1TB", "Memoria RAM 16GB", "GPU RTX 4080",
				"Cable HDMI 2.1", "Webcam 1080p", "Soporte Portátil", "Alfombrilla XL", "Hub USB-A",
				"Router Wi-Fi 6", "Smartwatch", "Tablet", "Batería Externa", "Caja PC ATX"
				);

		Collections.shuffle(pool);

		Random random = new Random();
		int size = random.nextInt(13) + 3; // Rango [3, 15]

		return new ArrayList<>(pool.subList(0, size));
	}
}
