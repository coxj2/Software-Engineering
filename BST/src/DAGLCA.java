import java.util.ArrayList;
import java.util.Stack;

	class Node {
	int data;
    Node left, right;
    ArrayList<Node> nodeList;
    
    Node(int value) { 
        data = value;
        left = right = null;
        nodeList = new ArrayList<Node>();
    }
    
    public void addEdge(Node e) {
        nodeList.add(e);
    }
}

public class DAGLCA<T> {
    
   private Node root;
    
    public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	//Depth first search method
	private ArrayList<Node> DFS(Node node, Node toFind, ArrayList<Node> list, Stack<Node> stack) { 
        stack.push(node);
        for (Node theNode : node.nodeList) {
            if (theNode.equals(toFind)) {
                list.addAll(stack);
                return list;
            }
            DFS(theNode, toFind, list, stack);
        }
        stack.pop();
        return list;
    }
	

	
	
    public Node lca(Node n1, Node n2) {
    	if(getRoot() == null || n1 == null || n2 == null) 
    		return null;
        return lca(getRoot(), n1, n2);
    }

    private Node lca(Node node, Node n1, Node n2) {
        ArrayList<Node> list1;
        ArrayList<Node> list2;
        ArrayList<Node> minList;
        ArrayList<Node> maxList;
        ArrayList<Node> output;
        list1 = DFS(node, n1, new ArrayList<>(), new Stack<>());
        list2 = DFS(node, n2, new ArrayList<>(), new Stack<>());
        if (list1 == null || list2 == null) {
            return null;
        }
        
        if (list1.size() <= list2.size()) {
            minList = list1;
            maxList = list2;
        } 
        else {
            minList = list2;
            maxList = list1;
        }
        output = new ArrayList<>();
        for (Node n : minList) {
            output.add(n);
        }
        for (int i = maxList.size()-1; i >= 0; i--) {
            if (output.contains(maxList.get(i))) {
                return maxList.get(i);
            }
        }
        return null;
    }	
}