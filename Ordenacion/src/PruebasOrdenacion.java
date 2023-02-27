import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PruebasOrdenacion {

	public static void main(String args[]) {
		List<Carta> baraja = new ArrayList<>();
		String[] palos = {"Diamantes", "Corazones", "Tréboles", "Picas"};
		for (int i = 1; i < 14; i++) {
			for( String palo : palos)
				baraja.add(new Carta(palo, i));
		}
		Collections.shuffle(baraja);
		
		System.out.println(baraja);
		Collections.sort(baraja);
		System.out.println(baraja);
	}

	public static void burbuja(int[] arr) {
		for( int j = arr.length-2; j >= 0; j-- ) {
			for (int i = 0; i <= j; i++) {
				if (arr[i] > arr[i+1]) swap(arr, i, i+1);
				for (int k : arr) {
					System.out.print(k);
					System.out.print( " ");
				}
				System.out.println();
			}
		}
	}
	public static void seleccion(int[] arr) {
		for( int j = 0; j < arr.length; j ++) {
			int min_i = j;
			for (int i = j; i < arr.length; i++) {
				if (arr[i] < arr[min_i]) min_i = i;
			}
			//lo colocamos en la primera posicion
			swap(arr, j, min_i);
		}

	}
	private static void swap(int[] arr, int i, int min_i) {
		int valor = arr[min_i];
		arr[min_i] = arr[i];
		arr[i] = valor;

	}

	public static void insrerccion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int valor = arr[i];
			//buscamos donde encaja
			for(int j = 0; j < i; j++) {
				// buscamos el que sea mayor que lo que hemos guardado
				if (arr[j] > valor)
				{
					// empujamos lo que hay desde j un espacio a la derecha
					System.arraycopy(arr, j, arr, j+1, i-j);
					arr[j] = valor;
					break;
				}
			}
		}
	}

}
