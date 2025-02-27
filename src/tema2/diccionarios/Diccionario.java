package tema2.diccionarios;

public interface Diccionario {

    public void put(String key, String value);
    public String get(String key);
    public String remove(String key);
    public int size();
}
