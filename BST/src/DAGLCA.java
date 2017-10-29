import java.util.Arrays;

public class DAGLCA <Value> {
	private Node[] list = new DAGLCA.Node[0];
	
	private class Node {
		private Value val;					// Value stored in Node
		private Node[] successors;			// Array of Nodes' successors
	
		public Node(Value val) {
			this.val = val;
		}
	}
	
	public boolean isEmpty() { 
		return size() == 0;
	}

	public int size() { 
		return list.length; 
	}
	
	// Checks whether Node n is in the DAG
	public boolean contains(Value v) {
		boolean inList = false;
		for (int i = 0; i < list.length; i++) {
			if (list[i].val == v) {
				inList = true;
				break;
			}			
		}
		return inList;
	}
	
	// Add function
	public void put(Value v, Node from, Node to) {	
		Node input = new Node(v);
		if (from != null) {
			from.successors = extendArrayByOne(from.successors);
			from.successors[from.successors.length-1] = input;
		}
		
		if (to != null) {
			input.successors = extendArrayByOne(input.successors);
			input.successors[input.successors.length-1] = to;
		}
		
		list = extendArrayByOne(list);
		list[list.length-1] = input;		
	}
	
	public Node[] extendArrayByOne(Node[] original) {
		Node[] arrayCopy = new DAGLCA.Node[original.length+1];
		System.arraycopy(original, 0, arrayCopy, 0, original.length);
		return arrayCopy;
	}
	
	//Delete function
	public void deleteNode(Node input) {
		int i;
		for(i = 0; i < input.successors.length; i++) {
			input.successors[i] = null;
		}
		
		for(i = 0; i < list.length; i++) {
			if (Arrays.asList(list[i].successors).contains(input) == true) {
				for (int j = 0; j < list[i].successors.length; j++) {
					if (list[i].successors[j] == input) {
						list[i].successors[j] = null;
					}
				}
			}
		}
		
		for (int k = 0; k < list.length; k++) {
			if (list[k] == input) {
				list[k] = null;
			}
		}		
	}
}