package tema3.burger;

public class Restaurante {

    public static final int TAMANO_BANDEJA_SALIDA = 200;
    private int pedidosDeHamburguesas = 0;
    private int pedidosDePatatas = 0;

    private Integer hamburguesasPreparadas = 0;
    private Integer patatasPreparadas = 0;

    synchronized void hacerPedido(int hamburguesas, int patatas) {
        pedidosDeHamburguesas += hamburguesas;
        pedidosDePatatas += patatas;
        notifyAll();
    }

    synchronized int recibirOrden(String producto) throws InterruptedException {
        if(producto.equals(Pedido.HAMBURGUESA)) {
            // si no hay hamburguesas pedidas, espero
            while(pedidosDeHamburguesas == 0) {
                wait();
            }
            int temp = pedidosDeHamburguesas;
            pedidosDeHamburguesas = 0;
            return temp;

        } else {
            while(pedidosDePatatas == 0) {
                wait();
            }
            int temp = pedidosDePatatas;
            pedidosDePatatas = 0;
            return temp;
        }
    }

    synchronized void entregarProducto(String producto) throws InterruptedException {
        while (hamburguesasPreparadas + patatasPreparadas >= TAMANO_BANDEJA_SALIDA) {
            wait();
        }

        if(producto.equals(Pedido.HAMBURGUESA)) {
            hamburguesasPreparadas++;
        } else {
            patatasPreparadas++;
        }
        notifyAll();
    }

    synchronized void recogerPedido(Pedido pedido) throws InterruptedException {
        while( !pedido.completado() ) {
            if( pedido.hamburguesas != pedido.hamburguesasRecogidas && hamburguesasPreparadas > 0 ) {
                hamburguesasPreparadas--;
                pedido.hamburguesasRecogidas++;
            } else if( pedido.patatas != pedido.patatasRecogidas && patatasPreparadas > 0 ) {
                patatasPreparadas--;
                pedido.patatasRecogidas++;
            } else {
                wait();
            }
        }

        notifyAll();
    }

    synchronized void recogerPedidoCompleto(Pedido pedido) throws InterruptedException {
        while( !pedido.completado() ) {
            if( hamburguesasPreparadas >= pedido.hamburguesas && patatasPreparadas >= pedido.patatas) {
                pedido.hamburguesasRecogidas = pedido.hamburguesas;
                hamburguesasPreparadas -= pedido.hamburguesas;
                pedido.patatasRecogidas = pedido.patatas;
                patatasPreparadas -= pedido.patatas;
            } else {
                wait();
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
