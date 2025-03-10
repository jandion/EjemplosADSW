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
        return remove(root, key);
    }

    private String remove(Nodo nodo, String key) {
        if (nodo== null) return null;
        if (nodo.key.equals(key)) {
            // he encontrado lo que buscaba
            if (nodo.hijoIzquierdo == null && nodo.hijoDerecho == null) {
                // lo borro directamente

                // buscamos al padre
                Nodo padre = root;
                while(!padre.hijoIzquierdo.equals(nodo) || !padre.hijoDerecho.equals(nodo)) {
                    if (padre.key.compareTo(key)>0){
                        padre = padre.hijoIzquierdo;
                    } else {
                        padre = padre.hijoDerecho;
                    }
                }

                if(padre.hijoIzquierdo.equals(nodo)){
                    padre.hijoIzquierdo = null;
                } else {
                    padre.hijoDerecho = null;
                }
                return nodo.value;
            } else if (nodo.hijoIzquierdo == null || nodo.hijoDerecho == null) {
                // lo sustituyo por el hijo
                String temp  = nodo.value;
                if (nodo.hijoIzquierdo == null) {
                    nodo.key = nodo.hijoDerecho.key;
                    nodo.value = nodo.hijoDerecho.value;
                    nodo.hijoDerecho = null;
                } else {
                    nodo.key = nodo.hijoIzquierdo.key;
                    nodo.value = nodo.hijoIzquierdo.value;
                    nodo.hijoIzquierdo = null;
                }
                return temp;
            } else {
                // buscamos el mayor nieto por la izquierda
                Nodo actual = nodo.hijoIzquierdo;
                while( actual.hijoDerecho!=null){
                    actual = actual.hijoDerecho;
                }
                // sustuir nodo por actual

                if (actual.hijoIzquierdo == null) {
                    // lo puedo borrar directamente
                    // TODO: lo mismo que antes
                    return null;
                } else {
                    // lo sustituyo por el hijo
                    nodo.key = actual.key;
                    nodo.value = actual.value;
                    actual.key = actual.hijoIzquierdo.key;
                    actual.value = actual.hijoIzquierdo.value;
                    actual.hijoIzquierdo = null;
                }
                return nodo.value;
            }
        } else {
            if (nodo.key.compareTo(key)>0){
                return remove(nodo.hijoIzquierdo, key);
            } else {
                 return remove(nodo.hijoDerecho, key);
            }
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Nodo nodo) {
        if(nodo == null) return 0;
        return 1 + size(nodo.hijoIzquierdo) + size(nodo.hijoDerecho);
    }

    public int altura(){
        if (root==null) return 0;
        return altura(root);
    }

    private int altura(Nodo nodo) {
        if(nodo == null) return 0;
        return 1 + Math.max(altura(nodo.hijoIzquierdo), altura(nodo.hijoDerecho));
    }

    public void recorridoEnOrden() {
        recorridoEnOrden(root);
    }
    private void recorridoEnOrden(Nodo nodo) {
        if (nodo == null) return;
        recorridoEnOrden(nodo.hijoIzquierdo);
        System.out.println(nodo.key + " "+ nodo.value);
        recorridoEnOrden(nodo.hijoDerecho);
    }
    public void recorridoPreorden() {
        recorridoPreorden(root);
    }
    private void recorridoPreorden(Nodo nodo) {
        if (nodo == null) return;
        System.out.println(nodo.key + " "+ nodo.value);
        recorridoPreorden(nodo.hijoIzquierdo);
        recorridoPreorden(nodo.hijoDerecho);
    }
    public void recorridoPostorden() {
        recorridoPostorden(root);
    }
    private void recorridoPostorden(Nodo nodo) {
        if (nodo == null) return;
        recorridoPostorden(nodo.hijoIzquierdo);
        recorridoPostorden(nodo.hijoDerecho);
        System.out.println(nodo.key + " "+ nodo.value);
    }
}
