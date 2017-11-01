import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class DAGLCATest {
	DAGLCA<Node> dagA = new DAGLCA<Node>();
	ArrayList<Node> a;

	

	@Test
	public void test() {
		a = new ArrayList<>();
		dagA = new DAGLCA<Node>();
		//assertNull("Testing Null DAG and ArrayList",dagA.lowestCommonAncestor(a.get(9), a.get(8)));
		
		a = new ArrayList<>();
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
		 assertEquals("a(a9,a8) = a6", a.get(6), dagA.lowestCommonAncestor(a.get(9), a.get(8)));
		 assertEquals("a(a8,a4) = a2", a.get(2), dagA.lowestCommonAncestor(a.get(8), a.get(4)));
		 assertEquals("a(a8,a3) = a0", a.get(0), dagA.lowestCommonAncestor(a.get(8), a.get(3)));

	}

}