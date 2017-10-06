public class BST {
	public static  Node root;
	
	public BST(){
		this.root = null;
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
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.value!=id){
			parent = current;
			if(current.value>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
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
		BST tree = new BST();
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
		System.out.println("Delete Node with no children (2) : " + tree.delete(2));		
		tree.display(root);
		System.out.println("\n Delete Node with one child (4) : " + tree.delete(4));		
		tree.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + tree.delete(10));		
		tree.display(root);
	}
}

class Node{
	int value;
	Node left;
	Node right;	
	public Node(int data){
		this.value = data;
		left = null;
		right = null;
	}
}