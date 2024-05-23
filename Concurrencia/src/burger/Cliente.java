package burger;

public class Cliente extends Thread {
	
	
	public Burger burger;
	public String nombre;
	public Pedido pedido;
	
	public Cliente(Burger burger, String nombre) {
		super();
		this.burger = burger;
		this.nombre = nombre;
		this.pedido = Pedido.pedidoAleatorio();
	}

	@Override
	public void run() {
		
		while(true) {
			this.pedido = Pedido.pedidoAleatorio();
			
			burger.hacerPedido(pedido.hamburguesas, pedido.patatas);
			burger.recogerPedido(pedido);
		}
	}

}
