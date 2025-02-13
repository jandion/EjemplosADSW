package tema2.cartas;

import java.util.*;

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
            System.out.print(carta + " ");
        }
        System.out.println();

        Carta[] mano = new Carta[10];
        for( int i = 0; i < mano.length; i++ ) {
            mano[i] = baraja.get(i);
        }

        System.out.println("La mano es ");
        for( Carta carta : mano ) {
            System.out.print(carta + " ");
        }
        System.out.println();
        for(int i = 0; i < mano.length; i++) {
            System.out.println("Colocando la posicion "+ i);
            Carta minima = mano[i];
            int posMinima = i;
            for( int j = i; j < mano.length; j++ ) {
                Carta pos = mano[j];
                if (pos.compareTo(minima) < 0) {
                    minima = pos;
                    posMinima = j;
                }
            }
            swap(mano, i, posMinima);
            System.out.println("La mano es ");
            for( Carta carta : mano ) {
                System.out.print(carta + " ");
            }
            System.out.println();
        }

        Arrays.sort(mano, new Comparator<Carta>() {
                    @Override
                    public int compare(Carta cartaA, Carta cartaB) {
                        return 0;
                    }
                }
        );
        System.out.println("La mano es ");
        for( Carta carta : mano ) {
            System.out.print(carta + " ");
        }

        
    }

    public static void swap(Carta[] arr, int i, int j){
        Carta temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
