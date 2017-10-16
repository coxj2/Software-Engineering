class Node {
	int value;
	Node left;
	Node right;

	Node(int data) {
		value = data;
		left = null;
		right = null;
	}
}

public class LCA {
	Node root;

	public Node findlca(Node node, int n1, int n2) {
		if (node == null)
			return null;

		// LCA on left side
		if (node.value > n1 && node.value > n2)
			return findlca(node.left, n1, n2);

		// LCA on right side
		if (node.value < n1 && node.value < n2)
			return findlca(node.right, n1, n2);

		return node;
	}

	public static void main(String arg[]){ 
		/*LCA tree = new LCA();
		tree.root = new Node(12);
		tree.root.left = new Node(8);
		tree.root.right = new Node(16);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(10);
		tree.root.right.left = new Node(14);
		tree.root.right.right = new Node(18);
		tree.root.left.left.left = new Node(4);
		tree.root.left.left.right = new Node(7);
		int n1 = tree.root.left.left.left.value; //4
		int n2 = tree.root.left.left.right.value; //7
		Node lca = tree.findlca(tree.root, n1, n2); //6
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.value);
	*/
	}	
}