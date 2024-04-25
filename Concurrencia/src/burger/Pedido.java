package burger;

public class Pedido {
	public static final String HAMBURGUESA = "🍔";
	public static final String PATATAS = "🍟";
	public static final int MAX_ITEMS = 4;
	

	public int hamburguesas, hamburguesasRecogidas;
	public int patatas, patatasRecogidas;
	public long creacion;
	
	public static Pedido pedidoAleatorio() {
		int nHamburguesas = (int) (1 + Math.random()*MAX_ITEMS);
		int nPatatas = (int) (Math.random()*MAX_ITEMS);
		return new Pedido(nHamburguesas, nPatatas);
	}
	
	public Pedido(int hamburguesas, int patatas) {
		this.hamburguesas = hamburguesas;
		this.patatas = patatas;
		this.creacion = System.currentTimeMillis();
	}

	@Override
	public String toString() {
		String res = "";//"----------------\n";
		res += "Creado hace %3s segs\n".formatted((System.currentTimeMillis()-creacion)/1000);
		//res += "----------------\n";
		res += "Hamburguesas: "+ HAMBURGUESA.repeat(hamburguesas) + "\n";
		res += "Recibidas:    "+ HAMBURGUESA.repeat(hamburguesasRecogidas) + "\n";
		//res += "----------------\n";
		res += "Patatas:      "+ PATATAS.repeat(patatas) + "\n";
		res += "Recibidas:    "+ PATATAS.repeat(patatasRecogidas);
		//res += "----------------\n";
		return res;
	}
}
