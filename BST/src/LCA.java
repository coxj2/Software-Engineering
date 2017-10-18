import java.util.InputMismatchException;
import java.util.Scanner;

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

	/*public static void main(String arg[]){ 
		LCA tree = new LCA();
		Scanner input = new Scanner(System.in);
		try{
		tree.root = new Node(12);
		tree.root.left = new Node(8);
		tree.root.right = new Node(16);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(10);
		tree.root.right.left = new Node(14);
		tree.root.right.right = new Node(18);
		tree.root.left.left.left = new Node(4);
		tree.root.left.left.right = new Node(7);
		System.out.println("Requires an lca 0 < lca < 18");
		System.out.println("If a value is entered that is not already present in the tree, this"
				+ " value will be created in a new Node");
		System.out.println("Enter the first value: ");
		int n1 = input.nextInt();
		System.out.println("Enter the second value: ");
		int n2 = input.nextInt();
		Node lca = tree.findlca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.value);
		}
		catch (InputMismatchException e){
		    System.err.println("IndexOutOfBoundsException: " + "Values must be positive whole numbers " + e.getMessage());
		}
		catch (Exception e) {
		    System.err.println("IndexOutOfBoundsException: " + "Values must be within set parameters " + e.getMessage());
		} 
	}*/
}