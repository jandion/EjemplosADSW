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

        Carta[] mano = new Carta[20];
        List<Carta> manoList = new ArrayList<>();
        for( int i = 0; i < mano.length; i++ ) {
            mano[i] = baraja.get(i);
            manoList.add(mano[i]);
        }

        System.out.println("La mano es ");
        for( Carta carta : mano ) {
            System.out.print(carta + " ");
        }
        System.out.println();
        manoList = mergeSort(manoList);
        for( Carta carta : manoList ) {
            System.out.print(carta + " ");
        }
        System.out.println();
        /*
        for(int i = 0; i < mano.length; i++) {                  // n veces
            System.out.println("Colocando la posicion "+ i);    // O(1)
            Carta minima = mano[i];                             // O(1)
            int posMinima = i;                                  // O(1)
            for( int j = i; j < mano.length; j++ ) {            // n, n-1, n-2, ...
                Carta pos = mano[j];                            // O(1)
                if (pos.compareTo(minima) < 0) {                // 2 * O(1)
                    minima = pos;
                    posMinima = j;
                } else {
                }
            }
            swap(mano, i, posMinima);                           // O(swap)
            System.out.println("La mano es ");                  // O(1)
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

        */
    }

    public static void swap(Carta[] arr, int i, int j){
        Carta temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<Carta> mergeSort(List<Carta> mano){
        // Paso 1: si la lista tiene un solo elemento la devuelvo
        if (mano.size() == 1) {
            return mano;
        }
        // Paso 2: si no, la parto por la mitad y llamo recursivamente
        // me guardo lo que me devuelvan en lIzq y lDcha
        int mitad = mano.size() / 2;
        List<Carta> lIzq = new ArrayList<>();
        List<Carta> lDer = new ArrayList<>();
        for (int i = 0; i < mano.size(); i++) {
            if (i < mitad) {
                lIzq.add(mano.get(i));
            } else {
                lDer.add(mano.get(i));
            }
        }
        lIzq  = mergeSort(lIzq);
        lDer  = mergeSort(lDer);
        // Paso 3: creo una lista vac�a
        List<Carta> lResult = new ArrayList<>();
        // Paso 4: mezclo lIzq y lDcha en la nueva lista, sacando siempre el menor
        while (!lIzq.isEmpty() && !lDer.isEmpty()) {
            if (lIzq.get(0).compareTo(lDer.get(0)) < 0) {
                lResult.add(lIzq.remove(0));
            } else {
                lResult.add(lDer.remove(0));
            }
        }
        lResult.addAll(lIzq);
        lResult.addAll(lDer);
        // Paso 5: devuelvo la lista
        return lResult;
    }
}
