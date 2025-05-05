package tema3.parking;

public class Supervisor {

    private int plazasLibres;
     public Supervisor(int plazasLibres) {
         this.plazasLibres = plazasLibres;
     }

     synchronized public void entra(String id) throws InterruptedException {
         while(plazasLibres <= 0) {
             System.out.println("No quedan plazas libres: "+id);
             wait();
         }
         System.out.println("Entrando el coche " + id);
         plazasLibres--;
         System.out.println("Quedan " + plazasLibres);

     }

     public synchronized void sale(String id) {
         System.out.println("Sale el coche " + id);
         plazasLibres++;
         System.out.println("Quedan " + plazasLibres);
         notifyAll();
     }

     public int getPlazasLibres() {
         return plazasLibres;
     }
}
