import java.util.*;
public class Solution{
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<Node> curr = new LinkedList<>();
        curr.add(root);
        Queue<Node> next = new LinkedList<>();
        List<Integer> c = new ArrayList<>();
        while(!curr.isEmpty()){
            Node n = curr.poll();
            c.add(n.val);
            List<Node> children = n.children;
            if(children != null){
                next.addAll(children);
            }
            if(curr.isEmpty()){
                curr = next;
                next = new LinkedList<>();
                ret.add(c);
                c = new ArrayList<>();
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        List<Node> r = new ArrayList<>();
        r.add(new Node(5, null));
        r.add(new Node(6, null));

        List<Node> l = new ArrayList<>();
        l.add(new Node(3, r));
        l.add(new Node(2, null));
        l.add(new Node(4, null));
        Node root = new Node(1, l);
        List<List<Integer>> res = sol.levelOrder(root);
        for(List<Integer> curr : res){
            System.out.println(curr);
        }

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
