package tema2.diccionarios;

public class DiccionarioArrayHash implements Diccionario{
    private String[] keys;
    private String[] values;
    private int nElems;

    public static void main(String[] args) {
        DiccionarioArrayHash diccionario = new DiccionarioArrayHash(10);
        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");
        diccionario.put("monja", "sjdhfdslk");

        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");

        diccionario.put("mesa", "232435");


        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");

        diccionario.put("jamon", "sjdhfdslk");

        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");
    }

    public DiccionarioArrayHash(int size){
        keys = new String[size];
        values = new String[size];

    }

    @Override
    public void put(String key, String value) {
        int pos = hash(key);
        if (keys[pos] == null) {
            keys[pos] = key;
            values[pos] = value;
            nElems++;
        } else {
            if (!keys[pos].equals(key)) {
                System.err.println("Colision!");
            }
            keys[pos] = key;
            values[pos] = value;
        }
    }

    @Override
    public String get(String key) {
        int pos = hash(key);
        return values[pos];
    }

    @Override
    public String remove(String key) {
        int pos = hash(key);
        if (keys[pos] != null) {
            nElems--;
        }
        String temp = values[pos];
        values[pos] = null;
        keys[pos] = null;

        return temp;
    }

    @Override
    public int size() {
        return nElems;
    }


    public int hash(String key){
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += (int) c;
        }
        hash = key.hashCode();
        return hash % keys.length;
    }

    public void imprimir(){
        for(int i = 0; i < keys.length; i++){
            System.out.print(keys[i] + " ");
            System.out.println(values[i] + " ");
        }
    }
}
