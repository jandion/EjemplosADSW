public class Prueba {

	public static void main(String[] args) throws InterruptedException {
		
		
		Pantalla p = new Pantalla();
		
		Escritor e1, e2;
		e1 = new Escritor("Cervantes", "En un lugar de la mancha", p);
		e2 = new Escritor("Bequer", "Volverán las oscuras golondrinas", p);
		
		e1.start();
		e2.start();
		
		e1.join();
		e2.join();
		
//		System.out.println("Hebras terminadas");
		p.imprimir();
		
		System.out.println(p.caracteres);
		
	}
}
