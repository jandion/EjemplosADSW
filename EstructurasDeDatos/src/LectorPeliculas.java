import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LectorPeliculas {
	
	private static final Logger LOGGER= Logger.getLogger("MyLog");;

	public static void main(String[] args) throws Exception {
		 
		LOGGER.setLevel(Level.ALL);
		
		Handler ch = new ConsoleHandler();
		ch.setLevel(Level.FINE);
		
		Handler fh = new FileHandler("myLog.txt");
		
		fh.setFormatter(new SimpleFormatter());
		fh.setLevel(Level.ALL);
		
		LOGGER.addHandler(ch);
		LOGGER.addHandler(fh);

		List<String> lineas = getLineasDeArchivo("peliculas.tsv");

		LOGGER.severe("Finalizada la lectura del archivo");
		Map<String, List<String>> peliculas = crearDiccionarioPeliculas(lineas);
		LOGGER.warning("Creado el diccionario de peliculas");
		LOGGER.info(""+peliculas.get("Requiem for a Dream"));

		Set<String> actoresUnicos = calculaConjuntoActores(peliculas);
		LOGGER.info("Actores únicos: "+actoresUnicos.size());

		Map<String, List<String>> actorPelicula = invierteDiccionarioPeliculas(peliculas);
		LOGGER.fine(""+actorPelicula.size());


	}

	public static Map<String, List<String>> invierteDiccionarioPeliculas(Map<String, List<String>> peliculas) {
		Map<String,List<String>> actorPelicula = new HashMap<String, List<String>>();

		for(String titulo : peliculas.keySet()) {
			for ( String actor : peliculas.get(titulo)) {
				if (! actorPelicula.containsKey(actor)) {
					actorPelicula.put(actor, new ArrayList<String>());
				}
				actorPelicula.get(actor).add(titulo);
			}
		}
		return actorPelicula;
	}

	public static Set<String> calculaConjuntoActores(Map<String, List<String>> peliculas) {
		Set<String> actoresUnicos = new HashSet<>();

		long t0 = System.currentTimeMillis();
		for(String titulo : peliculas.keySet()) {
			actoresUnicos.addAll(peliculas.get(titulo));

		}
		LOGGER.finest("Ha tardado: "+ (System.currentTimeMillis()-t0));
		return actoresUnicos;
	}

	public static Map<String, List<String>> crearDiccionarioPeliculas(List<String> lineas) {
		Map<String,List<String>> peliculas = new HashMap<>();
		for(String pelicula : lineas) {
			String[] columnas = pelicula.split("\t");
			if (columnas.length <16) continue;
			String titulo = columnas[0];
			String[] actores = columnas[16].split(",");
			List<String> listaActores = Arrays.asList(actores);
			peliculas.put(titulo, listaActores);

		}
		return peliculas;
	}

	public static List<String> getLineasDeArchivo(String fileName) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String line = br.readLine();

		List<String> lineas = new ArrayList<>();

		while( line != null ) {
			lineas.add(line);
			line = br.readLine();
		}


		return lineas;
	}

	public static Integer getMaxPeliculas(Map<String, List<String>> actorPelicula) {
		// TODO Auto-generated method stub
		return null;
	}
}
