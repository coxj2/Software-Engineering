import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	@Test 
	public void createNode(){
		int value = 0;
		Node left = null;
		Node right = null;
	}
	
	@Test
	public void testFindLCA(){
		LCA testTree = new LCA();
		testTree.root = new Node(8);
		testTree.root.left = new Node(5);
		testTree.root.right = new Node(11);
		testTree.root.left.left = new Node(3);
		testTree.root.left.right = new Node(6);
		testTree.root.right.left = new Node(9);
		testTree.root.right.right = new Node(13);
		
		assertNotEquals("5", testTree.findlca(testTree.root, testTree.root.left.left.value, testTree.root.left.right.value));
		assertNotEquals("11", testTree.findlca(testTree.root, testTree.root.right.left.value, testTree.root.right.right.value));
	}
	
	@Test
	public void testEmpty(){
		LCA nullTree = null;
		assertNull(nullTree);
		
		LCA testTree = new LCA();
		assertNotNull(testTree);
		
		LCA nullRootTree = new LCA();
		nullRootTree.root = null;
		assertNull(nullRootTree.root);

		LCA testTree1 = new LCA();
		testTree1.root = new Node(5);
		testTree1.root.right = new Node(8);
		testTree1.root.left = new Node(2);
		assertNotNull(testTree1.root);
		assertNotNull(testTree1.root.right);
		assertNotNull(testTree1.root.left);
	}

}
