import java.util.Arrays;

public class PruebasOrdenacion {

	
	public static void main(String[] args) {
		int[] nums = GeneradorDatos.arrayEnteros(1000);
		imprimeArray(nums);
		Burbuja.sort(nums);
		imprimeArray(nums);
		
		System.out.println("Está el numero 100: "+ buscaNumero(nums, 100));
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void swap(String[] nombres, int i, int j) {
		String temp = nombres[i];
		nombres[i] = nombres[j];
		nombres[j] = temp;
	}
	
	
	public static void imprimeArray(int[] nums) {
		System.out.println(Arrays.toString(nums));
	}
	
	public static boolean buscaNumero(int[] nums, int buscado) {
		// como se hacía en prog
//		for (int i = 0; i < nums.length; i++) {
//			if (buscado == nums[i]) {
//				return true;
//			}
//		}
//		return false;
		
		// como lo hacemos ahora
		
		return busquedaBinaria(nums, buscado, 0, nums.length-1);
		
	}

	private static boolean busquedaBinaria(int[] nums, int buscado, int inferior, int superior) {
		// donde miramos?
		int pos = (superior+inferior)/2;
		
		if(superior == inferior+1 ) {
			return (nums[superior] == buscado) || (nums[inferior] == buscado);
		}
		
		if(nums[pos] == buscado) {
			return true;
		} else if( nums[pos] < buscado ) {
			//busco por la derecha
			int n_sup = superior;
			int n_inf = pos;
			return busquedaBinaria(nums, buscado, n_inf, n_sup);
		} else {
			//busco por la izquierda
			int n_sup = pos;
			int n_inf = inferior;
			return busquedaBinaria(nums, buscado, n_inf, n_sup);
		}
		
	}
}
