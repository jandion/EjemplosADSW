import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PruebasOrdenacion {

	public static void main(String args[]) {
		List<Integer> nums = new ArrayList<Integer>();
		List<Carta> baraja = new ArrayList<>();
		String[] palos = {"Diamantes"};//, "Corazones", "Tréboles", "Picas"};
		for (int i = 1; i < 14; i++) {
			//for( String palo : palos)
			//	baraja.add(new Carta(palo, i));
			nums.add(i);
		}
		Collections.shuffle(nums);
		
		System.out.println(nums);
		mergeSort(nums);
		System.out.println(nums);
		
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
	
	public static void mergeSort(List<Integer> nums) {
		
		if(nums.size()==1) return;
		
		//dividir
		Division d = dividirEn2(nums);

		List<Integer> izq = d.izq;
		List<Integer> dcha = d.dcha;
		
		//Ordenamos las dos mitades
		mergeSort(izq);
		mergeSort(dcha);
		
		List<Integer> sol = new ArrayList<>();
		
		while(!(izq.isEmpty() || dcha.isEmpty())) {
//			if( izq.isEmpty()) {
//				sol.add(dcha.remove(0));
//			} else if (dcha.isEmpty()) {
//				sol.add(izq.remove(0));
//			}
//			else
				if (izq.get(0) < dcha.get(0)) {
				sol.add(izq.remove(0));
			} else {
				sol.add(dcha.remove(0));
			}
		}
		sol.addAll(dcha);
		sol.addAll(izq);
		
		nums.clear();
		nums.addAll(sol);
		
	}

	private static Division dividirEn2(List<Integer> nums) {
		List<Integer> l1 = new ArrayList();
		List<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < nums.size()/2; i++) {
			l1.add(nums.get(i));
		}
		for (int i = nums.size()/2; i < nums.size(); i++) {
			l2.add(nums.get(i));
		}
		return new Division(l1, l2);
	}
	
	
	

}

class Division{
	List<Integer> izq;
	List<Integer> dcha;
	public Division(	List<Integer> izq,	List<Integer> dcha) {
		this.izq = izq;
		this.dcha = dcha;
	}
}
