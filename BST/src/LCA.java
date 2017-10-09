public class LCA {
	Node root;
	class Node{
		int value;
		Node left;
		Node right;	
		Node(int data){
			value = data;
			left = null;
			right = null;
		}
	}
	
	
	Node lca(Node node, int n1, int n2) 
	{
	        if (node == null)
	            return null;
	  
	        // If both n1 and n2 are smaller than root, then LCA lies in left
	        if (node.value > n1 && node.value > n2)
	            return lca(node.left, n1, n2);
	  
	        // If both n1 and n2 are greater than root, then LCA lies in right
	        if (node.value < n1 && node.value < n2) 
	            return lca(node.right, n1, n2);
	  
	        return node;
	}
	
	
	
	public boolean find(int node){
		Node current = root;
		while(current != null){
			if(current.value == node){
				return true;
			}
			else if(current.value > node){
				current = current.left;
			}
			else{
				current = current.right;
			}
		}
		return false;
	}
	
	public void insert(int value){
		Node newNode = new Node(value);
		if(root == null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(value < current.value){				
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			}
			else{
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.value);
			display(root.right);
		}
	}
	public static void main(String arg[]){
		LCA tree = new LCA();
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(4);
		tree.insert(6);
		tree.insert(2);
		tree.insert(10);
		tree.insert(9);
		tree.insert(20);
		tree.insert(25);
		tree.insert(15);
		tree.insert(16);
		System.out.println("Test 1");
		System.out.println("Original Tree : ");
		tree.display(tree.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + tree.find(4));
		//tree.display(root);
		//tree.display(root);
		//tree.display(root);
	}
}
