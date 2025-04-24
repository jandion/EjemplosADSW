package tema2.diccionarios;

import java.util.ArrayList;
import java.util.List;

class ClaveValor{
    public String clave, valor;
    public ClaveValor(String clave, String valor){
        this.clave = clave;
        this.valor = valor;
    }

    public String toString(){
        return "<"+clave+","+valor+">";
    }
}

public class DiccionarioArrayHashCerrado implements Diccionario{
    private List<ClaveValor>[] values;
    private int nElems;

    public static void main(String[] args) {
        DiccionarioArrayHashCerrado diccionario = new DiccionarioArrayHashCerrado(10);
        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");
        diccionario.put("monja", "hola");

        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");

        diccionario.put("mesa", "232435");


        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");

        diccionario.put("jamon", "mundo");

        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");
        diccionario.remove("jamon");

        diccionario.imprimir();
        System.out.println("El diccionario tiene "+ diccionario.size()+ " elementos");

    }

    public DiccionarioArrayHashCerrado(int size){
        values = new List[size];
    }

    @Override
    public void put(String key, String value) {
        int pos = hash(key);
        if (values[pos] == null) {
            values[pos] = new ArrayList<>();
            values[pos].add(new  ClaveValor(key, value));
            nElems++;
        } else {
            boolean encontrado = false;
            for(ClaveValor pareja: values[pos]){
                if (pareja.clave.equals(key)){
                    pareja.valor = value;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado){
                values[pos].add(new  ClaveValor(key, value));
                nElems++;
            }
        }
    }

    @Override
    public String get(String key) {
        int pos = hash(key);
        for(ClaveValor pareja: values[pos]){
            if (pareja.clave.equals(key)){
                return pareja.valor;
            }
        }
        return null;
    }

    @Override
    public String remove(String key) {

        int pos = hash(key);
        for(int i = 0; i < values[pos].size(); i++){
            if (values[pos].get(i).clave.equals(key)){
                String temp = values[pos].get(i).valor;
                values[pos].remove(i);
                nElems--;
                return temp;
            }
        }
        return null;
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
        return hash % values.length;
    }

    public void imprimir(){
        for(int i = 0; i < values.length; i++){
            System.out.print("Pos "+ i + " ");
            System.out.println(values[i]);
        }
    }
}
