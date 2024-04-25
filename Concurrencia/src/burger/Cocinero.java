package burger;

public class Cocinero extends Thread {
	
	public Burger burger;
	public String nombre;
	public String producto;
	public int cantidad;
	
	public Cocinero(Burger burger, String nombre, String producto) {
		super();
		this.burger = burger;
		this.nombre = nombre;
		this.producto = producto;
	}

	@Override
	public void run() {
		while(true) {
			try {
				cantidad = burger.recibirOrden(producto);
				
				while(cantidad-- > 0) {
					sleep(400);
					burger.entregarProducto(producto);
				}
				
			} catch (Exception e) {
				
			}
		}
	}

}
