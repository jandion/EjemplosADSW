package tema2.diccionarios.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tema2.diccionarios.DiccionarioBST;

class TestBST {

    private static DiccionarioBST diccionario;

    @BeforeEach
    void setUp() {
        diccionario = new DiccionarioBST();
    }

    @BeforeAll
    static void beforeAll() {
        diccionario = new DiccionarioBST();
    }

    @Test
    void testPutAndGet() {
        diccionario.put("clave1", "valor1");
        diccionario.put("clave2", "valor2");
        diccionario.put("clave3", "valor3");

        assertEquals("valor1", diccionario.get("clave1"));
        assertEquals("valor2", diccionario.get("clave2"));
        assertEquals("valor3", diccionario.get("clave3"));
        assertNull(diccionario.get("clave4"));
    }

    @Test
    void testUpdateValue() {
        diccionario.put("clave1", "valor1");
        diccionario.put("clave1", "nuevoValor");

        assertEquals("nuevoValor", diccionario.get("clave1"));
    }

    @Test
    void testRemove() {
        diccionario.put("d", "4");
        diccionario.put("b", "2");
        diccionario.put("f", "6");
        diccionario.put("a", "1");
        diccionario.put("c", "3");
        diccionario.put("e", "5");
        diccionario.put("g", "7");

        // Eliminar un nodo hoja
        assertEquals("1", diccionario.remove("a"));
        assertNull(diccionario.get("a"));
        assertEquals(6, diccionario.size());

        // Eliminar un nodo con un solo hijo
        assertEquals("6", diccionario.remove("f"));
        assertNull(diccionario.get("f"));
        assertEquals(5, diccionario.size());

        // Eliminar un nodo con dos hijos
        assertEquals("4", diccionario.remove("d"));
        assertNull(diccionario.get("d"));
        assertEquals(4, diccionario.size());

        // Eliminar la raíz
        diccionario.put("h", "8");
        assertEquals("7", diccionario.remove("g"));
        assertNull(diccionario.get("g"));
        assertEquals(4, diccionario.size());

        assertEquals("2", diccionario.remove("b"));
        assertEquals("3", diccionario.remove("c"));
        assertEquals("5", diccionario.remove("e"));
        assertEquals("8", diccionario.remove("h"));
        assertEquals(0, diccionario.size());
    }

    @Test
    void testSize() {
        assertEquals(0, diccionario.size());

        diccionario.put("clave1", "valor1");
        diccionario.put("clave2", "valor2");

        assertEquals(2, diccionario.size());
    }

    @Test
    void testAltura() {
        assertEquals(0, diccionario.altura());

        diccionario.put("c", "1");
        diccionario.put("a", "2");
        diccionario.put("b", "3");
        diccionario.put("e", "4");
        diccionario.put("d", "5");

        assertEquals(3, diccionario.altura());
    }
}