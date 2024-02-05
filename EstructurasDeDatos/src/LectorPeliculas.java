import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorPeliculas {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("peliculas.tsv"));
		
		String line = br.readLine();
		
		List<String> lineas = new ArrayList<>();
		
		while( line != null ) {
			lineas.add(line);
			line = br.readLine();
		}
		
		System.out.println(lineas.size());
		
		Map<String,List<String>> peliculas = new HashMap<>();
		
		
		for(String pelicula : lineas) {
			String[] columnas = pelicula.split("\t");
			if (columnas.length <16) continue;
			String titulo = columnas[0];
			String[] actores = columnas[16].split(",");
			List<String> listaActores = Arrays.asList(actores);
			peliculas.put(titulo, listaActores);
			
		}
		
		peliculas.size();
		
		System.out.println(peliculas.get("Requiem for a Dream"));
		
	}
}
