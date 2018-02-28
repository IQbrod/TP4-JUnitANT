package datastruct;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	protected MyUnsortedList<Integer> lst;
	
	@Before
	public void setUp() throws Exception {
		lst = new MyUnsortedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTailleAppendPoPInsertRemove() throws EmptyListException {
		assertEquals(0,lst.size());
		lst.append(18);
		assertEquals(1,lst.size());
		lst.insert(12, 1); //INSERT LAST
		assertEquals(2,lst.size());
		lst.insert(42, 1); //INSERT MID
		assertEquals(3, lst.size());
		lst.insert(46, 0); //INSERT FIRST
		assertEquals(4, lst.size());
		
		lst.remove(0); //RMV FIRST
		assertEquals(3, lst.size());
		lst.remove(1); //RMV MID
		assertEquals(2, lst.size());
		lst.remove(1); //RMV LAST
		assertEquals(1, lst.size());
		lst.pop();
		assertEquals(0, lst.size());
	}
	
	@Test
	public void testIsEmptyAppendPop() throws EmptyListException {
		assertTrue(lst.isEmpty());
		lst.append(12);
		assertFalse(lst.isEmpty());
		lst.pop();
		assertTrue(lst.isEmpty());		
	}
	
	@Test
	public void testIsEmptyInsertRemove() {
		assertTrue(lst.isEmpty());
		lst.insert(42,0);
		assertFalse(lst.isEmpty());
		lst.insert(43,1);
		assertFalse(lst.isEmpty());
		for (int i=0;i<30;i++) {
			lst.insert(i,1);
			assertFalse(lst.isEmpty());
		}
		for (int i=0;i<31;i++) {
			lst.remove(1);
			assertFalse(lst.isEmpty());
		}
		lst.remove(0);
		assertTrue(lst.isEmpty());		
	}

}
