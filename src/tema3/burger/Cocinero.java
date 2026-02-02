package tema3.burger;

public class Cocinero extends Thread {

    public Restaurante restaurante;
    public String nombre;
    public String producto;
    public int cantidad;

    public Cocinero(Restaurante restaurante, String nombre, String producto) {
        super();
        this.restaurante = restaurante;
        this.nombre = nombre;
        this.producto = producto;
    }

    @Override
    public void run() {
        while(true) {
            try {
                cantidad = restaurante.recibirOrden(producto);

                while(cantidad-- > 0) {
                    sleep(1000);
                    restaurante.entregarProducto(producto);
                }

            } catch (Exception e) {

            }
        }
    }
}
