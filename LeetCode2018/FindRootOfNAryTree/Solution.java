import java.util.*;
class Solution {
    private class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public Node findRoot(List<Node> tree) {
        if(tree == null || tree.isEmpty()) return null;
        Set<Node> seen = new HashSet<>();
        for(Node e : tree){
            for(Node c : e.children){
                seen.add(c);
            }
        }
        for(Node n : tree){
            if(!seen.contains(n)){
                return n;
            }
        }
        return null;
    }
}
