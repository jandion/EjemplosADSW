import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjemplosComplejidad {

	public static void main(String[] args) {

		int N = 10000;

		int[][] numeros = new int[N][N];
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				numeros[i][j]=(int)(Math.random()*N*10);
			}
		}
		long t = System.currentTimeMillis();
		int k =N;
		//algoritmo
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(numeros[i][j] == k) {
					System.out.println("Encontrado");
					break;
				}
			}
		}

		System.out.println(System.currentTimeMillis()-t);
	}
}
