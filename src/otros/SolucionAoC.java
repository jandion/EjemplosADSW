package otros;

import java.io.*;
import java.util.List;

public class SolucionAoC {

    public static void main(String[] args) {
        // Hay que colocar el archivo input.txt con la entrada del problema en la raíz del proyecto
        try {
            List<String> input = new BufferedReader(new FileReader("input.txt")).lines().toList();
            System.out.println("La solución de la parte 1 es: " + parte1(input));
            System.out.println("La solución de la parte 2 es: " + parte2(input));
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo o no se puede abrir");
            System.err.println("Ponlo en la raíz del proyecto y llámalo input.txt");
            throw new RuntimeException(e);
        }
    }

    public static long parte1(List<String> input) {

        return input.size();
    }

    public static long parte2(List<String> input) {

        return 0;
    }
}
