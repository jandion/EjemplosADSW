package tema2.diccionarios;

import java.util.Arrays;

public class DiccionarioArrayOrdenado implements Diccionario {

    private String[] keys;
    private String[] values;
    private int nStored;

    public DiccionarioArrayOrdenado(int size) {
        keys = new String[size];
        values = new String[size];
        nStored = 0;
    }

    @Override
    public void put(String key, String value) {
        //TODO: Cambiar la busqueda
        int pos = busquedaBinaria(key,0,nStored);
        int pos2 = Arrays.binarySearch(keys, 0, nStored, key);
        if(pos >= 0) {
            values[pos] = value;
        }
        if( nStored == values.length ) {
            System.err.println("El diccionario esta lleno");
            return;
        }
        for(int i = 0; i < nStored; i++ ) {
            if (keys[i].compareTo(key) > 0) {
                for (int j = nStored; j > i; j--) {
                    keys[j] = keys[j-1];
                    values[j] = values[j-1];
                }
                keys[i] = key;
                values[i] = value;
                nStored++;
                return;
            }
        }
    }

    @Override
    public String get(String key) {
        int pos = busquedaBinaria(key,0,nStored);
        if (pos>0){
            return values[pos];
        }
        return null;
    }

    @Override
    public String remove(String key) {

        //TODO: Cambiar la busqueda
        int pos = busquedaBinaria(key,0,nStored);
        if (pos>0){
            String ret = values[pos];
            // nos falta mover lo que haya despues!!
            for( int j = pos+1; j < nStored; j++ ) {
                keys[j-1] = keys[j];
                values[j-1] = values[j];
            }
            nStored--;
            return ret;
        }



        return null;
    }

    @Override
    public int size() {
        return nStored;
    }

    public int busquedaBinaria(String key, int inicio, int fin) {
        int medio = (inicio + fin) / 2;
        if (fin-inicio < 2) {
            if (key.equals(values[inicio])) {
                return inicio;
            } else if (key.equals(values[fin])) {
                return fin;
            }
            return -1;
        }
        if( key.equals(keys[medio]) ) {
            return medio;
        } else if( key.compareTo(keys[medio]) < 0 ) {
            return busquedaBinaria(key, inicio, medio);
        } else {
            return busquedaBinaria(key, medio+1, fin);
        }
    }

}
