package es.upm.dit.adsw.diccionarios.arrays.desordenado;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

class PruebasDiccionarioPixel {

	@Test
	void testPut() {
		DiccionarioPixeles diccionario = new DiccionarioPixeles();
		Pixel p1 = new Pixel(new Point(0,0), new Color(3,2,1));
		diccionario.put(p1);
		assertEquals(p1, diccionario.elementos[0]);
		Pixel p2 = new Pixel(new Point(1,1), new Color(4,3,2));
		diccionario.put(p2);
		assertEquals(p2, diccionario.elementos[1]);
		for (int i = 2; i < diccionario.elementos.length; i++) {
			Pixel p = new Pixel(new Point((int)Math.random()*1000,(int)Math.random()*1000), new Color((int)Math.random()*255,(int)Math.random()*255,(int)Math.random()*255));
			diccionario.put(p);
		}
		assertNotEquals(null, diccionario.elementos[diccionario.elementos.length-1]);
	}

	@Test
	void testGet() {
		DiccionarioPixeles diccionario = new DiccionarioPixeles();
		Pixel p1 = new Pixel(new Point(0,0), new Color(3,2,1));
		diccionario.put(p1);
		assertEquals(p1.getValue(), diccionario.get(p1).getValue());
		Pixel p2 = new Pixel(new Point(1,1), new Color(4,3,2));
		assertNull(diccionario.get(p2));
		
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	@Test
	void testClear() {
		fail("Not yet implemented");
	}

}
