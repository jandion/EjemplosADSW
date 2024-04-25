
public class Pantalla {

	
	String mensaje = "";
	int caracteres = 0;
	
	synchronized void escribir( String token ) {
		mensaje = mensaje + token + " ";
		caracteres += token.length();
	}
	
	void imprimir() {
		System.out.println("El mensaje que aparece en la pantalla:");
		System.out.println(mensaje);
	}
}
