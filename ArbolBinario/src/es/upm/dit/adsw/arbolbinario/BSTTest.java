package es.upm.dit.adsw.arbolbinario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTest {
	private BST bst;

	@BeforeEach
	void setUp() {
		bst = new BST();
	}

	@Test
	void testInsertar() {
		ElementoDiccionario elemento = new ElementoDiccionario(1, "Test");
		bst.insertar(elemento);
		assertTrue(bst.buscar(1));
	}

	@Test
	void testBuscar() {
		ElementoDiccionario elemento = new ElementoDiccionario(1, "Test");
		bst.insertar(elemento);
		assertTrue(bst.buscar(1));
		assertFalse(bst.buscar(2));
	}

	@Test
	void testEliminar() {
		ElementoDiccionario elemento = new ElementoDiccionario(1, "Test");
		bst.insertar(elemento);
		bst.eliminar(1);
		assertFalse(bst.buscar(1));
	}

	@Test
	void testGetAltura() {
		ElementoDiccionario elemento1 = new ElementoDiccionario(1, "Test1");
		ElementoDiccionario elemento2 = new ElementoDiccionario(2, "Test2");
		bst.insertar(elemento1);
		bst.insertar(elemento2);
		assertEquals(2, bst.getAltura());
	}
}