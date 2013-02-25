import java.util.*;
public class Solution{
    public static Node cloneGraph(Node graph){
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node graphClone = new Node();
        map.put(graph, graphClone);
        LinkedList<Node> q = new LinkedList<Node>();
        q.push(graph);
        while(!q.isEmpty()){
            Node curr = q.poll();
            int n = curr.neighbors.size();
            for(int i = 0; i < n; i++){
                Node neighbor = curr.neighbors.get(i);
                if(!map.containsKey(neighbor)){
                    Node p = new Node();
                    map.get(curr).neighbors.push(p);
                    map.put(neighbor, p);
                    q.push(neighbor);
                }else{
                    map.get(curr).neighbors.push(map.get(neighbor));
                }
            }
        }
        return graphClone;
    }
    public static void main(String args[]){
    }
}
