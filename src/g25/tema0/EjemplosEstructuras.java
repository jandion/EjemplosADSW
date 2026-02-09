package g25.tema0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjemplosEstructuras {
	public static void main(String[] args) {
		List<Character> myList = new ArrayList<>();
		
		myList.add('h');
		myList.add('o');
		
		myList.add(1,'_');
		
		try {
			metodoPeligroso();
			
			//myList.add(10,'!');
		} catch( Exception e) {
			System.out.println("hay algo raro");
		}
		System.out.println(myList);
		
		
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		
		nums.remove((Integer) 3);
		System.out.println(nums);
		
		System.out.println(fib(500));
		
	}
	
	public static int metodoPeligroso() throws Exception {
		if (Math.random()>0.5) {
			throw new Exception("aleatorio por encima de 0.5");
		}
		return 0;
	}
	
	
	public static int factorial(int n) {
		if(n <= 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	static Map<Integer,Integer> cache = new HashMap();
	
	public static int fib(int n) {
		if(n <= 1) {
			return 1;
		}
		if (n==2) { 
			return 1;
		}
		if (!cache.containsKey(n)) {
			int f = fib(n-1)+fib(n-2);
			cache.put(n, f);
			return f;
		}
		return cache.get(n);
	}
}
