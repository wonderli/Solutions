import java.util.*;
public class Solution3{
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node n : node.neighbors){
            Node e = cloneGraph(n);
            newNode.neighbors.add(e);
        }

        return newNode;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
