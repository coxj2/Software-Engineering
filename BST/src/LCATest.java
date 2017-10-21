import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test 
	// Testing Constructor
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
	//Testing Node
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
		assertEquals(nullRootTree.root, null);
	}
	
	@Test
	//Testing performance of Lowest Common Ancestor (LCA) recursive function traversing both left and right 
	//and also testing null nodes
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
	//Testing LCA function with null left and right nodes
	public void testFindLCA2(){
		LCA nullRightNode = new LCA();
		nullRightNode.root = new Node(4);
		nullRightNode.root.right = null;
		Node lca = nullRightNode.findlca(nullRightNode.root.right, 5, 3);
		assertEquals(null, lca);
		
		LCA nullLeftNode = new LCA();
		nullLeftNode.root = new Node(8);
		nullLeftNode.root.left = null;
		Node lca2 = nullLeftNode.findlca(nullLeftNode.root, 5, 3);
		assertEquals(null, lca2);
	}
	
	@Test
	//Testing the programs ability to deal with negative values
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
	//Testing programs ability to calculate the LCA of values that do not already exist in the tree
	public void testNonExistentValue(){
		LCA testTree = new LCA();
		testTree.root = new Node(4);
		testTree.root.right = new Node(6);
		testTree.root.left = new Node(2);
		Node lca = testTree.findlca(testTree.root, 3, testTree.root.right.value);
		assertEquals(4, lca.value);
	}
	
	@Test
	//Testing the programs ability to read string values in comparison with integer values
	public void testInputError(){
		LCA tree = new LCA();
		tree.root = new Node(4);
		tree.root.right = new Node(6);
		tree.root.left = new Node(2);
		String lca = "4";
		assertNotEquals(4, lca);
	}
}
