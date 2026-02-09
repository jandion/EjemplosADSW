package g21.tema0;

import java.util.ArrayList;
import java.util.List;

public class EjemplosEstructuras {

	
	public static void main(String[] args) {
		List<Character> caracteres = new ArrayList();
		caracteres.add('h');
		caracteres.add('o');
		caracteres.add(0, '¡');
		
		
		caracteres.set(0, ' ');
		
		System.out.println(caracteres);
	}
}
