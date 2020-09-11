import java.util.*;
public class Solution{
    Map<Node, Node> cloneMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(cloneMap.get(node) != null){
            return cloneMap.get(node);
        }
        Node clone = new Node(node.val);
        cloneMap.put(node, clone);
        for(Node e : node.neighbors){
            Node eCloned = cloneGraph(e);
            clone.neighbors.add(eCloned);
        }
        return clone;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
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
