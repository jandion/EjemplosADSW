package tema2.diccionarios;

public class Nodo {
    String key;
    String value;
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;
    public Nodo(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
