import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {

	MyQueue cola;
	
	@Before
	public void setUp() {
		cola = new MyQueue(10);
	}
	
	@After
	public void tearDown() {
		cola = null;
	}
	
	
	@Test
	public void testAdd() {
		cola.add(10);
		assertEquals("No hab�a un solo elemento", 1,cola.size());
	}
	
	@Test
	public void testAddVarios() {
		cola.add(10);
		cola.add(10);
		assertEquals("No hab�a dos elementos", 2,cola.size());
	}	
	@Test
	public void testAddLimite() {
		for (int i = 0; i < 11; i++) {
			cola.add(10);
		}
		assertEquals("deber�a haber 10", 10,cola.size());
	}
	
	

	@Test
	public void testPoll() {
		assertNull("deber�a no tener elementos", cola.poll());
	}
	@Test
	public void testPoll1elem() {
		cola.add(10);
		assertTrue("deber�a ser 10", 10 == cola.poll());
		assertEquals("sigue habiendo elementos", 0, cola.size());
	}
	@Test
	public void testPollNelem() {
		for (int i = 0; i < 5; i++) {
			cola.add(i);
		}
		assertTrue("deber�a ser 0", 0 == cola.poll());
		assertEquals("sigue habiendo elementos", 4, cola.size());
	}

	@Test
	public void testPeek() {
		assertNull("deber�a no tener elementos", cola.peek());
	}
	@Test
	public void testPeek1elem() {
		cola.add(10);
		assertTrue("deber�a ser 10", 10 == cola.peek());
	}
	@Test
	public void testPeekNelem() {
		for (int i = 0; i < 5; i++) {
			cola.add(i);
		}
		assertTrue("deber�a ser 0", 0 == cola.peek());
	}

}
