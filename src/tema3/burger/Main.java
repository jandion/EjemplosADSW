package tema3.burger;


/**
 * 1. Clientes recogen productos de 1 en 1
 * 2. Clientes recogen todo el pedido de golpe
 * 3. La bandeja de salida tiene un tamaño limitado
 */

public class Main {

    public static final String CLEAR = "\n".repeat(50);

    public static void main(String[] args) throws InterruptedException {

        Restaurante restaurante = new Restaurante();

        Cliente cliente1 = new Cliente(restaurante, "Cliente1");
        Cliente cliente2 = new Cliente(restaurante, "Cliente2");
        Cliente cliente3 = new Cliente(restaurante, "Cliente3");
        Cliente cliente4 = new Cliente(restaurante, "Cliente4");
        cliente4.pedido = new Pedido(0, 10);

        Cocinero cHamburguesas = new Cocinero(restaurante,"CocineroHamburguesas", Pedido.HAMBURGUESA);
        Cocinero cPatatas = new Cocinero(restaurante,"CocineroPatatas",Pedido.PATATAS);


        cliente1.start();
        cliente2.start();
        cliente3.start();
        //cliente4.start();
        cHamburguesas.start();
        cPatatas.start();


        while(true) {
            System.out.println(CLEAR);
            System.out.flush();
            System.out.println("Hamburguesas preparadas: "+Pedido.HAMBURGUESA.repeat(restaurante.getHamburguesasPreparadas()));
            System.out.println("Patatas preparadas: "+Pedido.PATATAS.repeat(restaurante.getPatatasPreparadas()));
            System.out.printf("Cliente: %s%n", cliente1.nombre);
            System.out.println(cliente1.pedido);
            System.out.printf("Cliente: %s%n", cliente2.nombre);
            System.out.println(cliente2.pedido);
            System.out.printf("Cliente: %s%n", cliente3.nombre);
            System.out.println(cliente3.pedido);
            //System.out.printf("Cliente: %s%n", cliente4.nombre);
            //System.out.println(cliente4.pedido);
            Thread.sleep(1000);

        }

    }
}