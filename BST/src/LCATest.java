import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	@Test
	public void testConstructor(){
		LCA testTree = new LCA();
		testTree.root = new Node(2);
		testTree.root.value = 0;
		testTree.root.right = null;
		testTree.root.left = null;
	}
	
	@Test
	public void testNullNode(){
		LCA nullRootTree = new LCA();
		nullRootTree.root = null;
		assertEquals(nullRootTree.root, null);
		assertNull(nullRootTree.root);
	}
	
	@Test
	public void testFindLCA(){
		LCA testTree = new LCA();
		testTree.root = new Node(12);
		testTree.root.left = new Node(8);
		testTree.root.right = new Node(16);
		testTree.root.left.left = new Node(6);
		testTree.root.left.right = new Node(10);
		testTree.root.right.left = new Node(14);
		testTree.root.right.right = new Node(18);
		Node lca = testTree.findlca(testTree.root, testTree.root.left.left.value, testTree.root.left.right.value);
		assertEquals(8, lca.value);
		
		Node lca2 = testTree.findlca(testTree.root, testTree.root.right.right.value, testTree.root.right.left.value);
		assertEquals(16, lca2.value);
		
		Node lca3 = testTree.findlca(null, testTree.root.right.value, testTree.root.left.value);
		assertEquals(null, lca3);
	}
	
	@Test
	public void testNegativeNumbers(){
		LCA testTree = new LCA();
		testTree.root = new Node(0);
		testTree.root.left = new Node(-4);
		testTree.root.right = new Node(4);
		testTree.root.left.right = new Node(-2);
		testTree.root.left.left = new Node(-6);
		Node lca = testTree.findlca(testTree.root, testTree.root.left.left.value, testTree.root.left.right.value);
		assertEquals(-4, lca.value);
	}
	
	@Test
	public void testEmpty(){
		LCA nullTree = null;
		assertEquals(nullTree, null);
		
		LCA testTree = new LCA();
		assertNotEquals(testTree, null);
		
		LCA testTree1 = new LCA();
		testTree1.root = new Node(5);
		testTree1.root.right = new Node(8);
		testTree1.root.left = new Node(2);
		assertNotEquals(testTree1.root, null);
		assertNotEquals(testTree1.root.right, null);
		assertNotEquals(testTree1.root.left, null);
	}
}
