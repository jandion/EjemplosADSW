package tema2.diccionarios;

public class DiccionarioArrayHash implements Diccionario{
    private String[] keys;
    private String[] values;
    private int nElems;

    public static void main(String[] args) {
        DiccionarioArrayHash diccionario = new DiccionarioArrayHash(100);
        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");
        diccionario.put("monja", "hola");

        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");

        diccionario.put("mesa", "232435");


        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");

        diccionario.put("jamon", "mundo");
        diccionario.put("nomja", "!");

        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");
    }

    public DiccionarioArrayHash(int size){
        keys = new String[size];
        values = new String[size];

    }

    @Override
    public void put(String key, String value) {
        int pos = getPos(key);
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
        int pos = getPos(key);
        return values[pos];
    }

    @Override
    public String remove(String key) {
        int pos = getPos(key);
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

    public int hash(int i) {
        return Integer.hashCode(i) % keys.length;
    }

    public int getPos2(String key){
        int pos = hash(key);
        for  (int j = 0; j < keys.length; j++) {
            int i = (pos + j) % keys.length;
            if (keys[i] == null) {
                return i;
            }
            if(keys[i].equals(key)) {
                return i;
            }
        }
        throw new RuntimeException("No he encontrado hueco");
    }
    public int getPos(String key){
        int pos = hash(key);
        int intentos = 0;
        while(keys[pos] != null && !keys[pos].equals(key)) {
            pos = hash(pos);
            intentos++;
            if(intentos >= keys.length) {
                throw new RuntimeException("No he encontrado hueco");
            }
        }
        return pos;
    }

    public void imprimir(){
        for(int i = 0; i < keys.length; i++){
            System.out.print("Pos" + i + " ");
            System.out.print(keys[i] + " ");
            System.out.println(values[i] + " ");
        }
    }
}
