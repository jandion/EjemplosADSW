package tema2.cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    
    
    public static void main(String[] args) {
        List<Carta> baraja = new ArrayList<>();
        for( Valor valor : Valor.values() ) {
            for( Palo palo : Palo.values() ) {
                baraja.add(new Carta(valor, palo));
            }
        }
        Collections.shuffle(baraja);
        for( Carta carta : baraja ) {
            System.out.println(carta);
        }
        
        
    }
}
