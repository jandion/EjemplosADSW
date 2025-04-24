package tema2.diccionarios;

public class DiccionarioArray implements Diccionario {

    private String[] keys;
    private String[] values;
    private int nStored;

    public DiccionarioArray(int size) {
        keys = new String[size];
        values = new String[size];
        nStored = 0;
    }

    @Override
    public void put(String key, String value) {
        for( int i = 0; i < nStored; i++ ) {
            if( keys[i].equals(key) ) {
                values[i] = value;
                return;
            }
        }
        if( nStored == values.length ) {
            System.err.println("El diccionario esta lleno");
            return;
        }
        keys[nStored] = key;
        values[nStored] = value;
        nStored++;
    }

    @Override
    public String get(String key) {
        for( int i = 0; i < nStored; i++ ) {
            if( keys[i].equals(key) ) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public String remove(String key) {
        for( int i = 0; i < nStored; i++ ) {
            if( keys[i].equals(key) ) {
                //borrar y devolver
                keys[i] = null;
                String ret = values[i];
                values[i] = null;

                // nos falta mover lo que haya despues!!
                for( int j = i+1; j < nStored; j++ ) {
                    keys[j-1] = keys[j];
                    values[j-1] = values[j];
                }
                nStored--;
                return ret;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return nStored;
    }



}
