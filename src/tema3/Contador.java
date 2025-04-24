package tema3;

public class Contador implements Runnable {
    public static void main(String[] args) {

        Thread c1 = new Thread(new Contador("C1"));
        Thread c2 = new Thread(new Contador("C2"));

        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Contador.contador);
    }

    @Override
    public void run() {
        for (int i =0; i < 100; i++){
            int valorActual = contador;
            valorActual++;
            try {
                Thread.sleep((long) Math.random() * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contador = valorActual;
            //System.out.println(nombre+": "+getValor());

        }
    }

    private static int contador = 0;
    private String nombre;
    public Contador(String nombre){
        this.nombre = nombre;
    }
    public void incrementar() {
        contador++;
    }
    public int getValor() {
        return contador;
    }
}
