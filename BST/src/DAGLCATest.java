import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class DAGLCATest {

	@Test
	public void testLca() {
		DAGLCA<Node> dagA = new DAGLCA<Node>();
		ArrayList<Node> testList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			testList.add(new Node(i));
		}
		dagA.setRoot(testList.get(0));
		testList.get(0).addEdge(testList.get(1));
		testList.get(0).addEdge(testList.get(2));
		testList.get(1).addEdge(testList.get(3));
		testList.get(1).addEdge(testList.get(4));
		testList.get(2).addEdge(testList.get(4));
		testList.get(2).addEdge(testList.get(5));
		testList.get(2).addEdge(testList.get(6));
		testList.get(5).addEdge(testList.get(8));
		testList.get(6).addEdge(testList.get(8));
		testList.get(6).addEdge(testList.get(7));
		testList.get(6).addEdge(testList.get(9));
		testList.get(7).addEdge(testList.get(9));
		assertEquals(testList.get(6), dagA.lca(testList.get(9), testList.get(8)));
		assertEquals(testList.get(2), dagA.lca(testList.get(8), testList.get(4)));
		assertEquals(testList.get(0), dagA.lca(testList.get(8), testList.get(3)));
		assertNotEquals(testList.get(0), dagA.lca(null, testList.get(8)));
		assertNotEquals(testList.get(0), dagA.lca(testList.get(8), null));
		assertNotEquals(null, dagA.lca(testList.get(8), testList.get(9)));
	}

	@Test
	public void testRoot(){
		DAGLCA<Node> testDag = new DAGLCA<Node>();
		assertEquals(testDag.getRoot(), null);
		
		ArrayList<Node> testList = new ArrayList<>();
		testList.add(new Node(3));
		testDag.setRoot(testList.get(0));
		assertNotEquals(testDag.getRoot(), null);
	}

}