import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestLectorPeliculas {
	
	static List<String> lineas;
	static Map<String, List<String>> peliculas, actorPelicula;
	
	@BeforeAll
	public static void setUp() {
		try {
		lineas = LectorPeliculas.getLineasDeArchivo("peliculas.tsv");
		peliculas = LectorPeliculas.crearDiccionarioPeliculas(lineas);
	
		actorPelicula = LectorPeliculas.invierteDiccionarioPeliculas(peliculas);
		} catch (Exception e) {
			
		}
	}

	@Test
	void testGetLineasDeArchivo() {
		try {
			List<String> lineas = LectorPeliculas.getLineasDeArchivo("peliculas.tsv");
			assertEquals(599, lineas.size());
		} catch (Exception e) {
			fail("El método lanzó una excepción");
		}
	}
	
	@Test
	void testActorConMasPelis() {
	
			
			assertEquals(6, LectorPeliculas.getMaxPeliculas(actorPelicula));
	
		
	}
	

}
