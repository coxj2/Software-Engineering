import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testTree(){
		LCA tree = new LCA();
		assertNotEquals(null, tree);
	}
	
	@Test
	public void testNullTree(){
		LCA nullTree = null;
		assertEquals(nullTree, null);
	}
	
	@Test
	public void testNode(){
		LCA test = new LCA();
		test.root = new Node(4);
		test.root.right = new Node(6);
		test.root.left = new Node(2);
		assertNotEquals(null, test.root);
		assertNotEquals(null, test.root.right);
		assertNotEquals(null, test.root.left);
	}
	
	@Test
	public void testNullNode(){
		LCA nullRootTree = new LCA();
		nullRootTree.root = null;
		assertEquals(nullRootTree.root, null);
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
	public void testNonExistentValue(){
		LCA testTree = new LCA();
		testTree.root = new Node(4);
		testTree.root.right = new Node(6);
		testTree.root.left = new Node(2);
		Node lca = testTree.findlca(testTree.root, 3, testTree.root.right.value);
		assertEquals(4, lca.value);
	}
}
