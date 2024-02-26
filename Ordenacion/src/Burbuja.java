
public class Burbuja {
	
	public static void sort(int[] nums) {
		int contador = 0;
		boolean haySwap = true;
		while(haySwap) {
			haySwap = false;
			// lo de la burbuja
			//recorremos el array
			for (int i = 1; i < nums.length; i++) {
				// comprobamos si estan desordenados
				contador ++;
				if (nums[i-1] > nums[i]) { // TODO: y si fueran String
					// detectamos que no están ordenados
					PruebasOrdenacion.swap(nums, i-1, i);
					haySwap = true;
				}
			}
		}
		System.out.println("he ordenado con "+ contador+" comparaciones");
	}
}
