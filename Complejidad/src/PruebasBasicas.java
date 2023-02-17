import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PruebasBasicas {

	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<>();
		int n = 20000;
		for (int i = 0; i < n; i++) {
			nums.add(i);
		}
		Collections.shuffle(nums);


		long t0, t1;
		System.out.println("Para " + n + " elementos");
		// algoritmo 1
		t0 = System.currentTimeMillis();

		System.out.println(nums.get(0));

		t1 = System.currentTimeMillis();

		System.out.println("Algo1 ha tardado "+(t1-t0));

		// algoritmo 2
		int min = Integer.MAX_VALUE;

		t0 = System.currentTimeMillis();

		for (int numero : nums) {
			if ( numero < min ) min = numero;
		}

		System.out.println(min);

		t1 = System.currentTimeMillis();

		System.out.println("Algo2 ha tardado "+(t1-t0));

		// algo 3

		int [][] nums2 = new int[n][n];
		
		for (int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums2[i].length; j++) {
				nums2[i][j] = (int) Math.random()*1000;
			}
		}
		
		t0 = System.currentTimeMillis();
		min = Integer.MAX_VALUE;
		for (int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums2[i].length; j++) {
				if (nums2[i][j] < min) 
					min = nums2[i][j] = min;
			}
		}
		System.out.println(min);
		t1 = System.currentTimeMillis();

		System.out.println("Algo3 ha tardado "+(t1-t0));
	}

}
