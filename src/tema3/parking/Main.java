package tema3.parking;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Supervisor parking = new Supervisor(5);
        List<Coche> coches = new ArrayList<Coche>();

        for(int i = 0; i < 10; i++) {
            Coche c = new Coche("Coche_" + i, parking);
            coches.add(c);
            c.start();
        }
        for(Coche c : coches) {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
