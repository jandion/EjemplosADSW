package tema3.burger;

public class Cliente extends Thread {
    public Restaurante restaurante;
    public String nombre;
    public Pedido pedido;

    public Cliente(Restaurante restaurante, String nombre) {
        super();
        this.restaurante = restaurante;
        this.nombre = nombre;
        this.pedido = Pedido.pedidoAleatorio();
    }

    @Override
    public void run() {
        try {
            while (true) {

                restaurante.hacerPedido(pedido.hamburguesas, pedido.patatas);
                restaurante.recogerPedido(pedido);
                //restaurante.recogerPedidoCompleto(pedido);

                this.pedido = Pedido.pedidoAleatorio();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
