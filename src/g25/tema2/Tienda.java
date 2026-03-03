package g25.tema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tienda {
	

	public static void main(String[] args) {

		// Clientes
		Diccionario clientes = new DiccionarioHash();
		
		for(int i = 0; i < 30; i++) {
			String clave = String.format("%04d", i);
			List<String> valor = generarListaSuper();// carrito
			clientes.put(clave, valor);
		}
		
		// buscamos el 42
		String claveBuscada = "0042";
		
		
		boolean encontrado = clientes.contains(claveBuscada);
		
		// actualizar
		if (encontrado) {
			System.out.println("Lo encontré, le añado una patata");
			clientes.get(claveBuscada).add("🥔");
		} else {
			System.out.println("El cliente "+ claveBuscada+ " no está");
		}
		
		// eliminar O(n)
		
		// añadir O(1)
		clientes.put("1000", new ArrayList<String>());

		
		
	}
	
	
	 public static List<String> generarListaSuper() {
	        String[] productos = {
	            "🍎", // manzana
	            "🍌", // banana
	            "🍞", // pan
	            "🥛", // leche
	            "🧀", // queso
	            "🥚", // huevos
	            "🍗", // pollo
	            "🥩", // carne
	            "🍅", // tomate
	            "🥕", // zanahoria
	            "🍪", // galletas
	            "🍫", // chocolate
	            "🧃", // jugo
	            "🥤", // refresco
	            "🍚", // arroz
	            "🍝", // pasta
	            "🧂", // sal
	            "🥔", // papa
	            "🍇", // uvas
	            "🍓"  // frutillas
	        };

	        Random random = new Random();
	        int cantidad = random.nextInt(20) + 1; // entre 1 y 20

	        List<String> lista = new ArrayList<>();

	        for (int i = 0; i < cantidad; i++) {
	            int indice = random.nextInt(productos.length);
	            lista.add(productos[indice]);
	        }

	        return lista;
	    }
}
