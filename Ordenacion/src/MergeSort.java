import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	
	public static void sort(int[] arr) {
		
		List<Integer> inicial = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			inicial.add(arr[i]);
		}
		
		List<Integer> resultado = sortInterno(inicial);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = resultado.get(i);
		}
		
	}

	private static List<Integer> sortInterno(List<Integer> inicial) {
		// dividir 
		// de una lista paso a tener 2
		List<Integer> izquierda= new ArrayList<Integer>(), derecha = new ArrayList<Integer>();
		if (inicial.size()==1) {
			//No puedo seguir dividiendo
			derecha.addAll(inicial);
			return derecha;
		} else {
			//Parto por la mitad
			izquierda = inicial.subList(0, inicial.size()/2);
			derecha = inicial.subList(inicial.size()/2, inicial.size());
			
		}
		
		// ordenar cada mitad
		izquierda = sortInterno(izquierda);
		derecha = sortInterno(derecha);
		
		// juntar
		List<Integer> resultado = new ArrayList<Integer>();
		while(!izquierda.isEmpty() && !derecha.isEmpty()) {
			if(izquierda.get(0) < derecha.get(0)) {
				resultado.add(izquierda.remove(0));
			} else {
				resultado.add(derecha.remove(0));
			}
		}
		// añadimos el resto
		resultado.addAll(izquierda);
		resultado.addAll(derecha);
		return resultado;
	}

}
