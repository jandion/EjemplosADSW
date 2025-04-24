package tema1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyStack {

    private MyStack myStack = new MyStack();

    @BeforeAll
    public static void setUpClass() {

    }
    @BeforeEach
    public void setUp() {
        myStack = new MyStack();
    }

    @Test
    public void testCrearPila(){
        assertNull(myStack.pop());
        assertEquals(0, myStack.getNElements(), "No se ha creado bien la pila");
    }

    @Test
    public void testAddElement(){

    }

    @Test
    public void testRemoveElement(){
    }
}
