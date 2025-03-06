package tema2.diccionarios;

public class DiccionarioBST implements Diccionario {

    Nodo root;

    @Override
    public void put(String key, String value) {
        if(root==null){
            root = new Nodo(key, value);
        } else{
            put(root,key,value);
        }
    }

    private void put(Nodo nodo, String key, String value) {
        if (nodo.key.equals(key)) {
            nodo.value = value;
        } else {
            if(nodo.key.compareTo(key)>0){
                //izq
                if (nodo.hijoIzquierdo == null) {
                    nodo.hijoIzquierdo = new Nodo(key, value);
                } else {
                    put(nodo.hijoIzquierdo, key, value);
                }
            } else {
                //dcha
                if (nodo.hijoDerecho == null) {
                    nodo.hijoDerecho = new Nodo(key, value);
                } else {
                    put(nodo.hijoDerecho, key, value);
                }
            }
        }

    }

    @Override
    public String get(String key) {
        if(root==null){
            return null;
        }
        return get(root, key);
    }

    private String get(Nodo nodo, String key) {
        if(nodo == null) return null;
        if(nodo.key.equals(key)) return nodo.value;
        if(nodo.key.compareTo(key)>0){
            return  get(nodo.hijoIzquierdo, key);
        } else {
            return  get(nodo.hijoDerecho, key);
        }
    }

    @Override
    public String remove(String key) {
        return "";
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Nodo nodo) {
        if(nodo == null) return 0;
        return 1 + size(nodo.hijoIzquierdo) + size(nodo.hijoDerecho);
    }
}
