import java.util.*;
public class Solution4{
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(Node e : n.neighbors){
                if(!visited.containsKey(e)){
                    visited.put(e, new Node(e.val));
                    queue.add(e);
                }
                visited.get(n).neighbors.add(visited.get(e));
            }
        }
        return visited.get(node);
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
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
