import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class LCA {

  static class Node{
    public final String name;
    public final HashSet<Edge> inEdges;
    public final HashSet<Edge> outEdges;
    public Node(String name) {
      this.name = name;
      inEdges = new HashSet<Edge>();
      outEdges = new HashSet<Edge>();
    }
    public Node addEdge(Node node){
      Edge e = new Edge(this, node);
      outEdges.add(e);
      node.inEdges.add(e);
      return this;
    }
  }

  static class Edge{
    public final Node from;
    public final Node to;
    public Edge(Node from, Node to) {
      this.from = from;
      this.to = to;
    }
  }
}