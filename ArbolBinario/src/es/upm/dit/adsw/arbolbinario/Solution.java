import java.io.*;
import java.util.*;

/**
En sus memorias "So, Anyway", el comediante John Cleese escribe sobre la diferencia de clases entre su padre (quien era "clase media-media-media-baja") y su madre (quien era "clase alta-alta-baja-media"). Estas distinciones tan finas entre clases tienden a confundir a los lectores norteamericanos, por lo que se te pide escribir un programa para ordenar a un grupo de personas por sus clases para mostrar su verdadero lugar en la jerarquía de clases sociales.

Para este problema, hay tres clases principales: alta, media y baja. Obviamente, la más alta es la alta y la más baja es la baja. Pero puede haber distinciones dentro de una clase, por lo que alta-alta es una clase más alta que alta-media, que es más alta que alta-baja. Sin embargo, todas las clases altas (alta-alta, alta-media y alta-baja) son más altas que cualquiera de las clases medias.

Dentro de una clase como alta-media, también puede haber más distinciones, llevando a clases como alta-media-alta-media-baja. Al comparar clases, una vez que se ha alcanzado el nivel más bajo de detalle, se debe asumir que todas las clases adicionales son iguales al nivel medio del nivel anterior de detalle. Así, la clase alta y la clase alta-media son equivalentes, al igual que media-baja-media-media y media-baja.

Input Format

La primera línea de entrada contiene un entero positivo n que indica el número de personas a considerar. Cada una de las siguientes líneas contiene el nombre de una persona seguido de dos puntos y un espacio, seguido por la clase de la persona. El nombre contiene hasta 30 caracteres en minúsculas. La clase es una cadena que consiste en una secuencia no vacía de hasta 10 palabras entre alta, media, baja separadas por guiones (-), seguida de un espacio, seguida de la palabra clase. No habrá dos personas con el mismo nombre en un solo caso.

Constraints

n<100

Output Format

Para cada caso de prueba, imprime la lista de nombres de la clase más alta a la más baja. Si dos personas tienen clases iguales o equivalentes, deben listarse en orden alfabético por nombre. Imprime una línea de 30 signos iguales (=) después de cada caso.

Sample Input 0

5
mama: clase media-baja-alta-alta
papa: clase media-baja-media-media-media
lareinadeinglaterra: clase alta-alta-alta
lasilla: clase baja-baja
eltiobob: clase media-baja-media-media
Sample Output 0

lareinadeinglaterra
mama
papa
eltiobob
lasilla
 */

class Persona implements Comparable<Persona> {
        String nombre;
        List<String> clase;

        public Persona(String nombre, String clase) {
            this.nombre = nombre;
            this.clase = new ArrayList<>();
            for(String c : clase.split("-")) {
                this.clase.add(c);
            }
        }

        String[] prioridad = {"alta", "media", "baja"};
        @Override
        public int compareTo(Persona p) {
            for (int i = 0; i < Math.min(this.clase.size(), p.clase.size()); i++) {
                int a = Arrays.asList(prioridad).indexOf(this.clase.get(i));
                int b = Arrays.asList(prioridad).indexOf(p.clase.get(i));
                if (a != b) {
                    return a - b;
                }
            }
            return this.nombre.compareTo(p.nombre);
        }
    
    }
public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Persona> personas = new ArrayList<>();
        while (n-- > 0) {
            String[] linea = scanner.nextLine().split(": clase ");
            personas.add(new Persona(linea[0], linea[1]));
        }
        scanner.close();
        Collections.sort(personas);
        for (Persona p : personas) {
            System.out.println(p.nombre);
        }
    }
}