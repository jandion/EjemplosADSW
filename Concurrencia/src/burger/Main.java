package burger;

/**
 * 1. Clientes recogen productos de 1 en 1
 * 2. Clientes recogen todo el pedido de golpe
 * 3. Se incorporan las patatas como segundo producto
 * 4. La bandeja de salida tiene un tamaño limitado
 */

public class Main {
	
	public static final String CLEAR = "\n".repeat(50);
	
	public static void main(String[] args) throws InterruptedException {
		
		Burger burger = new Burger();

		Cliente cliente1 = new Cliente(burger, "Cliente1");
		Cliente cliente2 = new Cliente(burger, "Cliente2");
		Cliente cliente3 = new Cliente(burger, "Cliente3");

		Cocinero cHamburguesas = new Cocinero(burger, 
				"CocineroHamburguesas", 
				Pedido.HAMBURGUESA);
		Cocinero cPatatas = new Cocinero(burger, 
				"CocineroPatatas", 
				Pedido.PATATAS);
		
		
		cliente1.start();
		cliente2.start();
		cliente3.start();
		cHamburguesas.start();
		cPatatas.start();
		
		
		while(true) {
			System.out.println(CLEAR);
			System.out.println("Hamburguesas preparadas: "+Pedido.HAMBURGUESA.repeat(burger.getHamburguesasPreparadas()));
			System.out.println("Patatas preparadas: "+Pedido.PATATAS.repeat(burger.getPatatasPreparadas()));
			//System.out.println("Cliente: %s".formatted(cliente1.nombre));
			System.out.println(cliente1.pedido);
			//System.out.println("Cliente: %s".formatted(cliente2.nombre));
			System.out.println(cliente2.pedido);
			//System.out.println("Cliente: %s".formatted(cliente3.nombre));
			System.out.println(cliente3.pedido);
			Thread.sleep(1000);
			
		}

	}
}
