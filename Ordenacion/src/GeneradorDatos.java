import java.util.Arrays;
import java.util.Random;

public class GeneradorDatos {
	
	private static Random r = new Random(23);

	
	public static void main(String[] args) {
		int[] nums = arrayEnteros(10);
		System.out.println(Arrays.toString(nums));
	}
	
	public static int[] arrayEnteros(int l) {
		int[] arr = new int[l];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
		return arr;
	}
}
