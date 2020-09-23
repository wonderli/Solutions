import java.util.*;
public class Solution2{
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node n = queue.poll();
                curr.add(n.val);
                for(Node e : n.children){
                    queue.add(e);
                }
            }
            ret.add(curr);
        }
        return ret;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
