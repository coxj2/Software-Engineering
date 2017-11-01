import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class DAGLCATest {

	@Test
	public void testLca() {
		DAGLCA<Node> dagA = new DAGLCA<Node>();
		ArrayList<Node> a = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			a.add(new Node(i));
		}
		dagA.setRoot(a.get(0));
		a.get(0).addEdge(a.get(1));
		a.get(0).addEdge(a.get(2));
		a.get(1).addEdge(a.get(3));
		a.get(1).addEdge(a.get(4));
		a.get(2).addEdge(a.get(4));
		a.get(2).addEdge(a.get(5));
		a.get(2).addEdge(a.get(6));
		a.get(5).addEdge(a.get(8));
		a.get(6).addEdge(a.get(8));
		a.get(6).addEdge(a.get(7));
		a.get(6).addEdge(a.get(9));
		a.get(7).addEdge(a.get(9));
		assertEquals(a.get(6), dagA.lca(a.get(9), a.get(8)));
		assertEquals(a.get(2), dagA.lca(a.get(8), a.get(4)));
		assertEquals(a.get(0), dagA.lca(a.get(8), a.get(3)));
		assertNotEquals(a.get(0), dagA.lca(null, a.get(8)));
		assertNotEquals(a.get(0), dagA.lca(a.get(8), null));
		assertNotEquals(null, dagA.lca(a.get(8), a.get(9)));
	}

	@Test
	public void testRoot(){
		DAGLCA<Node> testDag = new DAGLCA<Node>();
		assertEquals(testDag.getRoot(), null);
		
		ArrayList<Node> a = new ArrayList<>();
        a.add(new Node(3));
		testDag.setRoot(a.get(0));
		assertNotEquals(testDag.getRoot(), null);
	}

}