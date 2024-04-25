package burger;

public class Burger {

	public static final int TAMANO_BANDEJA_SALIDA = 5;
	private int pedidosDeHamburguesas = 0;
	private int pedidosDePatatas = 0;

	private int hamburguesasPreparadas = 0;
	private int patatasPreparadas = 0;

	synchronized void hacerPedido(int hamburguesas, int patatas) {
		pedidosDeHamburguesas += hamburguesas;
		pedidosDePatatas += patatas;
		notifyAll();
	}

	synchronized int recibirOrden(String producto) {
		if(producto.equals(Pedido.HAMBURGUESA)) {
			// si no hay hamburguesas pedidas, me duermo
			while(pedidosDeHamburguesas == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int temp = pedidosDeHamburguesas;
			pedidosDeHamburguesas = 0;
			return temp;

		} else {
			while(pedidosDePatatas == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int temp = pedidosDePatatas;
			pedidosDePatatas = 0;
			return temp;
		}
	}

	synchronized void entregarProducto(String producto) {
		while (hamburguesasPreparadas + patatasPreparadas >= TAMANO_BANDEJA_SALIDA) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(producto.equals(Pedido.HAMBURGUESA)) {
			hamburguesasPreparadas++;
		} else {
			patatasPreparadas++;
		}
		notifyAll();
	}

	synchronized void recogerPedido(Pedido pedido) {

		while( pedido.hamburguesas != pedido.hamburguesasRecogidas ||
				pedido.patatas != pedido.patatasRecogidas) { 
			if( pedido.hamburguesas != pedido.hamburguesasRecogidas && hamburguesasPreparadas > 0 ) {
				hamburguesasPreparadas--;
				pedido.hamburguesasRecogidas++;
			} else if( pedido.patatas != pedido.patatasRecogidas && patatasPreparadas > 0 ) {
				patatasPreparadas--;
				pedido.patatasRecogidas++;
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		notifyAll();
	}

	synchronized void recogerPedidoCompleto(Pedido pedido) {
		while( pedido.hamburguesas != pedido.hamburguesasRecogidas ||
				pedido.patatas != pedido.patatasRecogidas) {
			if( hamburguesasPreparadas >= pedido.hamburguesas &&
					patatasPreparadas >= pedido.patatas) {
				pedido.hamburguesasRecogidas = pedido.hamburguesas;
				hamburguesasPreparadas -= pedido.hamburguesas;
				pedido.patatasRecogidas = pedido.patatas;
				patatasPreparadas -= pedido.patatas;
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		notifyAll();
	}


	synchronized public int getPatatasPreparadas() {
		return patatasPreparadas;
	}
	synchronized public int getHamburguesasPreparadas() {
		return hamburguesasPreparadas;
	}

}
